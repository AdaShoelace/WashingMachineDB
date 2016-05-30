import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kristoffer on 30/05/16.
 */
public class AddItemButton extends JButton implements ActionListener{

    public AddItemButton(){
        super("Add an Item to the Database");
        setPreferredSize(new Dimension(250,100));
        addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String item = JOptionPane.showInputDialog("Enter the Item EAN");
        String stock = JOptionPane.showInputDialog("Enter the amount in stock");
        String model = JOptionPane.showInputDialog("Enter the model");
        String manufacturer = JOptionPane.showInputDialog("Enter the manufacturer");
        String outPrice = JOptionPane.showInputDialog("Enter the selling price");
        String inPrice = JOptionPane.showInputDialog("Enter the price from the supplier");
        String supplier = JOptionPane.showInputDialog("Enter the name of the supplier");
        String energyclass = JOptionPane.showInputDialog("Enter the energy class (if applicable)");
        String description = JOptionPane.showInputDialog("Enter the price from the supplier");

    }
}
