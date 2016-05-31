import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kristoffer on 30/05/16.
 */
public class FindBuyersButton extends JButton implements ActionListener {

    public FindBuyersButton() {
        super("Find buyers of an item");
        setPreferredSize(new Dimension(250, 100));
        addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String item = JOptionPane.showInputDialog("Enter the Item EAN");
        String res = InputManager.findBuyer(item);

        if(res == null){
            JOptionPane.showMessageDialog(null,"Wrong input format");
        }
        else if (res.equals("")) {
            JOptionPane.showMessageDialog(null, "No buyer of that Item found");
        } else {
            JOptionPane.showMessageDialog(null, res);
        }
    }
}