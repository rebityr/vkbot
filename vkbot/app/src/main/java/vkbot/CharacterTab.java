package vkbot;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CharacterTab extends JPanel {
    private JLabel imageLabel;
    private JLabel nameLabel;
    private JLabel castleLabel;
    private JLabel mineLabel;
    private JLabel farmLabel;
    private JLabel sawmillLabel;
    private JLabel inventoryLabel;
    private JLabel goldLabel;
    private JLabel woodLabel;
    private JLabel oreLabel;
    private JLabel foodLabel;

    private DatabaseManager databaseManager;

    public CharacterTab(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
        setLayout(null);

        // Create and position interface elements

        // Avatar and image section
        JPanel avatarPanel = new JPanel();
        avatarPanel.setBounds(10, 10, 200, 200);
        avatarPanel.setLayout(new BorderLayout());

        nameLabel = new JLabel("Имя Фамилия (Привилегия)");
        imageLabel = new JLabel(); // Field for the image
        imageLabel.setPreferredSize(new Dimension(50, 50));

        avatarPanel.add(nameLabel, BorderLayout.NORTH);
        avatarPanel.add(imageLabel, BorderLayout.CENTER);

        // Levels section
        JPanel levelPanel = new JPanel();
        levelPanel.setBounds(220, 10, 290, 90);
        levelPanel.setLayout(new GridLayout(2, 4));

        castleLabel = new JLabel("Замок LVL:");
        mineLabel = new JLabel("Шахта LVL");
        farmLabel = new JLabel("Ферма LVL");
        sawmillLabel = new JLabel("Лесопилка LVL");

        levelPanel.add(castleLabel);
        levelPanel.add(mineLabel);
        levelPanel.add(farmLabel);
        levelPanel.add(sawmillLabel);

        // Inventory section
        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setBounds(10, 220, 100, 200);
        inventoryPanel.setLayout(new BorderLayout());

        inventoryLabel = new JLabel("Инвентарь");
        inventoryPanel.add(inventoryLabel, BorderLayout.NORTH);
        // Add inventory items
        // ...

        // Resources section
        JPanel resourcePanel = new JPanel();
        resourcePanel.setBounds(220, 220, 200, 100);
        resourcePanel.setLayout(new GridLayout(2, 4));

        goldLabel = new JLabel("Золото");
        woodLabel = new JLabel("Дерево");
        oreLabel = new JLabel("Руда");
        foodLabel = new JLabel("Еда");

        resourcePanel.add(goldLabel);
        resourcePanel.add(woodLabel);
        resourcePanel.add(oreLabel);
        resourcePanel.add(foodLabel);

        // Add sections to the tab
        add(avatarPanel);
        add(levelPanel);
        add(inventoryPanel);
        add(resourcePanel);

        loadData();
    }

    public void notifyPurchase() {
        goldLabel.setText("Золото: " + databaseManager.getGold());
        oreLabel.setText("Руда: " + databaseManager.getOre());
        woodLabel.setText("Дерево: " + databaseManager.getWood());
        foodLabel.setText("Еда: " + databaseManager.getFood());
    }

    private void loadData() {
        // Get data from the database using the DatabaseManager
        int castleLevel = databaseManager.getlvl_cas();
        int mineLevel = databaseManager.getlvl_min();
        int farmLevel = databaseManager.getlvl_far();
        int sawmillLevel = databaseManager.getlvl_saw();
        int goldAmount = databaseManager.getGold();
        int woodAmount = databaseManager.getWood();
        int oreAmount = databaseManager.getOre();
        int foodAmount = databaseManager.getFood();

        // Set the loaded data to the corresponding components
        castleLabel.setText("Замок LVL: " + castleLevel);
        mineLabel.setText("Шахта LVL: " + mineLevel);
        farmLabel.setText("Ферма LVL: " + farmLevel);
        sawmillLabel.setText("Лесопилка LVL: " + sawmillLevel);
        goldLabel.setText("Золото: " + goldAmount);
        woodLabel.setText("Дерево: " + woodAmount);
        oreLabel.setText("Руда: " + oreAmount);
        foodLabel.setText("Еда: " + foodAmount);

        // Load the avatar image
        BufferedImage avatarImage = loadImage("src/av.png");
        if (avatarImage != null) {
            // Resize the image
            int imageSize = 80; // Specified image size
            Image resizedImage = avatarImage.getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);

            // Create a circular frame for the image
            ImageIcon avatarIcon = new ImageIcon(resizedImage);
            imageLabel.setIcon(avatarIcon);
            imageLabel.setSize(imageSize, imageSize);
            imageLabel.setOpaque(false);
            imageLabel.setBounds(0, 0, imageSize, imageSize);
        }
    }

    private BufferedImage loadImage(String imagePath) {
        try {
            return ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
