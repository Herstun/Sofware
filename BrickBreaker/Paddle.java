package BrickBreaker;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This is creating a paddle and giving the properties to no go out of the
 * window of the game.
 *
 * @author Tyler Roux
 */
public class Paddle extends StandardGameObject implements KeyListener {

    protected StandardHandler sh;

    public Paddle(double _x, double _y, StandardHandler handler) {
        super(_x, _y, StandardID.Player);
        this.sh = handler;
        this.sh.addEntity(this);
        this.width = 150;
        this.height = 20;
    }

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
     *
     * @param paddle
     */
    @Override
    public void render(Graphics2D paddle) {
        paddle.setColor(Color.GREEN);
        paddle.fillRect((int) this._x, (int) this._y, (int) this.width, (int) this.height);
    }

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

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
