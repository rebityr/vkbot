package vkbot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class ShopTab extends JPanel {
    private JLabel goldLabel;
    private JLabel oreLabel;
    private JLabel woodLabel;
    private JLabel foodLabel;
    private JLabel crystalsLabel; // Added label to display crystals count
    private JButton buyGoldButton;
    private JButton buyOreButton;
    private JButton buyWoodButton;
    private JButton buyFoodButton;

    private DatabaseManager databaseManager;
    private CharacterTab characterTab; // Reference to the CharacterTab
    private ShopTab upd;

    public ShopTab(DatabaseManager dbManager, CharacterTab characterTab) {
        databaseManager = dbManager;

        this.characterTab=characterTab;

        setLayout(new BorderLayout()); // Use BorderLayout to position buttons at the bottom

        JPanel resourcePanel = new JPanel(new GridLayout(1, 4));
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));

        goldLabel = new JLabel("Золото", SwingConstants.CENTER);
        oreLabel = new JLabel("Руда", SwingConstants.CENTER);
        woodLabel = new JLabel("Дерево", SwingConstants.CENTER);
        foodLabel = new JLabel("Еда", SwingConstants.CENTER);
        crystalsLabel = new JLabel("Кристаллы: " + databaseManager.getCrystals(), SwingConstants.CENTER); // Display crystals count
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                // Invoke your method here
                updateResourceCountLabels();
            }
        }, 0, 1000);
        
        buyGoldButton = new JButton("Золото (10 кристаллов)");
        buyGoldButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform the buy operation for gold
                buyResource("gold");
            }
        });

        buyOreButton = new JButton("Руда (10 кристаллов)");
        buyOreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform the buy operation for ore
                buyResource("ore");
            }
        });

        buyWoodButton = new JButton("Дерево (10 кристаллов)");
        buyWoodButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform the buy operation for wood
                buyResource("wood");
            }
        });

        buyFoodButton = new JButton("Еда (10 кристаллов)");
        buyFoodButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform the buy operation for food
                buyResource("food");
            }
        });

        resourcePanel.add(goldLabel);
        resourcePanel.add(oreLabel);
        resourcePanel.add(woodLabel);
        resourcePanel.add(foodLabel);

        buttonPanel.add(buyGoldButton);
        buttonPanel.add(buyOreButton);
        buttonPanel.add(buyWoodButton);
        buttonPanel.add(buyFoodButton);

        add(crystalsLabel, BorderLayout.NORTH); // Added crystals label at the top
        add(resourcePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void buyResource(String resource) {
        int currentCrystals = databaseManager.getCrystals();
        int currentResourceCount = 0;
        int resourceCost = 10; // Set the resource cost to 10 crystals

        // Determine the current count of the selected resource
        if (resource.equals("gold")) {
            currentResourceCount = databaseManager.getGold();
        } else if (resource.equals("ore")) {
            currentResourceCount = databaseManager.getOre();
        } else if (resource.equals("wood")) {
            currentResourceCount = databaseManager.getWood();
        } else if (resource.equals("food")) {
            currentResourceCount = databaseManager.getFood();
        }

        // Check if the user has enough crystals to make the purchase
        if (currentCrystals >= resourceCost) {
            // Deduct the cost from the available crystals
            int newCrystals = currentCrystals - resourceCost;
            databaseManager.updateCrystals(newCrystals);

            // Update the resource count in the database
            int newResourceCount = currentResourceCount + 10; // Increase the count by 10

            // Update the respective resource count in the database
            if (resource.equals("gold")) {
                databaseManager.updateGold(newResourceCount);
            } else if (resource.equals("ore")) {
                databaseManager.updateOre(newResourceCount);
            } else if (resource.equals("wood")) {
                databaseManager.updateWood(newResourceCount);
            } else if (resource.equals("food")) {
                databaseManager.updateFood(newResourceCount);
            }

            // Display a message to indicate the successful purchase
            JOptionPane.showMessageDialog(this, "Покупка выполнена успешно.");

            // Update the displayed resource counts
            updateResourceCountLabels();

            characterTab.notifyPurchase();

        } else {
            // Display an error message if the user doesn't have enough crystals
            JOptionPane.showMessageDialog(this, "Недостаточно кристаллов для покупки.");
        }
    }

    public void updateResourceCountLabels() {
        // Update the displayed resource counts based on the values in the database
        goldLabel.setText("Золото: " + databaseManager.getGold());
        oreLabel.setText("Руда: " + databaseManager.getOre());
        woodLabel.setText("Дерево: " + databaseManager.getWood());
        foodLabel.setText("Еда: " + databaseManager.getFood());
        crystalsLabel.setText("Кристаллы: " + databaseManager.getCrystals());
    }



}
