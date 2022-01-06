package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[11];
        mapTileNum = new int[11][11];
        getTileImage();
        loadMap("src/tile/maps/map01.txt");
    }

    public void getTileImage() {

        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(new File("img/floor.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new File("img/wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(new File("img/wall_fake.png"));
            tile[2].collision = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadMap(String path) {

        List<String> myFileLines = null;
        try {
            myFileLines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Remove any blank lines
        for (int i = myFileLines.size() - 1; i >= 0; i--) {
            if (myFileLines.get(i).isEmpty()) {
                myFileLines.remove(i);
            }
        }

        // Declare you 2d array with the amount of lines that were read from the file
        mapTileNum = new int[myFileLines.size()][];

        // Iterate through each row to determine the number of columns
        for (int i = 0; i < myFileLines.size(); i++) {
            // Split the line by spaces
            String[] splitLine = myFileLines.get(i).split("\\s");

            // Declare the number of columns in the row from the split
            mapTileNum[i] = new int[splitLine.length];
            for (int j = 0; j < splitLine.length; j++) {
                // Convert each String element to an integer
                mapTileNum[i][j] = Integer.parseInt(splitLine[j]);
            }
        }

//         Print the integer array
//        for (int[] row : mapTileNum) {
//            for (int col : row) {
//                System.out.printf("%5d ", col);
//            }
//            System.out.println();
//        }
    }

    public void draw(Graphics2D g2) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < 10 && row < 10) {

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, 72, 72, null);
            row++;
            x += 72;

            if (row == 10) {
                row = 0;
                x = 0;
                col++;
                y += 72;
            }
        }
    }
}
