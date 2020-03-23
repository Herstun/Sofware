package BrickBreaker;

/**
 * This is creating a paddle and giving the properties to no go out of the
 * window of the game.
 *
 * @author Dymond, Last updated 2/21/2020
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle extends StandardGameObject implements KeyListener {

    protected StandardHandler sh;
    private int paddleWidth = 150;
    private int paddleHeight = 20;

    /**
     * This method creates the parameters of the paddle.
     *
     * @param _x
     * @param _y
     * @param handler
     */
    public Paddle(double _x, double _y, StandardHandler _handler) {

        super(_x, _y, StandardID.Player);
        this.sh = _handler;
        this.sh.addEntity(this);
        this.width = paddleWidth;
        this.height = paddleHeight;
    }

    /**
     * This method controls the game and the objects all at the same motion.
     */
    @Override
    public void tick() {
        if (this._x < 0) {
            this._x = 0;
        }

        if (this._x > Game.window.width() - this.width) {
            this._x = Game.window.width() - this.width;
        }

        if (this._y < 0) {
            this._y = 0;
        }

        if (this._y > Game.window.height() - this.height) {
            this._y = Game.window.height() - this.height;
        }

        this._x += velX;
    }

    /**
     * Draws the paddle and makes it the color you would like.
     *
     * @param paddle
     */
    @Override
    public void render(Graphics2D paddle) {
        paddle.setColor(Color.GREEN);
        paddle.fillRect((int) this._x, (int) this._y, (int) this.width, (int) this.height);
    }

    /**
     * This is controlling the motion of the paddle while pressing the key.
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                this.velX = -10;
                break;
            case KeyEvent.VK_RIGHT:
                this.velX = 10;
                break;
        }
    }

    /**
     * This is controlling the motion of the paddle while not pressing the key
     * allowing it to not move.
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                this.velX = 0;
                break;
            case KeyEvent.VK_RIGHT:
                this.velX = 0;
                break;
        }
    }

    /**
     * This method is used for the if a key is typed it will not cause any
     * actions.
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }
}
