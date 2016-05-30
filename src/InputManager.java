import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Pierre on 2016-05-19.
 */
public class InputManager {

    private Connection connection;
    private Statement stmt;

    public InputManager() {
        initiateConnection();
    }

    private void initiateConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/DB?user=root&password=myPassword");
            stmt = connection.createStatement();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
