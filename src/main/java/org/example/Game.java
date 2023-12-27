package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JDialog {
    private TwentyOneGame twentyOneGame; // Добавлен объект TwentyOneGame

    private JPanel contentPane;
    private JButton hitButton; // Кнопка для хода игрока
    private JButton standButton; // Кнопка для завершения хода игрока
    private JTextArea gameStatusTextArea; // Отображение статуса игры

    public Game() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(hitButton);

        twentyOneGame = new TwentyOneGame();

        hitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerHit();
            }
        });

        standButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stand();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        // Увеличиваем размеры окна
        setSize(new Dimension(5000, 3000));
        updateGameStatus(); // Обновляем статус игры при запуске
    }

    private void playerHit() {
        twentyOneGame.playerHit();
        updateGameStatus();
    }

    private void stand() {
        twentyOneGame.computerPlay();
        updateGameStatus();
    }

    private void updateGameStatus() {
        // Обновление текстовой области со статусом игры
        String status =
                "Player Score: " + twentyOneGame.getPlayerScore() +
                        "\nPlayer Cards: " + twentyOneGame.getPlayerHand() +
                        "\n\nComputer Score: " + twentyOneGame.getComputerScore() +
                        "\nComputer Cards: " + twentyOneGame.getComputerHand() +
                        "\n\nВаш баланс: " + twentyOneGame.getBalance();




        if (twentyOneGame.isGameOver()) {
            status += "\nGame Over. ";
            if (twentyOneGame.getPlayerScore() > 21) {
                status += "Player Busted. Computer Wins!";
            } else if (twentyOneGame.getComputerScore() > 21) {
                status += "Computer Busted. Player Wins!";
            } else if (twentyOneGame.getPlayerScore() > twentyOneGame.getComputerScore()) {
                status += "Player Wins!";
            } else if (twentyOneGame.getPlayerScore() < twentyOneGame.getComputerScore()) {
                status += "Computer Wins!";
            } else {
                status += "It's a Tie!";
            }
            // Блокировка кнопок после завершения игры
            hitButton.setEnabled(false);
            standButton.setEnabled(false);
        }

        gameStatusTextArea.setText(status);
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        Game dialog = new Game();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(10, 10, 10, 10), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1, true, false));
        panel1.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        hitButton = new JButton();
        hitButton.setText("buttonOK");
        panel2.add(hitButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        standButton = new JButton();
        standButton.setText("buttonCancel");
        panel2.add(standButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(panel3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        gameStatusTextArea = new JTextArea();
        panel3.add(gameStatusTextArea, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

}
