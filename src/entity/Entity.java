package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    GamePanel gp;
    public int x, y;
    public int speed;
    public BufferedImage up1, down1, left1, right1;
    public String direction;
    public Rectangle collisionArea = new Rectangle(0, 0, 48, 48);
    public Rectangle collisionAreaAlien = new Rectangle(0, 0, 48, 48);
    public boolean collisionOn = false;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }
}
