package BrickBreaker;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Rouxk
 */
public class Level {
    private final int blockPlacementX = 0;
    private final int blockPlacementY = 40;
    private final int blockPlacementNextX = 80;
    private final int blockPlacementNextRowX = 0;
    private final int blockPlacementNextRowY = 0;
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

        int x = blockPlacementX;
        int y = blockPlacementY;

        //if()
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

    public void tick() {
    }
}
