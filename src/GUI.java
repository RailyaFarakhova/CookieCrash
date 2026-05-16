import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    JFrame frame; // a window
    JPanel panel; // go inside windows
    JButton button, upgradeButton, autoButton;
    JLabel currentCookies, cookiePrice, autoPrice, cookieRate;

    Timer timer;
    ActionListener guiUpdate;

    public GUI(){
        frame = new JFrame("Cookie Crash");
        panel = new JPanel();

        button = new JButton("Add cookies!");
        button.setIcon(new ImageIcon("Cookie.png"));
        // Causes the cookie amount to increase by the multiplier and changes display.
        button.addActionListener(e -> {
            Cookies.add();
            currentCookies.setText(Cookies.display());
            panel.updateUI();
        });

        upgradeButton = new JButton(
               "<html><center>Upgrade<br>Cookies</center></html>"
        );
        upgradeButton.setIcon(new ImageIcon("LotsOfCookies.png"));
        // Subtracts from cookie amount by the price and increases the multiplier.
        upgradeButton.addActionListener(e -> {
            Cookies.upgradeClick();
            currentCookies.setText(Cookies.display());
            cookiePrice.setText(Cookies.getUpgradePrice());
            panel.updateUI();
        });

        autoButton = new JButton("Auto Click");
        autoButton.addActionListener(e -> {
            Cookies.upgradeAuto();
            currentCookies.setText(Cookies.display());
            autoPrice.setText(Cookies.getAutoPrice());
            cookieRate.setText(Cookies.getAutoRate());
            panel.updateUI();
        });

        currentCookies = new JLabel(Cookies.display());
        cookiePrice = new JLabel(Cookies.getUpgradePrice());
        autoPrice = new JLabel(Cookies.getAutoPrice());
        cookieRate = new JLabel(Cookies.getAutoRate());

        panel.setBackground(Color.LIGHT_GRAY);

        panel.add(currentCookies);
        panel.add(cookiePrice);
        panel.add(autoPrice);
        panel.add(cookieRate);
        panel.add(button);
        panel.add(upgradeButton);
        panel.add(autoButton);

        frame.setSize(1300, 400);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        guiUpdate = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentCookies.setText(Cookies.display());
            }
        };

        timer = new Timer(500, guiUpdate);
        timer.start();
        Cookies.timer.start();
    }
}
