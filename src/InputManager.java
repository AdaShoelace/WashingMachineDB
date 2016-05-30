import java.sql.*;

/**
 * Created by Pierre on 2016-05-19.
 */
public final class InputManager {

    private static Connection conn;

    private InputManager() {
    }

    public static void initiateConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root" ,"");
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteItem(String inputValue) {

        String query = "DELETE FROM ITEM WHERE EAN="+inputValue;

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String searchItem(String inputValue) {

        String query = "SELECT * FROM ITEM WHERE EAN=" + inputValue;
        String res = "";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                res = "EAN: " + rs.getString(1) + "\n"
                        + "Numbers in stock: " + rs.getString(2) +" \n"
                        + "Model: " + rs.getString(3) + "\n"
                        + "Manufacturer: " + rs.getString(4) + "\n"
                        + "Price: " + rs.getString(5) + ":-" + "\n"
                        + "Energyclass: " + rs.getString(8) + "\n"
                        + "Description: " + rs.getString(9);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void addItem(String inputValue) {

        String query = "SELECT * FROM ITEM WHERE EAN=" + inputValue;

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
