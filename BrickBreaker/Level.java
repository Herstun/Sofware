package BrickBreaker;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * This method creates the level and reads throughout the text file and places
 * the bricks onto the canvas.
 *
 * @author Jerid Mei, Last updated: 2/22/2020
 */
public class Level {

    protected Scanner file = null;
    protected int brickCount = 0;
    protected StandardHandler sh;
    protected String levelUp;

    public Level(String level, StandardHandler sh) {
        this.levelUp = level;

        try {
            System.out.println(levelUp);
            this.file = new Scanner(new File(this.levelUp));
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * This places the position of the bricks onto the canvas from left to
         * right.
         */
        int x = 0;
        int y = 40;

        while (this.file.hasNext()) {
            String line = this.file.nextLine();

            for (int i = 0; i < line.length() - 1; i++) {

                x += 80;

                if (Integer.parseInt(line.substring(i, i + 1)) != 0) {
                    sh.addEntity(new Brick(x, y, Integer.parseInt(line.substring(i, i + 1))));
                    this.brickCount++;
                }
            }
            x = 0;
            y += 55;
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
