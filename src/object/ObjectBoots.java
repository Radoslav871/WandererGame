package object;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ObjectBoots extends ObjectInGame {

    public ObjectBoots() {
        name = "boots";

        try {

            image = ImageIO.read(new File("img/object/Boots.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        collisionOn = true;
    }
}
