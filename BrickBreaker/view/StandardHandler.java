package BrickBreaker.view;

/**
 * This method if for the handling the game and acts as a game engine.
 *
 * @author Jerid, Tyler, Marquis; Last updated: 4/20/2020
 */
import BrickBreaker.controller.GameController;
import BrickBreaker.controller.StandardGameObject;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import BrickBreaker.controller.StandardID;
import static BrickBreaker.view.Boost.boostAmount;

public class StandardHandler {

    protected Boost boost;
    protected ArrayList<StandardGameObject> entities;
    protected String gameWonMessage = "Congrats, you won!";

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
            JOptionPane.showMessageDialog(null, gameWonMessage + GameController.score);
            GameController.twitter.postTweet(GameController.score);
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
                            GameController.score += Brick.ifComboBrickBroken();
                            GameController.score += Brick.pointsPerBlock;
                            entities.remove(j);
                            j--;
                            entities.get(i).velY = -entities.get(i).velY;
                        }
                    }
                }
            }

            if (entities.get(i).id == StandardID.Player) {
                for (int j = 0; j < entities.size(); j++) {
                    if (entities.get(j).id == StandardID.Boost) {
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
     * @param _g2
     */
    public void render(Graphics2D _g2) {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).render(_g2);
        }
    }

    /**
     * This method allows for additional objects to be added.
     *
     * @param _object This adds objects to the game.
     */
    public void addEntity(StandardGameObject _object) {
        this.entities.add(_object);
    }

    /**
     * This method removes objects that have the incorrect array.
     *
     * @param _object This is removing objects from the game.
     */
    public void removeEntity(StandardGameObject _object) {
        for (int i = 0; i < entities.size(); i++) {
            if (_object == entities.get(i)) {
                entities.remove(i);
                i--;
            }
        }
    }

    /**
     * This method removes objects.
     *
     * @param _object This is removing the objects of the game.
     */
    public void remove(StandardGameObject _object) {
        this.entities.remove(_object);
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

    //================================ Getters =====================================
    public Boost getBoost() {
        return boost;
    }

    public ArrayList<StandardGameObject> getEntities() {
        return entities;
    }

    public String getGameWonMessage() {
        return gameWonMessage;
    }

    //================================== Setters ===================================
    public void setBoost(Boost boost) {
        this.boost = boost;
    }

    public void setEntities(ArrayList<StandardGameObject> entities) {
        this.entities = entities;
    }

    public void setGameWonMessage(String gameWonMessage) {
        this.gameWonMessage = gameWonMessage;
    }
}
