package BrickBreaker;

/**
 * This creates the bricks height and width as well as the color of the brick.
 * @author Tyler, Last updated 2/23/2020
 */
import java.awt.Color;
import java.awt.Graphics2D;

public class Brick extends StandardGameObject {

    protected final int brickWidth = 80;
    protected final int brickHeight = 20;
    protected Color color;
    private Color brickColorTypeOne = Color.RED;
    private Color brickColorTypeTwo = Color.BLUE;
    private Color brickColorTypeThree = Color.GREEN;
    private Color brickColorTypeFour = Color.ORANGE;

    /**
     * This method creates the brick and makes the color of the brick with the
     * number it correlates to with the level text.
     *
     * @param _x
     * @param _y
     * @param _val
     */
    public Brick(double _x, double _y, int _val) {
        super(_x, _y, StandardID.Brick);
        this.width = brickWidth;
        this.height = brickHeight;

        switch (_val) {
            case 0:
                return;
            case 1:
                //red brick
                this.color = brickColorTypeOne;
                break;
            case 2:
                //blue brick
                this.color = brickColorTypeTwo;
                break;
            case 3:
                //green brick
                this.color = brickColorTypeThree;
                break;
            case 4:
                //Orange brick
                this.color = brickColorTypeFour;
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
     * @param brick
     */
    @Override
    public void render(Graphics2D brick) {
        brick.setColor(this.color);
        brick.fillRect((int) _x, (int) _y, (int) width, (int) height);
    }
}
