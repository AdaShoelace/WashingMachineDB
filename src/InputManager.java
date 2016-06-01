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
     *
     * @param inputValue The EAN of the item to be deleted
     */
    public static boolean deleteItem(String inputValue) {

        String query = "DELETE FROM ITEM WHERE EAN=" + inputValue;

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Takes EAN of an item and return the buyers of said item
     *
     * @param inputValue EAN of item
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
                res += "\n";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return res;
    }

    /**
     * Takes item EAN as argument and return the information of that item
     *
     * @param inputValue the EAN of an item
     * @return A string containing information about the specified item
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

    public static String findByBonus(String totalAmount) {

        String query = "SELECT name,email FROM (purchases as p join customer as c on p.customerID = c.customerID join item as i on p.ean = i.ean) group by p.customerID having sum(i.outprice * p.amount) > " + totalAmount;
        String res = "";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                res += "Name: " + rs.getString(1) +
                        " Email: " + rs.getString(2) + "\n";

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    /**
     * Returns item based on manufacturer
     *
     * @param manufacturer Name of manufacturer
     * @return Items of specified manufacturer
     */
    public static String searchManufacturer(String manufacturer) {
        String query = "SELECT * FROM ITEM WHERE Manufacturer=" + "'" + manufacturer + "'";
        String res = "";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                res += "EAN: " + rs.getString(1) + "\n"
                        + "Numbers in stock: " + rs.getString(2) + " \n"
                        + "Model: " + rs.getString(3) + "\n"
                        + "Manufacturer: " + rs.getString(4) + "\n"
                        + "Price: " + rs.getString(5) + ":-" + "\n"
                        + "Energyclass: " + rs.getString(8) + "\n"
                        + "Description: " + rs.getString(9) + "\n\n";
            }

            if (res == "")
                return manufacturer + " not found";
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return res;
    }


    /**
     * Adds item to database
     *
     * @param ean
     * @param stock
     * @param model
     * @param manufacturer
     * @param sellPrice
     * @param buyPrice
     * @param supplier
     * @param energy
     * @param descrition
     * @param category
     */
    public static boolean addItem(String ean, String stock, String model, String manufacturer, String sellPrice, String buyPrice, String supplier, String energy, String descrition, String category)

    {

        String query = "insert into item values(" + ean +
                "," + stock + ",'" + model + "','" + manufacturer +
                "'," + sellPrice + "," + buyPrice + "," + supplier +
                ",'" + energy + "','" + descrition + "','" + category + "')";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Adds customer to database
     *
     * @param inputValue String array containing values of customer attributes
     */
    public static boolean addCustomer(String[] inputValue) {

        String query = "insert into customer values(" + inputValue[0] +
                ",'" + inputValue[1] + "','" + inputValue[2] + "'," + inputValue[3] + ",'" + inputValue[4] + "')";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    /**
     * Add a pruchase to the Database
     *
     * @param ean        of the item bought
     * @param customerID of the customer that bought the item
     * @param amount     number of items bought
     * @param date       date of purchase
     * @return Returns true if the purchase was successfully added else false.
     */
    public static boolean addPurchase(String ean, String customerID, String amount, String date) {

        String query = "insert into Purchases (EAN,CustomerID,Amount,PurchaseDate) values(" +
                ean + "," + customerID + "," + amount + ",'" + date + "')";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
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

    public static String searchCategory(String category) {

        String query = "SELECT * FROM ITEM WHERE Category=" + "'" + category + "'";
        String res = "";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                res += "EAN: " + rs.getString(1) + "\n"
                        + "Numbers in stock: " + rs.getString(2) + " \n"
                        + "Model: " + rs.getString(3) + "\n"
                        + "Manufacturer: " + rs.getString(4) + "\n"
                        + "Price: " + rs.getString(5) + ":-" + "\n"
                        + "Energyclass: " + rs.getString(8) + "\n"
                        + "Description: " + rs.getString(9) + "\n\n";
            }

            if (res == "")
                return "No items in " + category;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return res;
    }
}
