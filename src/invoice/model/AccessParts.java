package invoice.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jthomann on 10/24/16.
 */
public class AccessParts {
    private static Connection connection = DatabaseConnectionFactory.getInstance().getDatabaseConnection();

    private ResultSet parts;

    public boolean retrieveParts() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Part");
            ResultSet resultSet = statement.executeQuery();
            parts = resultSet;
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet getParts() {
        return parts;
    }

    public void setParts(ResultSet parts) {
        this.parts = parts;
    }


}
