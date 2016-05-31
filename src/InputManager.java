import java.sql.*;

/**
 * Created by Pierre on 2016-05-19.
 */
public final class InputManager {

    private static Connection conn;

    private InputManager() {
    }

    /**
     * Establish an connection to the database
     */
    public static void initiateConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes item from the Item table in the database
     * @param inputValue    The EAN of the item to be deleted
     */
    public static void deleteItem(String inputValue) {

        String query = "DELETE FROM ITEM WHERE EAN=" + inputValue;

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes EAN of an item and return the buyers of said item
     * @param inputValue    EAN of item
     * @return A string contaningen the information of the buyers
     */
    public static String findBuyer(String inputValue) {

        String query = "SELECT * FROM PURCHASES WHERE EAN=" + inputValue;
        String res = "";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("SELECT * FROM PURCHASES WHERE EAN=" + inputValue);

            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = rs.getString(i);
                    res += rsmd.getColumnName(i) + ": " + columnValue + "\n";
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return res;
    }

    /**
     * Takes item EAN as argument and return the information of that item
     * @param inputValue    the EAN of an item
     * @return  A string containing information about the specified item
     */
    public static String searchItem(String inputValue) {

        String query = "SELECT * FROM ITEM WHERE EAN=" + inputValue;
        String res = "";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                res = "EAN: " + rs.getString(1) + "\n"
                        + "Numbers in stock: " + rs.getString(2) + " \n"
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

    /**
     * Returns item based on manufacturer
     * @param manufacturer  Name of manufacturer
     * @return  Items of specified manufacturer
     */
    public String searchManufacturer(String manufacturer) {
        String query = "SELECT * FROM ITEM WHERE Manufacturer=" + manufacturer;
        String res = "";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                res = "EAN: " + rs.getString(1) + "\n"
                        + "Numbers in stock: " + rs.getString(2) + " \n"
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

    /**
     * Adds item to database
     * @param inputValue    String array containing the values of item attributes
     */
    public static void addItem(String[] inputValue) {

        String query = "insert into item values(" + inputValue[0] +
                "," + inputValue[1] + "," + inputValue[2] + "," + inputValue[3] +
                "," + inputValue[4] + "," + inputValue[5] + "," + inputValue[6] +
                "," + inputValue[7] + "," + inputValue[8] + "," + inputValue[9] + ")";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds customer to database
     * @param inputValue    String array containing values of customer attributes
     */
    public static void addCustomer(String[] inputValue) {

        String query = "insert into customer values(" + inputValue[0] +
                "," + inputValue[1] + "," + inputValue[2] + "," + inputValue[3] + ")";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes connection to database
     */
    public static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
