import javax.swing.*;
import java.awt.*;

/**
 * Created by Pierre on 2016-05-19.
 */
public class GUI extends JFrame{
    private JPanel mainPanel;
    private JButton addItem, deleteItem;

    private final Dimension buttonSize = new Dimension(250,100);


    public GUI(){
        super("White Database");

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        mainPanel = new JPanel();

        JLabel itemHeader = new JLabel("Item Management");
        itemHeader.setPreferredSize(new Dimension(200, 30));
        itemHeader.setFont(new Font("Serif", Font.PLAIN, 24));

        addItem = new JButton("Add an Item to the DB");
        addItem.setPreferredSize(buttonSize);

        deleteItem = new JButton("Delete an Item from the DB");
        deleteItem.setPreferredSize(buttonSize);

        mainPanel.add(itemHeader);
        mainPanel.add(addItem);
        mainPanel.add(deleteItem);

        add(mainPanel);
        setVisible(true);
        setSize(250, 850);
        setMinimumSize(new Dimension(250,500));
    }



    public static void main(String[] args){
        new GUI();
    }

}
