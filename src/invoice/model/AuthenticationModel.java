package invoice.model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class AuthenticationModel {
	public static final int ITERATIONS = 10000;
	public static final int HASH_LENGTH = 128;

	public static String getLoginToken(String username, String password) {
		Connection connection = DatabaseConnectionFactory.getInstance().getDatabaseConnection();
		PreparedStatement statement = null;
		byte[] passwordHash = null,
				salt = null;
		
		if (connection != null) {
			try {
				statement = connection.prepareStatement("SELECT password_hash, salt " +
														"FROM user " +
														"WHERE user_name = ?");
				statement.setString(1, username);
				
				ResultSet rs = statement.executeQuery();
				if (rs != null && !rs.isClosed() && rs.next()) {
					passwordHash = Base64.getDecoder().decode(rs.getString("password_hash"));
					salt = Base64.getDecoder().decode(rs.getString("salt"));
				}
			} catch (SQLException e) {
				System.err.println("Error retrieving hash for comparison");
				e.printStackTrace();
			}
		}

		if (passwordHash != null && salt != null &&
				Arrays.equals(passwordHash, getHash(password.toCharArray(), salt))) {
			return "logged_in";
		}
		
		return null;
	}

	public static void registerUser(String username, String password, String firstName, String lastName) throws Exception {
		byte[] salt = generateSalt();
		byte[] passwordHash = getHash(password.toCharArray(), salt);
		
		Connection connection = DatabaseConnectionFactory.getInstance().getDatabaseConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("INSERT INTO user " +
													"(user_name, first_name, last_name, password_hash, salt) " +
													"VALUES (?, ?, ?, ?, ?)");
			statement.setString(1, username);
			statement.setString(2, firstName);
			statement.setString(3, lastName);
			statement.setString(4, Base64.getEncoder().encodeToString(passwordHash));
			statement.setString(5, Base64.getEncoder().encodeToString(salt));
			
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated != 1) {
				throw new SQLException("Update returned " + rowsUpdated + " instead of 1");
			}
		} catch (SQLException e) {
			throw new Exception("Error adding user to database\n" + e.toString() + "\n" + e.getMessage());
		}
	}
	
	private static byte[] getHash(char[] password, byte[] salt) {
		try {
			return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
					.generateSecret(new PBEKeySpec(password, salt, ITERATIONS, HASH_LENGTH))
					.getEncoded();
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
			// Both of these should work as soon as the code is working, no error
			// should be thrown unless backward compatibility breaks something
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	private static byte[] generateSalt() {
		byte[] salt = new byte[8];
		try {
			SecureRandom.getInstance("SHA1PRNG").nextBytes(salt);
		} catch (NoSuchAlgorithmException e) {
			// Same as above - once written, should work (barring backward compatibility problems)
			e.printStackTrace();
		}
		
		return salt;
	}
}
