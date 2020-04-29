package BrickBreaker.view;

/**
 * This method if for the handling the game and acts as a game engine.
 * @author Jerid, Tyler, Marquis; Last updated: 2/20/2020
 */
import BrickBreaker.*;
import BrickBreaker.controller.StandardGameObject;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import BrickBreaker.view.*;
import BrickBreaker.controller.StandardID;

public class StandardHandler {
protected Boost boost;
    protected ArrayList<StandardGameObject> entities;

    /**
     * This method is declaring the objects with the ArrayList as entities.
     */
    public StandardHandler() {
        this.entities = new ArrayList<StandardGameObject>();
    }

    /**
     * This method is using the tick method to make sure all objects are acting
     * as one and using an if statement that displays a congratulations to the
     * player if they clear all the bricks.
     */
    public void tick() {
        if (this.countBricksAndDetermineWin()) {
            JOptionPane.showMessageDialog(null, "Congrats, you won!" + Game.score);
            Game.twitter.postTweet(Game.score);
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
                    if (entities.get(j).id == StandardID.Brick) {
                        if (entities.get(i).getBounds().intersects(entities.get(j).getBounds())) {
                            Game.score += 100;
                            entities.remove(j);
                            j--;
                            entities.get(i).velY = -entities.get(i).velY;
                        }
                    }
                }
            }

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

    /**
     * This method renders the canvas.
     *
     * @param g2
     */
    public void render(Graphics2D g2) {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).render(g2);
        }
    }

    /**
     * This method allows for additional objects to be added.
     *
     * @param obj
     */
    public void addEntity(StandardGameObject obj) {
        this.entities.add(obj);
    }

    /**
     * This method removes objects that have the incorrect array.
     *
     * @param obj
     */
    public void removeEntity(StandardGameObject obj) {
        for (int i = 0; i < entities.size(); i++) {
            if (obj == entities.get(i)) {
                entities.remove(i);
                i--;
            }
        }
    }

    /**
     * This method removes objects.
     *
     * @param obj
     */
    public void remove(StandardGameObject obj) {
        this.entities.remove(obj);
    }
      public static void boostAmount() {
        Game.score += 5000;
    }

    /**
     * This method counts the number of bricks and if there are zero bricks left
     * then the determination of winning occurs.
     *
     * @return
     */
    public boolean countBricksAndDetermineWin() {
        int brick = 0;
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == StandardID.Brick) {
                brick++;
            }
        }
        return brick == 0;
    }

}
