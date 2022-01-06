package object;

import main.GamePanel;

public class SettingObject {

    GamePanel gp;

    public SettingObject(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        gp.obj[0] = new ObjectBoots();
        gp.obj[0].objectX = 72 * 5 + 15;
        gp.obj[0].objectY = 72 * 5 + 15;

        gp.obj[1] = new ObjectKey();
        gp.obj[1].objectX = 72 * 9;
        gp.obj[1].objectY = 72 * 9;

        gp.obj[2] = new ObjectDoor();
        gp.obj[2].objectX = 72 * 9;
        gp.obj[2].objectY = 72 * 0;

        gp.obj[3] = new ObjectMoney();
        gp.obj[3].objectX = 72 * 0;
        gp.obj[3].objectY = 72 * 9;

    }

}
