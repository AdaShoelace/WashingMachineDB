/*
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

@SuppressWarnings("serial")
public class GarageGUI extends JFrame {

    public GarageGUI(BicycleGarageManager manager) {
        super("Garage");

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();

        JLabel userManagement = new JLabel("User Management");
        userManagement.setPreferredSize(new Dimension(200, 30));
        userManagement.setFont(new Font("Serif", Font.PLAIN, 24));
        buttonPanel.add(userManagement, BorderLayout.CENTER);

        buttonPanel.add(new AddButton(manager));
        buttonPanel.add(new RemoveButton(manager));
        buttonPanel.add(new SearchButton(manager));

        JLabel barcodeLabel = new JLabel("Barcode");
        barcodeLabel.setPreferredSize(new Dimension(200, 30));
        barcodeLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        buttonPanel.add(barcodeLabel, BorderLayout.CENTER);
        buttonPanel.add(new PrintButton(manager));

        JLabel statisticsLabel = new JLabel("Statistics");
        statisticsLabel.setPreferredSize(new Dimension(200, 30));
        statisticsLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        buttonPanel.add(statisticsLabel, BorderLayout.CENTER);

        buttonPanel.add(new ActiveButton(manager));
        buttonPanel.add(new EnteredButton(manager));
        buttonPanel.add(new ExitedButton(manager));
        buttonPanel.add(new UserButton(manager));
        buttonPanel.add(new QuitButton(manager));

        this.add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
        setSize(250, 850);
    }

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        BicycleGarageManager manager = new BicycleGarageManager();
        @SuppressWarnings("unused")
        GarageGUI GUI = new GarageGUI(manager);
    }

}
*/
