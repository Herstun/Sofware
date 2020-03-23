package BrickBreaker;

/**
 * This creates the bricks height and width as well as the color of the brick.
 *
 * @author Tyler, Last updated 2/23/2020
 */

import java.awt.Color;
import java.awt.Graphics2D;

public class Brick extends StandardGameObject {

    protected final int brickWidth = 80;
    protected final int brickHeight = 20;
    protected Color color;
    private final int red = 1;
    private final int blue = 2;
    private final int green = 3;
    private final int yellow = 4;

    /**
     * This method creates the brick and makes the color of the brick with the
     * number it correlates to with the level text.
     *
     * @param _x Tells the placement of brick in an x coordinate plane.
     * @param _y Tells the placement of first brick in a y coordinate plane.
     * @param _val It tells the standard game object what color the brick will be.
     */
    public Brick(double _x, double _y, int _val) {
        super(_x, _y, StandardID.Brick);
        this.width = brickWidth;
        this.height = brickHeight;

        switch (_val) {
            case 0:
                return;
            case red:
                //red brick
                this.color = Color.RED;
                break;
            case blue:
                //blue brick
                this.color = Color.BLUE;
                break;
            case green:
                //green brick
                this.color = Color.GREEN;
                break;
            case yellow:
                //yellow brick
                this.color = Color.ORANGE;
                break;
        }
    }

    /**
     * This method keeps the game running with all the components together.
     */
    @Override
    public void tick() {
    }

    /**
     * This method draws the brick onto the canvas.
     *
     * @param brick
     */
    @Override
    public void render(Graphics2D brick) {
        brick.setColor(this.color);
        brick.fillRect((int) _x, (int) _y, (int) width, (int) height);
    }
}
