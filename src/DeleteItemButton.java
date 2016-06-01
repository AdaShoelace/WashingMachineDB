import com.sun.codemodel.internal.JOp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kristoffer on 30/05/16.
 */
public class DeleteItemButton extends JButton implements ActionListener {

    public DeleteItemButton() {
        super("Delete an Item from the Database");
        setPreferredSize(new Dimension(250, 100));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String item = JOptionPane.showInputDialog("Enter the EAN of the item to DELETE");

        if (InputManager.deleteItem(item)) {
            JOptionPane.showMessageDialog(null, "Item was successfully deleted from the database");
        } else {
            JOptionPane.showMessageDialog(null, "Item was NOT deleted from the database");
        }
    }
}
