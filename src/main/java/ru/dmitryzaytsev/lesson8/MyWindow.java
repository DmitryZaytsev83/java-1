package ru.dmitryzaytsev.lesson8;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    private final Game game;

    private final JPanel centerPanel;
    private JPanel continueButtonsPanel;
    private JPanel gameButtonsPanel;

    private final JLabel jLabelInfo;
    private final JLabel jLabelTop;

    public MyWindow(Game game) {
        this.game = game;
        setTitle("Отгадай загаданное число");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 500, 500);
        setLocationRelativeTo(null);
        JPanel northPanel = new JPanel();
        centerPanel = new JPanel(new GridLayout(2, 1));
        continueButtonsPanel = new JPanel(new GridLayout(2, 5));
        jLabelTop = new JLabel();
        northPanel.setBackground(Color.white);
        northPanel.add(jLabelTop);
        jLabelInfo = new JLabel();
        jLabelInfo.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(jLabelInfo);
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        createGameButtons();
        createContinueButtons();
        init();

        setVisible(true);
    }

    private void init() {
        jLabelTop.setText("Я загадал число от 1 до 10, попробуй угадай!");
        jLabelInfo.setText("Нажми какую-нибудь кнопку. Осталось попыток: " + game.getAttempts());
        gameButtonsPanel.setVisible(true);
    }

    private void createContinueButtons() {
        JButton newGameButton = new JButton("Начать сначала");
        newGameButton.addActionListener(e -> {
            game.beginNew();
            init();
        });
        JButton closeGameButton = new JButton("Закрыть приложение");
        closeGameButton.addActionListener(e -> System.exit(0));
        continueButtonsPanel = new JPanel(new GridLayout(1, 2));
        continueButtonsPanel.add(newGameButton);
        continueButtonsPanel.add(closeGameButton);
        add(continueButtonsPanel, BorderLayout.SOUTH);
    }


    private void createGameButtons() {
        gameButtonsPanel = new JPanel(new GridLayout(2, 5));
        gameButtonsPanel.setPreferredSize(new Dimension(0, 100));
        gameButtonsPanel.setBackground(Color.lightGray);
        JButton[] jbs = new JButton[10];
        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton(String.valueOf(i + 1));
            final int finalI = i + 1;
            jbs[i].addActionListener(e -> {
                int res = game.checkNumber(finalI);
                if (game.isUserWin()) {
                    jLabelTop.setText("Победа!!!\n");
                    jLabelInfo.setText("Повторить?\n");
                    gameButtonsPanel.setVisible(false);
                } else if (game.isEndGame()) {
                    jLabelTop.setText("Проигрыш!");
                    jLabelInfo.setText("Повторить?\n");
                    gameButtonsPanel.setVisible(false);
                } else if (res > 0) {
                    jLabelInfo.setText("Я загадал число меньше " + finalI + "\n" + ". Осталось попыток: " + game.getAttempts());
                } else {
                    jLabelInfo.setText("Я загадал число больше " + finalI + "\n" + ". Осталось попыток: " + game.getAttempts());
                }
            });
            gameButtonsPanel.add(jbs[i]);
        }
        centerPanel.add(gameButtonsPanel);
    }
}
