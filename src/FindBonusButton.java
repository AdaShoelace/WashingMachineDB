import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kristoffer on 30/05/16.
 */
public class FindBonusButton extends JButton implements ActionListener {

    public FindBonusButton() {
        super("Find bonus customer");
        setPreferredSize(new Dimension(250, 100));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String amount = JOptionPane.showInputDialog("Enter the min Amount to qualify as bonus customer");

        JOptionPane.showMessageDialog(null, InputManager.findByBonus(amount));
    }
}
