import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kristoffer on 30/05/16.
 */
public class AddCustomerButton extends JButton implements ActionListener{

    public AddCustomerButton(){
        super("Add Customer to the Database");
        setPreferredSize(new Dimension(250,100));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Name = JOptionPane.showInputDialog("Enter the Name");
        String customerID = JOptionPane.showInputDialog("Enter the customerID (10 digits)");
        String PhoneNr = JOptionPane.showInputDialog("Enter the phone number");
        String Email = JOptionPane.showInputDialog("Enter the Email-address");
    }
}
