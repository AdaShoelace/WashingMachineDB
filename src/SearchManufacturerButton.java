import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kristoffer on 30/05/16.
 */
public class SearchManufacturerButton extends JButton implements ActionListener{

    public SearchManufacturerButton(){
        super("Search for Manufacturer");
        setPreferredSize(new Dimension(250,100));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String manufacturer = JOptionPane.showInputDialog("Enter the Manufacturer");
    }
}