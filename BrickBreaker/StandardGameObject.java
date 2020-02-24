package BrickBreaker;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class StandardGameObject {

    protected double _x;
    protected double _y;
    protected double velX;
    protected double velY;
    protected int width;
    protected int height;
    protected StandardID id;
//    new Level("Resources/Levels/level2.txt", this.sh);

    public StandardGameObject(double _x, double _y, StandardID _id) {
        this._x = _x;
        this._y = _y;

        this.id = _id;
    }

    public abstract void tick();

    public abstract void render(Graphics2D g2);

    public Rectangle getBounds() {
        return new Rectangle((int) _x, (int) _y, (int) width, (int) height);
    }
}
