package main;

import entity.Entity;
import entity.Ufo;
import object.ObjectInGame;

public class CheckCollision {

    GamePanel gp;

    public CheckCollision(GamePanel gp) {
        this.gp = gp;
    }

    public boolean isFree(int nextX, int nextY, Entity entity) {

        int size = 72;

        //top left
        int topLeftX = (nextX + 10) / size;
        int topLeftY = (nextY + 16) / size;

        //top right
        int topRightX = (nextX + size - 10) / size;
        int topRightY = (nextY + 16) / size;

        //bottom left
        int bottomLeftX = (nextX + 10) / size;
        int bottomLeftY = (nextY + size - 5) / size;

        //bottom right
        int bottomRightX = (nextX + size - 10) / size;
        int bottomRightY = (nextY + size - 5) / size;

        return !((gp.tileM.mapTileNum[topLeftY][topLeftX] == 1 || gp.tileM.mapTileNum[topLeftY][topLeftX] == 2) ||
                (gp.tileM.mapTileNum[topRightY][topRightX] == 1 || gp.tileM.mapTileNum[topRightY][topRightX] == 2) ||
                (gp.tileM.mapTileNum[bottomLeftY][bottomLeftX] == 1 || gp.tileM.mapTileNum[bottomLeftY][bottomLeftX] == 2) ||
                (gp.tileM.mapTileNum[bottomRightY][bottomRightX] == 1 || gp.tileM.mapTileNum[bottomRightY][bottomRightX] == 2));
    }

    public void checkEntity(Entity entity){

        Ufo alien = new Ufo(gp);

        if (entity.collisionArea.intersects(alien.collisionAreaAlien)){
            System.out.println("you hit me");
        }
    }

    public int checkObject(Entity entity, boolean player) {

        // try to simplify this with for loop mb
        int index = 999;
        ObjectInGame oIG = new ObjectInGame();

        if (gp.obj[0] != null) {

            if (entity.collisionArea.intersects(oIG.bootsCollisionArea)) {
                if (gp.obj[0].collisionOn) {
                    entity.collisionOn = true;
                }
                if (player) {
                    index = 0;
                }
            }
        }

        if (gp.obj[1] != null) {

            if (entity.collisionArea.intersects(oIG.keyCollisionArea)) {
                if (gp.obj[1].collisionOn) {
                    entity.collisionOn = true;
                }
                if (player) {
                    index = 1;
                }
            }
        }

        if (gp.obj[2] != null) {
            if (entity.collisionArea.intersects(oIG.doorCollisionArea)) {
                if (gp.obj[2].collisionOn) {
                    entity.collisionOn = true;
                }
                if (player) {
                    index = 2;
                }
            }
        }

        if (gp.obj[3] != null) {
            if (entity.collisionArea.intersects(oIG.moneyCollisionArea)) {
                if (gp.obj[3].collisionOn) {
                    entity.collisionOn = true;
                }
                if (player) {
                    index = 3;
                }
            }
        }
        return index;
    }
}
