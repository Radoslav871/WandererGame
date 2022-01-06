package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Skeleton extends Entity {

    Random random = new Random();
    public int randomNum = 28;

    public int skeletonX = 72 * 4 + 1;
    public int skeletonY = 72 * 0 + 1;

    public Skeleton(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;
        collisionArea = new Rectangle(skeletonX + 16, skeletonY + 16, 40, 40);

        getSkeletonImage();
    }

    public void getSkeletonImage() {

        try {
            down1 = ImageIO.read(new File("img/skeleton.png"));

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
            if (gp.checkCollision.isFree(skeletonX, skeletonY - 1, this)) {
                skeletonY -= speed;
            } else {
                randomNum = random.nextInt(100);
            }
        }
        if (randomNum > 25 && randomNum <= 50) {
            direction = "down";
            if (gp.checkCollision.isFree(skeletonX, skeletonY + 1, this)) {
                skeletonY += speed;
            } else {
                randomNum = random.nextInt(100);
            }
        }
        if (randomNum > 50 && randomNum <= 75) {
            direction = "left";
            if (gp.checkCollision.isFree(skeletonX - 1, skeletonY, this)) {
                skeletonX -= speed;
            } else {
                randomNum = random.nextInt(100);
            }
        }
        if (randomNum > 75) {
            direction = "right";
            if (gp.checkCollision.isFree(skeletonX + 1, skeletonY, this)) {
                skeletonX += speed;
            } else {
                randomNum = random.nextInt(100);
            }
        }
    }

    public void mapBoundaries() {

        if (skeletonX  - 1 < 0) {
            randomNum = 5;
        } else if (skeletonX + 1 > 719 - 72) {
            randomNum = 50;
        } else if (skeletonY - 1 < 0) {
            randomNum = 80;
        } else if (skeletonY + 1 > 719 - 72) {
            randomNum = 20;
        }
    }

    public void draw(Graphics2D g2) {

        g2.drawImage(down1, skeletonX, skeletonY, 72, 72, null);
    }
}
