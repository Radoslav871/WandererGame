package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Ufo extends Entity {

    public int alienX = 72 * 2;
    public int alienY = 72 * 5;

    Random random = new Random();
    public int randomNum = 28;


    public Ufo(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        // collision are is not moving with alien entity
        collisionAreaAlien = new Rectangle(alienX + 16, alienY + 16, 40, 40);
        getAlienImage();
    }

    public void getAlienImage() {

        try {
            up1 = ImageIO.read(new File("img/alien/ufo-up.png"));
            down1 = ImageIO.read(new File("img/alien/ufo.png"));
            left1 = ImageIO.read(new File("img/alien/ufo-left.png"));
            right1 = ImageIO.read(new File("img/alien/ufo-right.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction() {

        // map boundaries not working 100% need to improve random method
        // add movement to entity to avoid duplicate code
        mapBoundaries();

        if (randomNum <= 25) {
            direction = "up";
            if (gp.checkCollision.isFree(alienX, alienY - 1, this)) {
                alienY -= speed;
            } else {
                randomNum = random.nextInt(100);
            }
        }
        if (randomNum > 25 && randomNum <= 50) {
            direction = "down";
            if (gp.checkCollision.isFree(alienX, alienY + 1, this)) {
                alienY += speed;
            } else {
                randomNum = random.nextInt(100);
            }
        }
        if (randomNum > 50 && randomNum <= 75) {
            direction = "left";
            if (gp.checkCollision.isFree(alienX - 1, alienY, this)) {
                alienX -= speed;
            } else {
                randomNum = random.nextInt(100);
            }
        }
        if (randomNum > 75) {
            direction = "right";
            if (gp.checkCollision.isFree(alienX + 1, alienY, this)) {
                alienX += speed;
            } else {
                randomNum = random.nextInt(100);
            }
        }
    }

    public void mapBoundaries() {

        if (alienX - 1 < 0) {
            randomNum = 5;
        } else if (alienX + 1 > 719 - 72) {
            randomNum = 50;
        } else if (alienY - 1 < 0) {
            randomNum = 80;
        } else if (alienY + 1 > 719 - 72) {
            randomNum = 20;
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = switch (direction) {
            case "up" -> up1;
            case "down" -> down1;
            case "left" -> left1;
            case "right" -> right1;
            default -> null;
        };

        collisionAreaAlien = new Rectangle(alienX + 16, alienY + 16, 40, 40);
        g2.drawImage(image, alienX, alienY, 72, 72, null);
    }
}
