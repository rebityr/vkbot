/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package vkbot;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton characterButton;
    private JButton shopButton;
    private JButton caseButton;
    //private JButton auctionButton;
    //private JButton ratingButton;

    private JPanel mainPanel;
    private CardLayout cardLayout;

    private DatabaseManager databaseManager;
    private CharacterTab characterTab;

    public MainFrame() {
        setTitle("Главная форма");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        databaseManager = new DatabaseManager();

        characterButton = new JButton("Персонаж");
        shopButton = new JButton("Магазин");
        caseButton = new JButton("Донат-кейс");
        //auctionButton = new JButton("Аукцион");
        //ratingButton = new JButton("Рейтинг");

        characterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "CharacterTab");
            }
        });

        shopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "ShopTab");
            }
        });

        caseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "caseTab");
            }
        });

        /*auctionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                cardLayout.show(mainPanel, "AuctionTab");
            }
        });*/

        // Добавление обработчиков событий для других кнопок
        // ...

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(characterButton);
        buttonPanel.add(shopButton);
        buttonPanel.add(caseButton);
        //buttonPanel.add(auctionButton);
        //buttonPanel.add(ratingButton);

        mainPanel.add(new CharacterTab(databaseManager), "CharacterTab");
        mainPanel.add(new ShopTab(databaseManager, characterTab), "ShopTab");
        mainPanel.add(new caseTab(), "caseTab");
        mainPanel.add(new AuctionTab(), "AuctionTab");
        
        // Добавление других вкладок на основной панель
        // ...

        add(buttonPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }

    public Object getGreeting() {
        return null;
    }
}

