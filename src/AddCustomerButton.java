import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kristoffer on 30/05/16.
 */
public class AddCustomerButton extends JButton implements ActionListener {

    public AddCustomerButton() {
        super("Add Customer to the Database");
        setPreferredSize(new Dimension(250, 100));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog("Enter the Name");
        String customerID = JOptionPane.showInputDialog("Enter the customerID (10 digits)");
        String address = JOptionPane.showInputDialog("Enter the address");
        String phoneNr = JOptionPane.showInputDialog("Enter the phone number");
        String email = JOptionPane.showInputDialog("Enter the Email-address");

        String[] attributeArray = {customerID, name, address, phoneNr, email};

        String res = "";

        if (InputManager.addCustomer(attributeArray)) {
            res = "The customer was successfully added";
        } else {
            res = " The customer was NOT successfully added";
        }

        JOptionPane.showMessageDialog(null, res);
    }
}
