package entity;
import main.GamePanel;
import main.KeyHandler;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {

    KeyHandler keyH;
    public int hasKeys = 0;
    public int money = 0;

    public Player(GamePanel gp, KeyHandler keyH) {

        super(gp);

        this.keyH = keyH;
        collisionArea = new Rectangle(x + 8, y + 16, 40, 40);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 0;
        y = 0;
        speed = 3;
        money = 0;
        direction = "down";
    }

    public void getPlayerImage() {

        try {
            up1 = ImageIO.read(new File("img/hero-up.png"));
            down1 = ImageIO.read(new File("img/hero-down.png"));
            left1 = ImageIO.read(new File("img/hero-left.png"));
            right1 = ImageIO.read(new File("img/hero-right.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        collisionOn = false;

        if (keyH.upPressed) {
            direction = "up";
            if (gp.checkCollision.isFree(x, y - speed, this)) {
                y -= speed;
                collisionOn = true;
            }
        } else if (keyH.downPressed) {
            direction = "down";
            if (gp.checkCollision.isFree(x, y + speed, this)) {
                y += speed;
                collisionOn = true;
            }
        } else if (keyH.leftPressed) {
            direction = "left";
            if (gp.checkCollision.isFree(x - speed, y, this)) {
                x -= speed;
                collisionOn = true;
            }
        } else if (keyH.rightPressed) {
            direction = "right";
            if (gp.checkCollision.isFree(x + speed, y, this)) {
                x += speed;
                collisionOn = true;
            }
        }

        int objIndex = gp.checkCollision.checkObject(this, true);
        pickUpObject(objIndex);

        gp.checkCollision.checkEntity(this);

        mapBoundaries();
    }

    public void mapBoundaries() {

        if (x < 0) {
            x = 0;
        } else if (x > 719 - 72) {
            x = 720 - 72;
        } else if (y < 0) {
            y = 0;
        } else if (y > 719 - 72) {
            y = 720 - 72;
        }
    }

    public void pickUpObject(int i) {

        if (i != 999) {
            String objectName = gp.obj[i].name;

            switch (objectName) {
                case "key":
                    hasKeys++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("You found a key! You can now open a door");
                    System.out.println("key: " + hasKeys);
                    System.out.println("speed: " + speed);
                    break;
                case "door":
                    if (hasKeys > 0) {
                        gp.obj[i] = null;
                        hasKeys--;
                        gp.ui.showMessage("you opened a door");
                        gp.ui.gameFinished = true;
                        break;
                    } else {
                        break;
                    }
                case "boots":
                    speed += 1;
                    gp.ui.showMessage("Yours speed increase by 1!");
                    System.out.println("key: " + hasKeys);
                    System.out.println("speed: " + speed);
                    gp.obj[i] = null;
                    break;
                case "money":
                    money += 1;
                    gp.ui.showMessage("MONEY !!!");
                    System.out.println("key: " + hasKeys);
                    System.out.println("speed: " + money);
                    gp.obj[i] = null;
                    break;
            }

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

        collisionArea = new Rectangle(x, y, 72, 72);
        g2.drawImage(image, x, y, 72, 72, null);
    }

}

