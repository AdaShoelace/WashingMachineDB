import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kristoffer on 30/05/16.
 */
public class SearchItemButton extends JButton implements ActionListener{

    public SearchItemButton(){
        super("Item");
        setPreferredSize(new Dimension(250,100));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ean = JOptionPane.showInputDialog("Enter the EAN of the item");
        JOptionPane.showMessageDialog(null, InputManager.searchItem(ean));

    }
}