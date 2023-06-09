package vkbot;

import javax.swing.*;
import java.awt.*;

public class AuctionTab extends JPanel {
    private JLabel label;

    public AuctionTab() {
        setLayout(new BorderLayout());

        label = new JLabel("В разработке");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        add(label, BorderLayout.CENTER);
    }
}