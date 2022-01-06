package object;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ObjectInGame {

    public BufferedImage image;
    public BufferedImage image1;
    public String name;
    public boolean collisionOn = false;
    public int objectX, objectY;
    public Rectangle bootsCollisionArea = new Rectangle(72 * 5 + 17, 72 * 5 + 25, 28, 30);
    public Rectangle keyCollisionArea = new Rectangle(72 * 9, 72 * 9, 72, 72);
    public Rectangle doorCollisionArea = new Rectangle(72 * 9, 72 * 0, 72, 72);
    public Rectangle moneyCollisionArea = new Rectangle(72 * 0 + 28, 72 * 9 + 20, 15, 30);

    public void draw(Graphics2D g2, GamePanel gp) {

        g2.drawImage(image, objectX, objectY, gp.tileSize, gp.tileSize, null);
    }
}
