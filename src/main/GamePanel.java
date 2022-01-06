package main;

import entity.Player;
import entity.Skeleton;
import entity.Ufo;
import object.ObjectInGame;
import object.SettingObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public final int tileSize = 72;
    final int maxScreenCol = 10;
    final int maxScreenRow = 10;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    int fps = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public CheckCollision checkCollision = new CheckCollision(this);
    public SettingObject settingObject = new SettingObject(this);
    public playerInterface ui = new playerInterface(this);

    Player player = new Player(this, keyH);
    Skeleton skeleton01 = new Skeleton(this);
    Ufo alien = new Ufo(this);
    public ObjectInGame[] obj = new ObjectInGame[5];

    public GamePanel() {
        this.setPreferredSize(new Dimension(820, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void placeObject() {
        settingObject.setObject();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer > 1000000000) {
//                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {

        skeleton01.setAction();
        alien.setAction();
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);

        // drawing object
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }

        ui.draw(g2);
        skeleton01.draw(g2);
        alien.draw(g2);
        player.draw(g2);

        g2.dispose();
    }
}






























