package BrickBreaker;

import com.sun.prism.paint.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.image.BufferStrategy;
import java.util.concurrent.TimeUnit;

public class StandardHandler {

    private final ArrayList<StandardGameObject> entities;
    static int brickBroken = 0;
    protected Boost boost;
    protected static StandardHandler sh;
    protected Level level;
    protected static int atlevel = 1;

    public StandardHandler() {
        this.entities = new ArrayList<StandardGameObject>();
    }
    /*
    Tick is used to make sure the program runs together. Count bricks and determine win tells us if the level is complete and is time to prcede.
    */
    public void tick() {
        if (this.countBricksAndDetermineWin()) {
            this.nextLevel();

            System.exit(0);
        }
        for (int i = 0; i < entities.size(); i++) {
            //Grabs the player
            if (this.entities.get(i).id == StandardID.Player) {
                for (int j = 0; j < entities.size(); j++) {
                    if (entities.get(j).id == StandardID.Ball) {
                        //Collision between player & ball
                        if (entities.get(i).getBounds().intersects(entities.get(j).getBounds())) {
                            entities.get(j).velY = -entities.get(j).velY;
                        }
                    }
                }
            }

            //Grabs the ball
            if (entities.get(i).id == StandardID.Ball) {
                for (int j = 0; j < entities.size(); j++) {
                    //creates the bricks
                    if (entities.get(j).id == StandardID.Brick) {
                        if (entities.get(i).getBounds().intersects(entities.get(j).getBounds())) {
                            Game.score += Game.gameScoreIncrease;
                            //Removes the brick and count the scores.
                            entities.remove(j);
                            brickCountUp();
                            j--;
                            //ball bounces backwards after hitting brick.
                            entities.get(i).velY = -entities.get(i).velY;
                        }
                    }
                }
            }
            /*
            Boost hits the player and disappear giving you a massive amount of points.
            */
            if(entities.get(i).id == StandardID.Player){
                for (int j= 0; j<entities.size(); j++){
                    if(entities.get(j).id == StandardID.Boost){
                        if (entities.get(j).getBounds().intersects(entities.get(i).getBounds())) {
                            entities.remove(j);
                            boostAmount();
                        }
                    }
                }
            }
            this.entities.get(i).tick();
        }
    }
    // allow the sprites to render.
    public void render(Graphics2D g2) {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).render(g2);
        }
    }
    //allow the blocks to be placed upon the window.
    public void addEntity(StandardGameObject obj) {
        this.entities.add(obj);
    }

    public void removeEntity(StandardGameObject obj) {
        for (int i = 0; i < entities.size(); i++) {
            if (obj == entities.get(i)) {
                entities.remove(i);
                i--;
            }
        }
    }

    public void remove(StandardGameObject obj) {
        this.entities.remove(obj);
        //      int brick;
    }
    /**
     *
     * @return
     */
    public boolean countBricksAndDetermineWin(){
        /*for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == StandardID.Brick) {
                brick++;
               // this.Level = new Level("Resources/Levels/level2.txt", this.sh);
            }
            //   new Level("Resources/Levels/level2.txt", this.sh);
        }
        // new Level("Resources/Levels/level2.txt", this.sh);
        return brick == 0;
*/
        return false;
    }
    /*
    If boost is broken than the amount awarded to your game score is 500.
    */
    public static void boostAmount() {
        Game.score += 5000;
    }
    /*
    counts how many blocks have been broken by how many times it has been called upon. Eventually the level of 29 blocks will be broken through and
    execute onward to next level.
    */
    public void brickCountUp() {
        brickBroken+=1;
    }
    /*
    Purpose is for print out level passing message and to pass on message to change levels.
    */
    public void nextLevel() {
        Level.atLevel += 1;
        StandardHandler.atlevel = Level.atLevel;
        //Game.levelPassStop();
        JOptionPane.showMessageDialog(null, "Congrats, you pass this level !  " + brickBroken + " Blocks broken");
        Level.levelOneComplete();
    }
   // public static void tellToStart() {
        //Game.startAgain();
    //}
}
