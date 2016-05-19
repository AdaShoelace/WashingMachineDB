import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Pierre on 2016-05-19.
 */
public class InputManager {

    private Connection connection;

    public InputManager() {
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/DB?user=root&password=myPassword");
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
