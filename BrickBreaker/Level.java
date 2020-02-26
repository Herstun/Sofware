package BrickBreaker;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * This method creates the level and reads throughout the text file and places
 * the bricks onto the canvas.
 *
 * @author Jerid, Last updated: 2/22/2020
 */
public class Level {

    protected Scanner file = null;
    protected int brickCount = 0;
    protected StandardHandler sh;
    protected String levelUp;
    private final int blockPlacementX = 0;
    private final int blockPlacementY = 40;
    private final int blockPlacementNextX = 80;
    private final int blockPlacementNextRowX = 0;
    private final int blockPlacementNextRowY = 55;

    public Level(String level, StandardHandler sh) {
        this.levelUp = level;

        try {
            this.file = new Scanner(new File(this.levelUp));
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * This places the position of the bricks onto the canvas from left to
         * right.
         */
        int x = blockPlacementX;
        int y = blockPlacementY;

        while (this.file.hasNext()) {
            String line = this.file.nextLine();

            for (int i = 0; i < line.length() - 1; i++) {

                x += blockPlacementNextX;

                if (Integer.parseInt(line.substring(i, i + 1)) != 0) {
                    sh.addEntity(new Brick(x, y, Integer.parseInt(line.substring(i, i + 1))));
                    this.brickCount++;
                }
            }
            x = blockPlacementNextRowX;
            y += blockPlacementNextRowY;
        }

        if (file == null) {
            System.err.println((level));
            System.err.println("FILE IS NULL");
            System.exit(0);
        }
    }

    /**
     * This method is creating a motion along with all the other objects and
     * having the game in sync.
     */
    public void tick() {
    }
}
