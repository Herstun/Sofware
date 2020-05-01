package BrickBreaker.controller;

/**
 * This method is for the objects of the game and to declare the variables.
 *
 * @author Dymond; Last updated: 4/15/2020
 */
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class StandardGameObject {

    protected double _x;
    protected double _y;
    protected double velX;
    public double velY;
    protected int width;
    protected int height;
    public StandardID id;

    /**
     * This method declares the variables.
     *
     * @param _x This is the width.
     * @param _y This is the height.
     * @param _id This is the enumeration of all the classes.
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
     * @param _g2 This method is the render method to draw the canvas.
     */
    public abstract void render(Graphics2D _g2);

    /**
     * This method is to make sure the canvas is inside the window and all
     * variables work.
     *
     * @return This returns a new rectangle for the bounds of the canvas.
     */
    public Rectangle getBounds() {
        return new Rectangle((int) _x, (int) _y, (int) width, (int) height);
    }

    //=========================== Getters ======================================
    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;
    }

    public double getVelX() {
        return velX;
    }

    public double getVelY() {
        return velY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public StandardID getId() {
        return id;
    }

    //=============================== Setters ==================================
    public void setX(double _x) {
        this._x = _x;
    }

    public void setY(double _y) {
        this._y = _y;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setId(StandardID id) {
        this.id = id;
    }

}
