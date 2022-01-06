package main;

import object.ObjectKey;
import object.ObjectMoney;

import java.awt.*;
import java.awt.image.BufferedImage;

public class playerInterface {
    GamePanel gp;
    Font ink_Free;
    Font ink_FreeMessage;
    BufferedImage image;
    BufferedImage image1;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter;
    public boolean gameFinished = false;

    public playerInterface(GamePanel gp) {
        this.gp = gp;

        ink_Free = new Font("Ink Free", Font.BOLD, 15);
        ink_FreeMessage = new Font("Ink Free", Font.BOLD, 35);
        ObjectKey key = new ObjectKey();
        image = key.image;
        ObjectMoney money = new ObjectMoney();
        image1 = money.image1;

    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        if (gameFinished) {

            String text;
            int textLength;

            g2.setFont(ink_FreeMessage);
            g2.setColor(Color.BLUE);
            text = "You did it one more ?";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            int x = gp.screenWidth / 2 - textLength / 2;
            int y = gp.screenHeight / 2 - (72 * 2);
            g2.drawString(text, x, y);

            gp.gameThread = null;

        } else {
            g2.setFont(ink_Free);
            g2.setColor(Color.WHITE);
            g2.drawImage(image, 710, 30, 72, 72, null);
            g2.drawString("x " + gp.player.hasKeys, 755, 70);

            g2.drawImage(image1, 710, 5, 72, 72, null);
            g2.drawString("x " + gp.player.money, 755, 45);

            if (messageOn) {
                g2.setFont(ink_FreeMessage);
                g2.drawString(message, 20, 360);

                messageCounter++;

                if (messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
    }
}
