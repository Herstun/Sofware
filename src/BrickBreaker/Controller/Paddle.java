package BrickBreaker.Controller;

/**
 * This is creating a paddle and giving the properties to no go out of the
 * window of the game.
 *
 * @author Dymond, Last updated 4/21/2020
 */
import BrickBreaker.view.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import BrickBreaker.model.StandardGameObject;
import BrickBreaker.model.StandardID;
import BrickBreaker.model.GameModel;

public class Paddle extends StandardGameObject implements KeyListener {

    protected StandardHandler sh;
    private final int paddleWidth = 150;
    private final int paddleHeight = 20;
    protected final int keyReleasedVelXLeft = 0;
    protected final int keyReleasedVelXRight = 0;
    protected final int keyPressedLeftVelX = -10;
    protected final int keyPressedRightVelX = 10;

    /**
     * This method creates the parameters of the paddle.
     *
     * @param _x This is the width of the paddle.
     * @param _y This is the height of the paddle.
     * @param handler This communicates with the standard handler.
     */
    public Paddle(double _x, double _y, StandardHandler _handler) {

        super(_x, _y, StandardID.Player);
        this.sh = _handler;
        this.sh.addEntity(this);
        this.width = paddleWidth;
        this.height = paddleHeight;
    }

    /**
     * This method controls the paddle to stay in the screen.
     */
    @Override
    public void tick() {
        if (this._x < 0) {
            this._x = 0;
        }

        if (this._x > GameModel.window.width() - this.width) {
            this._x = GameModel.window.width() - this.width;
        }
        this._x += velX;
    }

    /**
     * Draws the paddle and makes it the color you would like.
     *
     * @param _paddle This is the generator of the paddle.
     */
    @Override
    public void render(Graphics2D _paddle) {
        _paddle.setColor(Color.GREEN);
        _paddle.fillRect((int) this._x, (int) this._y, (int) this.width, (int) this.height);
    }

    /**
     * This is controlling the motion of the paddle while pressing the key.
     *
     * @param _e This controls the paddle while a key is pressed.
     */
    @Override
    public void keyPressed(KeyEvent _e) {
        switch (_e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                this.velX = keyPressedLeftVelX;
                break;
            case KeyEvent.VK_RIGHT:
                this.velX = keyPressedRightVelX;
                break;
        }
    }

    /**
     * This is controlling the motion of the paddle while not pressing the key
     * allowing it to not move.
     *
     * @param _e This allows the paddle to not be moved if the key is not
     * pressed.
     */
    @Override
    public void keyReleased(KeyEvent _e) {
        switch (_e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                this.velX = keyReleasedVelXLeft;
                break;
            case KeyEvent.VK_RIGHT:
                this.velX = keyReleasedVelXRight;
                break;
        }
    }

    /**
     * This method is used for when a key is typed it will not cause any
     * actions.
     *
     * @param _e This is an event key that is used as a place point showing
     * nothing happens if a key is typed.
     */
    @Override
    public void keyTyped(KeyEvent _e) {
    }

    //======================== Getters =========================================
    public StandardHandler getSh() {
        return sh;
    }

    public int getPaddleWidth() {
        return paddleWidth;
    }

    public int getPaddleHeight() {
        return paddleHeight;
    }

    public int getKeyReleasedVelXLeft() {
        return keyReleasedVelXLeft;
    }

    public int getKeyReleasedVelXRight() {
        return keyReleasedVelXRight;
    }

    public int getKeyPressedLeftVelX() {
        return keyPressedLeftVelX;
    }

    public int getKeyPressedRightVelX() {
        return keyPressedRightVelX;
    }

    //======================= Setters ==========================================
    public void setSh(StandardHandler sh) {
        this.sh = sh;
    }

}
