package BrickBreaker;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *This creates the bricks height and width as well as the color of the brick.
 * @author tjroux
 */
public class Brick extends StandardGameObject{
    protected Color color;
    private final int brickWidth = 80;
    private final int brickHeight = 20;

    public Brick(double _x, double _y, int _val){
        super(_x, _y, StandardID.Brick);
        this.width = brickWidth;
        this.height = brickHeight;
        switch(_val){
            case 0: return;
            case 1: this.color = Color.RED; break; //red
            case 2: this.color = Color.BLUE; break; //blue
            case 3: this.color = Color.GREEN;break;//green
            case 4: this.color = Color.ORANGE;break;//yellow
        }
    }

    //This method keeps the game running with all the components together.
    @Override
    public void tick(){
    }

    @Override
    public void render(Graphics2D g2){
        g2.setColor(this.color);
        g2.fillRect((int) _x , (int) _y, (int) width, (int) height);
    }
}
