package BrickBreaker;

import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tjroux
 */
public class StandardHandler {

    private ArrayList<StandardGameObject> entities;

    public StandardHandler() {
        this.entities = new ArrayList<StandardGameObject>();
    }

    public void tick() {

        if (this.countBricksAndDetermineWin()) {
            //new Level("Resources/Levels/Level2.txt", this.sh);
            JOptionPane.showMessageDialog(null, "Congrats, you won!");
            System.exit(0);
        }
        /* if (brick == 0){
                    Level level;
                    level = new Level("Resources/Levels/level2.txt", this.sh);
                    determine();
                }*/

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

    public void render(Graphics2D g2) {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).render(g2);
        }
    }

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
    }

    //      int brick;
    public boolean countBricksAndDetermineWin() {

        int brick = 0;

        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == StandardID.Brick) {
                brick++;
                // new Level("Resources/Levels/level2.txt", this.sh);
            }
            //   new Level("Resources/Levels/level2.txt", this.sh);
        }
        // new Level("Resources/Levels/level2.txt", this.sh);
        return brick == 0;

    }
}

// private void Level() {
//         Level level = new Level("Resources/Levels/level2.txt", this.sh);
// }
//  protected boolean determine() {
//    return countBricksAndDetermineWin() == true;
//}
//}

