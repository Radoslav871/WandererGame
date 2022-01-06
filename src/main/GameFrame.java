package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    GamePanel gamePanel;
    JButton resetButton;

    public GameFrame() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Wanderer 3.0");

        // not finished reset button
//        resetButton = new JButton();
//        resetButton.setText("One more ?");
//        resetButton.setSize(100,50);
//        resetButton.setLocation(0,500);
//        resetButton.addActionListener(this);

        GamePanel gamePanel = new GamePanel();
        // not finished reset button
//        this.add(resetButton);
        this.add(gamePanel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        gamePanel.placeObject();
        gamePanel.startGameThread();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // not finished reset button
//        if (e.getSource() == resetButton){
//            this.remove(gamePanel);
//            gamePanel = new GamePanel();
//            this.add(gamePanel);
//            SwingUtilities.updateComponentTreeUI(this);
//        }
    }
}
