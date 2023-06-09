package vkbot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class caseTab extends JPanel {
    private JButton openButton;
    private JLabel resultLabel;
    private JTextArea informationTextArea;
    private JButton showButton;
    private JButton hideButton;
    private boolean informationVisible;
    private DatabaseManager databaseManager;
    //public int n = 0;

    public caseTab(DatabaseManager dbManager) {
        databaseManager = dbManager;
        
        setLayout(new BorderLayout());

        openButton = new JButton("Открыть");
        resultLabel = new JLabel("Название и количество ресурсов, выпавших из кейса");

        informationTextArea = new JTextArea();
        informationTextArea.setEditable(false);
        informationTextArea.setLineWrap(true);
        informationTextArea.setWrapStyleWord(true);
        informationTextArea.setText(" Купец\n Помещик\n Боярин\n Князь\n Золото х10 - х100 от добычи\n Руда х10 - х100 от добычи\n Дерево х10 - х100 от добычи\n Еда х10 - х100 от добычи\n Руны 5шт\n Кристаллы 300 - 1000\n\n\n\n\n\n\n Количество кейсов: 10");
        informationVisible = false;

        showButton = new JButton("Информация о кейсах");
        hideButton = new JButton("Скрыть");
        hideButton.setEnabled(false);

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                informationVisible = true;
                updateVisibility();
            }
        });

        hideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                informationVisible = false;
                updateVisibility();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showButton);
        buttonPanel.add(hideButton);
        buttonPanel.add(openButton);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        contentPanel.add(new JScrollPane(informationTextArea), BorderLayout.CENTER);

        

        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //n = 1;
                Random random = new Random();
                
                int goldLocal = random.nextInt(91) + 10;  // Generates a random number between 10 and 100
                int oreLocal = random.nextInt(91) + 10;
                int woodLocal = random.nextInt(91) + 10;
                int foodLocal = random.nextInt(91) + 10;


                int currentResourceCountGold = 0;
                int currentResourceCountOre = 0;
                int currentResourceCountWood = 0;
                int currentResourceCountFood = 0;
                currentResourceCountGold = databaseManager.getGold();
                currentResourceCountOre = databaseManager.getOre();
                currentResourceCountWood = databaseManager.getWood();
                currentResourceCountFood = databaseManager.getFood();


                int newResourceCountGold = currentResourceCountGold + goldLocal;
                int newResourceCountOre = currentResourceCountOre + oreLocal;
                int newResourceCountWood = currentResourceCountWood + woodLocal;
                int newResourceCountFood = currentResourceCountFood + foodLocal;
                databaseManager.updateGold(newResourceCountGold);
                databaseManager.updateOre(newResourceCountOre);
                databaseManager.updateWood(newResourceCountWood);
                databaseManager.updateFood(newResourceCountFood);
                String result = "Золото: " + goldLocal + ", Руда: " + oreLocal + ", Дерево: " + woodLocal + ", Еда: " + foodLocal;
                resultLabel.setText(result);
                
                
            }
        });

        add(buttonPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);
        
    }
    private void updateVisibility() {
        informationTextArea.setVisible(informationVisible);
        showButton.setEnabled(!informationVisible);
        hideButton.setEnabled(informationVisible);
    }
}