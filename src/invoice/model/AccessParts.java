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

    private List<Part> parts;

    public boolean retrieveParts() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Part");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Part part = new Part();
                part.setId(resultSet.getInt("id"));
                part.setPartNumber(resultSet.getString("part_number"));
                part.setDescription(resultSet.getString("description"));
                part.setCost(resultSet.getDouble("cost"));
                parts.add(part);
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List getParts() {
        return parts;
    }

    public void setParts(List parts) {
        this.parts = parts;
    }


}
