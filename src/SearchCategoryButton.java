import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kristoffer on 30/05/16.
 */
public class SearchCategoryButton extends JButton implements ActionListener{

    public SearchCategoryButton(){
        super("Category");
        setPreferredSize(new Dimension(250,100));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String category = JOptionPane.showInputDialog("Enter the category");
        JOptionPane.showMessageDialog(null, InputManager.searchCategory(category));

    }
}