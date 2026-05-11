import javax.swing.*;
import java.awt.*;

public class GUI {
    int multiplier = 1;
    int price = 5;

    JFrame frame; // a window
    JPanel panel; // go inside windows
    JButton button, upgradeButton;
    JLabel label;

    public GUI(){
        frame = new JFrame("Cookie Crash");
        panel = new JPanel();

        button = new JButton("Add cookies!");
        button.setIcon(new ImageIcon("Cookie.png"));
        // Causes the cookie amount to increase by the multiplier and changes display.
        button.addActionListener(e -> {
            Cookies.add(multiplier);
            label.setText("Cookies: " + Cookies.count);
            panel.updateUI();
        });

        // TODO: Figure out how to display value of price variable in the button.
        upgradeButton = new JButton(
                "<html><center>Upgrade<br>Cookies needed: 5</span></center></html>"
        );
        upgradeButton.setIcon(new ImageIcon("LotsOfCookies.png"));
        // Subtracts from cookie amount by the price and increases the multiplier.
        upgradeButton.addActionListener(e -> {
            if (Cookies.count < price) return;
            multiplier++;
            Cookies.sell(price);
            price *= 2;

            label.setText("Cookies: " + Cookies.count);
            upgradeButton.setText(
                    "<html><center>Upgrade<br>Cookies needed: 5++</center></html>"
            );
            panel.updateUI();
        });

        label = new JLabel("Cookies: " + Cookies.count );

        panel.setBackground(Color.LIGHT_GRAY);

        panel.add(label);
        panel.add(button);
        panel.add(upgradeButton);

        frame.setSize(700, 250);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
