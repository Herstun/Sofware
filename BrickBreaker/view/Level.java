package BrickBreaker.view;

/**
 * This method creates the level and reads throughout the text file and places
 * the bricks onto the canvas.
 *
 * @author Jerid, Last updated: 4/22/2020
 */
import BrickBreaker.model.GameController;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Level {

    protected Scanner file;
    protected StandardHandler sh;
    protected GameController game;
    protected String level;
    private final int blockPlacementX = 0;
    private final int blockPlacementY = 40;
    private final int blockPlacementNextX = 80;
    private final int blockPlacementNextRowX = 0;
    private final int blockPlacementNextRowY = 55;
    private ArrayList<Brick> brickCount;
    protected String noFile = "FILE IS NULL";

    public Level(String _level, StandardHandler _sh) {
        this.level = _level;
        this.sh = _sh;
        this.brickCount = new ArrayList<Brick>();

        try {
            this.file = new Scanner(new File(this.level));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.initialize();
    }

    /**
     * This places the position of the bricks onto the canvas from left to
     * right.
     */
    public void initialize() {
        int x = blockPlacementX;
        int y = blockPlacementY;

        while (this.file.hasNext()) {
            //This goes to the level text file and reads the line like a book.
            String line = this.file.nextLine();

            for (int i = 0; i < line.length() - 1; i++) {

                //This adds brick placement to the right of the brick.
                x += blockPlacementNextX;

                //This prints the brick in an increasing order from the level file.
                if (Integer.parseInt(line.substring(i, i + 1)) != 0) {
                    sh.addEntity(new Brick(x, y, Integer.parseInt(line.substring(i, i + 1))));
                }
            }
            //This adds a brick to the leftmost side of the row under the present row.
            x = blockPlacementNextRowX;
            //This adds a new row of bricks.
            y += blockPlacementNextRowY;
        }

        //This tries finding the level file and if there is no file found then
        //an error will occur and print File is Null.
        if (file == null) {
            System.err.println((level));
            System.err.println(noFile);
            System.exit(0);
        }
    }

    /**
     * This method is creating a motion along with all the other objects and
     * having the game in sync.
     */
    public void tick() {
    }

    /**
     * This generates the level and counts the bricks until there is no more and
     * then the level will end.
     *
     * @param _level This is the level that is created in the text file.
     */
    public void render(Graphics2D _level) {
        for (int i = 0; i < brickCount.size(); i++) {
            this.brickCount.get(i).render(_level);
        }
    }

    //============================ Getters =====================================
    public Scanner getFile() {
        return file;
    }

    public StandardHandler getSh() {
        return sh;
    }

    public GameController getGame() {
        return game;
    }

    public String getLevel() {
        return level;
    }

    public int getBlockPlacementX() {
        return blockPlacementX;
    }

    public int getBlockPlacementY() {
        return blockPlacementY;
    }

    public int getBlockPlacementNextX() {
        return blockPlacementNextX;
    }

    public int getBlockPlacementNextRowX() {
        return blockPlacementNextRowX;
    }

    public int getBlockPlacementNextRowY() {
        return blockPlacementNextRowY;
    }

    public ArrayList<Brick> getBrickCount() {
        return brickCount;
    }

    public String getNoFile() {
        return noFile;
    }

    //============================ Setters =====================================
    public void setFile(Scanner file) {
        this.file = file;
    }

    public void setSh(StandardHandler sh) {
        this.sh = sh;
    }

    public void setGame(GameController game) {
        this.game = game;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setBrickCount(ArrayList<Brick> brickCount) {
        this.brickCount = brickCount;
    }

    public void setNoFile(String noFile) {
        this.noFile = noFile;
    }
}
