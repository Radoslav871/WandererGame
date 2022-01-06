package object;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ObjectMoney extends ObjectInGame {

    public ObjectMoney() {

        name = "money";

        try {
            image = ImageIO.read(new File("img/object/money.png"));
            image1 = ImageIO.read(new File("img/object/money_for_black_BG.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        collisionOn = true;
    }
}
