package BrickBreaker.view;

/**
 * This class is supposed to add a boost for the score to increase the score by
 * 5000 points.
 *
 * @author Jerid, Last updated 4/19/20
 */
import BrickBreaker.model.GameModel;
import BrickBreaker.model.StandardGameObject;
import BrickBreaker.model.StandardID;
import java.awt.Color;
import java.awt.Graphics2D;

public class Boost extends StandardGameObject {

    protected final int boostHeight = 10;
    protected final int boostWidth = 10;
    protected final int boostVelocityY = -5;
    protected static double rateDrop = 5;
    protected static int perIncreaseWidth = 500;
    protected final int createDropX = 450;
    protected final int createDropY = -500;
    protected final static int boostPoints = 5000;
    protected final Color boostColor = Color.red;

    /*
    This creates the boost block that comes down and would increase the width of the paddle if caught.
     @param _x Creates the X level for where the block will place. Will be based on the standard handler when block is destroyed.
    *@param _y Creates the Y level for where the block will place. Will be base don the standard handler when block is destroyed.
    *@param width Creates the block for boost that has a width for the block.
    *@param height Creates the height for the boost block that falls down.
    *@param velX the rate of fall for boost block.
     */
    public Boost(double _x, double _y, StandardHandler _sh) {
        super(_x, _y, StandardID.Boost);

        _sh.addEntity(this);
        this._x = createDropX;
        this._y = createDropY;
        this.width = boostWidth;
        this.height = boostHeight;
        this.velY = boostVelocityY;
    }

    /**
     * This method keeps the game running with all the components together.
     */
    @Override
    public void tick() {
        //This is the vertical motion of the boost.
        this._y += -this.velY;
    }

    /**
     * This method draws the boost onto the canvas.
     *
     * @param _boost Creating the shape of boost and making the color red.
     */
    @Override
    public void render(Graphics2D _boost) {
        _boost.setColor(boostColor);
        _boost.fillRect((int) _x, (int) _y, (int) width, (int) height);
    }

    /**
     * This is the extra boost points being added to the score.
     */
    public static void boostAmount() {
        GameModel.score += boostPoints;
    }

    //============================ Getters =====================================
    public static double getRateDrop() {
        return rateDrop;
    }

    public static int getPerIncreaseWidth() {
        return perIncreaseWidth;
    }

    public int getBoostHeight() {
        return boostHeight;
    }

    public int getBoostWidth() {
        return boostWidth;
    }

    public int getBoostVelocityY() {
        return boostVelocityY;
    }

    public int getCreateDropX() {
        return createDropX;
    }

    public int getCreateDropY() {
        return createDropY;
    }

    public static int getBoostPoints() {
        return boostPoints;
    }

    public Color getBoostColor() {
        return boostColor;
    }

    //============================= Setters ====================================
    public static void setRateDrop(double rateDrop) {
        Boost.rateDrop = rateDrop;
    }

    public static void setPerIncreaseWidth(int perIncreaseWidth) {
        Boost.perIncreaseWidth = perIncreaseWidth;
    }

}
