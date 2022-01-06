package object;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ObjectKey extends ObjectInGame {

    public ObjectKey() {

        name = "key";

        try {
            image = ImageIO.read(new File("img/object/Key.png"));

        } catch (
                IOException e) {
            e.printStackTrace();
        }

        collisionOn = true;
    }
}
