package BrickBreaker;

/**
 * This method creates the level and reads throughout the text file and places
 * the bricks onto the canvas.
 *
 * @author Jerid, Last updated: 2/22/2020
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Level {

    protected Scanner file = null;
    private int brickCount = 0;
    protected StandardHandler sh;
    protected String levelUp;
    private final int blockPlacementX = -50;
    private final int blockPlacementY = 40;
    private final int blockPlacementNextX = 80;
    private final int blockPlacementNextRowX = -50;
    private final int blockPlacementNextRowY = 55;

/**
 * Creates the level by placing the blocks in a row. Than looks into a resource file for the coloring and block amount.
* @param level looks into the resource file for levels.
 * @param sh Calls for information from standard handler.
 */
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
            // A for loop for the placement of the blocks to make sure each one is properly spaced and by adding a certain integer to the x variable.
            for (int i = 0; i < line.length() - 1; i++) {
                //This decides how far the next block will be from the most recently placed block
                x += blockPlacementNextX;
                //This places the brick into the entity from the info it had gathered about placements. It also counts the amount of blocks.
                if (Integer.parseInt(line.substring(i, i + 1)) != 0) {
                    sh.addEntity(new Brick(x, y, Integer.parseInt(line.substring(i, i + 1))));
                    this.brickCount++;
                }
            }
            //decides the placement of the next row and how far away it is from the first block in that row, based on a cartesian plane.
            x = blockPlacementNextRowX;
            y += blockPlacementNextRowY;
        }
        //If file is not found than the level is suppose to print file is null.
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
