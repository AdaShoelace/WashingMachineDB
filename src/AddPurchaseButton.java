import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Kristoffer on 30/05/16.
 */
public class AddPurchaseButton extends JButton implements ActionListener{

    public AddPurchaseButton(){
        super("Add Purchase to Database");
        setPreferredSize(new Dimension(250,100));
        addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String item = JOptionPane.showInputDialog("Enter the Item EAN");
        String customerID = JOptionPane.showInputDialog("Enter the customerID");
        String amount = JOptionPane.showInputDialog("Enter the amount");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
    }
}
