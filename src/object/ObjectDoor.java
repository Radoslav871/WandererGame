package object;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ObjectDoor extends ObjectInGame {

    public ObjectDoor() {

        name = "door";

        try {
            image = ImageIO.read(new File("img/object/Door.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        collisionOn = true;
    }
}
