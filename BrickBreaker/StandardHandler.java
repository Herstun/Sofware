package BrickBreaker;

import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * This method if for the
 *
 * @author Jerid Mei, Last updated: 2/20/2020
 */
public class StandardHandler {

    private ArrayList<StandardGameObject> entities;

    /**
     *
     */
    public StandardHandler() {
        this.entities = new ArrayList<StandardGameObject>();
    }

    /**
     * Opens new window with Text
     */
    public void tick() {
        if (this.countBricksAndDetermineWin()) {
            JOptionPane.showMessageDialog(null, "Congrats, you won!");
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
            this.entities.get(i).tick();
        }
    }
/**
 *
 * @param g2
 */
    public void render(Graphics2D g2) {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).render(g2);
        }
    }

    /**
     *
     * @param obj
     *
    public void addEntity(StandardGameObject obj) {
        this.entities.add(obj);
    }

    /**
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
     *
     * @param obj
     */
    public void remove(StandardGameObject obj) {
        this.entities.remove(obj);
    }

    /**
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
