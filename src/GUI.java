import javax.swing.*;
import java.awt.*;

/**
 * Created by Pierre on 2016-05-19.
 */
public class GUI extends JFrame {
    private JPanel adminPanel, userPanel;

    private final Dimension buttonSize = new Dimension(250, 100);


    public GUI() {
        super("White Power Supplies");

        JTabbedPane tabbedPane = new JTabbedPane();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        createAdminPane();
        createUserPane();

        tabbedPane.add("ADMIN", adminPanel);
        tabbedPane.add("USER", userPanel);

        add(tabbedPane);
        setVisible(true);
        setMinimumSize(new Dimension(300, 800));
        setMaximumSize(new Dimension(350, 800));

        Dimension screeenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screeenSize.width / 2 - this.getWidth() / 2, screeenSize.height / 2 - this.getHeight() / 2);
    }

    private void createUserPane() {
        userPanel = new JPanel();

        JLabel itemLabel = new JLabel("Search by:");
        itemLabel.setPreferredSize(new Dimension(200, 30));
        itemLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        itemLabel.setHorizontalAlignment(SwingConstants.CENTER);

        userPanel.add(itemLabel);
        userPanel.add(new SearchItemButton());
        userPanel.add(new SearchManufacturerButton());
    }

    private void createAdminPane() {
        adminPanel = new JPanel();

        JLabel itemLabel = new JLabel("Item Management");
        itemLabel.setPreferredSize(new Dimension(200, 30));
        itemLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        itemLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel purchasesLabel = new JLabel("Purchases");
        purchasesLabel.setPreferredSize(new Dimension(200, 30));
        purchasesLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        purchasesLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel customerLabel = new JLabel("Customer");
        customerLabel.setPreferredSize(new Dimension(200, 30));
        customerLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        customerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        adminPanel.add(itemLabel);
        adminPanel.add(new AddItemButton());
        adminPanel.add(new DeleteItemButton());
        adminPanel.add(new FindBuyersButton());
        adminPanel.add(purchasesLabel);
        adminPanel.add(new AddPurchaseButton());
        adminPanel.add(customerLabel);
        adminPanel.add(new AddCustomerButton());
        adminPanel.add(new FindBonusButton());
    }

    public static void main(String[] args) {
        new GUI();
    }

}
