package BrickBreaker;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * This method is for the objects of the game and to declare the variables.
 *
 * @author Dymond, Tyler,Jerid, and Marquis; Last updated: 2/15/2020
 */
public abstract class StandardGameObject {

    protected double _x;
    protected double _y;
    protected double velX;
    protected double velY;
    protected int width;
    protected int height;
    protected StandardID id;

    /**
     * This method declares the variables.
     *
     * @param _x
     * @param _y
     * @param _id
     */
    public StandardGameObject(double _x, double _y, StandardID _id) {
        this._x = _x;
        this._y = _y;
        this.id = _id;
    }

    /**
     * This method creates the abstract tick class for the whole game to move as
     * one.
     */
    public abstract void tick();

    /**
     * This method is the abstract render method that draws the canvas and
     * objects onto the canvas.
     *
     * @param g2
     */
    public abstract void render(Graphics2D g2);

    /**
     * This method is to make sure the canvas is inside the window and all
     * variables work.
     *
     * @return
     */
    public Rectangle getBounds() {
        return new Rectangle((int) _x, (int) _y, (int) width, (int) height);
    }
}
