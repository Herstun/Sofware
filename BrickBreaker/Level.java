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
import java.awt.Graphics2D;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Level {

    protected Scanner file;
    //protected int brickCount = 0;
    protected StandardHandler sh;
    protected Game game;
    protected String levelUp;
    private final int blockPlacementX = 0;
    private final int blockPlacementY = 40;
    private final int blockPlacementNextX = 80;
    private final int blockPlacementNextRowX = 0;
    private final int blockPlacementNextRowY = 55;
    private boolean won = false;
    private ArrayList<Brick> brickCount;

    public Level(String level, StandardHandler sh) {
        this.levelUp = level;
        this.sh = sh;
        this.brickCount = new ArrayList<Brick>();

        try {
            this.file = new Scanner(new File(this.levelUp));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        this.initialize();
    }

    Level(String string, Game aThis, StandardHandler sh) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            System.err.println((levelUp));
            System.err.println("FILE IS NULL");
            System.exit(0);
        }
    }


    /**
     * This method is creating a motion along with all the other objects and
     * having the game in sync.
     */
    public void tick() {
        if(this.brickCount.isEmpty()){
            this.game.won = true;
            return;
        }
        else
            this.game.won = false;
        boolean lost = true;
        if(!this.game.won){
            for(Object o : this.sh.getEntities()){
                if(o instanceof Ball){
                    lost = false;
                    break;
                }
            }
        }
        if(lost)
            this.game.lost = lost;
    }
    public void render(Graphics2D g2){
		for(int i = 0; i<brickCount.size(); i++)
			this.brickCount.get(i).render(g2);
    }
    public void reload(){
		this.brickCount.clear();

		for(int i = 0; i<this.sh.entities.size(); i++){

			if(this.sh.entities.get(i).id != StandardID.Player){
				this.sh.removeEntity(this.sh.entities.get(i));
				i--;
			}
		}

		try {
			this.file = new Scanner(new File(this.levelUp));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.initialize();

		return;
	}

	public void clear(){
		for(int i = 0; i<this.sh.entities.size(); i++){

			if(this.sh.entities.get(i).id != StandardID.Player){
				this.sh.removeEntity(this.sh.entities.get(i));
				i--;
			}
		}
	}
        public String getLevelUp(){
		return this.levelUp;
	}
        /*
        //int brickCount = 0;
        for(int i = 0;i > 200; i++)
    try {
			this.file = new Scanner(new File(this.levelUp));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    new Level("src/Resources/Levels/Level2.txt", this.sh);
}*/
}



