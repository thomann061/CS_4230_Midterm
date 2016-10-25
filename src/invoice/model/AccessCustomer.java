package invoice.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jthomann on 10/24/16.
 */
public class AccessCustomer {
    private static Connection connection = DatabaseConnectionFactory.getInstance().getDatabaseConnection();

    private ResultSet customers;

    public void retrieveCustomers() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Customer");
            ResultSet resultSet = statement.executeQuery();
            customers = resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getCustomer() {
        return customers;
    }

    public void setCustomers(ResultSet customers) {
        this.customers = customers;
    }

}
