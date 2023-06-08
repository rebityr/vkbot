package vkbot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class caseTab extends JPanel {
    private JButton openButton;
    private JLabel resultLabel;
    private JTextArea informationTextArea;
    private JButton showButton;
    private JButton hideButton;
    private boolean informationVisible;

    public caseTab() {
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
                // Логика открытия кейса и получения результата
                // ...

                // Пример полученного результата
                String result = "Ресурс A: 10, Ресурс B: 5, Ресурс C: 3";

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