package BrickBreaker.view;

/**
 * This method creates the level and reads throughout the text file and places
 * the bricks onto the canvas.
 *
 * @author Jerid, Last updated: 2/22/2020
 */
import BrickBreaker.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Graphics2D;
//import java.io.FileNotFoundException;
import java.util.ArrayList;
import BrickBreaker.view.Brick;
import BrickBreaker.controller.*;

public class Level {

    protected Scanner file;
    protected StandardHandler sh;
    protected Game game;
    protected String level;
    private final int blockPlacementX = 0;
    private final int blockPlacementY = 40;
    private final int blockPlacementNextX = 80;
    private final int blockPlacementNextRowX = 0;
    private final int blockPlacementNextRowY = 55;
    private ArrayList<Brick> brickCount;

    public Level(String _level, StandardHandler _sh) {
        this.level = _level;
        this.sh = _sh;
        this.brickCount = new ArrayList<Brick>();

        try {
            this.file = new Scanner(new File(this.level));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        this.initialize();
    }
        /**
         * This places the position of the bricks onto the canvas from left to
         * right.
         */
        public void initialize(){
        int x = blockPlacementX;
        int y = blockPlacementY;

        while (this.file.hasNext()) {
            String line = this.file.nextLine();

            for (int i = 0; i < line.length() - 1; i++) {

                x += blockPlacementNextX;

                if (Integer.parseInt(line.substring(i, i + 1)) != 0) {
                    sh.addEntity(new Brick(x, y, Integer.parseInt(line.substring(i, i + 1))));
                   // this.brickCount++;
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
    public void render(Graphics2D _level){
		for(int i = 0; i<brickCount.size(); i++)
			this.brickCount.get(i).render(_level);
    }
}




