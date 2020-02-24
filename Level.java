package BrickBreaker;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Rouxk
 */

public class Level {

    protected Scanner file = null;
    public int brickCount = 0;
    protected StandardHandler sh;
    protected String levelUp;

    public Level(String level, StandardHandler sh) {
        this.levelUp = level;

        try {
            this.file = new Scanner(new File(this.levelUp));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int x = 0;
        int y = 0;

        //if()
        try {

            this.file = new Scanner(new File(this.levelUp));
            while (this.file.hasNext()) {

                for (int i = 0; i < 8; i++) {

                    x = 0;
                    y += 55;

                    String line = this.file.nextLine();

                    for (int j = 0; j < 8; j++) {

                        x += 80;

                        if (Integer.parseInt(line.substring(j, j + 1)) != 0) {
                            sh.addEntity(new Brick(x, y, Integer.parseInt(line.substring(j, j + 1))));
                            this.brickCount++;
                        }//else{
                        //  new Level("Resources/Levels/level2.txt", this.sh);
                        //  Level level1 = new Level("Resources/Levels/level2.txt", this.sh);
                        //}
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (file == null) {
            System.err.println((level));
            System.err.println("FILE IS NULL");
            System.exit(0);
        }
    }

    /* public Level(String resourcesLevelslevel2txt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  //  public Level(String resourcesLevelslevel2txt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    public void tick() {
        //this.sh.tick();
        //if(this.brickCount == 0){
        //JOptionPane.showMessageDialog(null, "Would you like to continue: "+ new Level("Resources/Levels/level2.txt", this.sh));
        //System.exit(0);
    }
}

//protected void reload() {
// new Level("Resources/Levels/level2.txt", this.sh);
//  }
//}

