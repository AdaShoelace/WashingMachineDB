import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kristoffer on 30/05/16.
 */
public class SearchItemButton extends JButton implements ActionListener{

    public SearchItemButton(){
        super("Search Item");
        setPreferredSize(new Dimension(250,100));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Name = JOptionPane.showInputDialog("Enter the Name");

    }
}
