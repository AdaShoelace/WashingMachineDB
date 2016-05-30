import java.sql.*;

/**
 * Created by Pierre on 2016-05-19.
 */
public class InputManager {

    private Connection conn;

    public InputManager() {
        initiateConnection();
    }

    private void initiateConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root" ,"");
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void asdfg() {
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from item");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)+" har medlemsnummer "+rs.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
