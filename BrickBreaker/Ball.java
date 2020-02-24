package BrickBreaker;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;

/**
 * This method creates the ball and makes its properties.
 *
 * @author Tyler Roux, Last updated: 2/24/2020
 */
public class Ball extends StandardGameObject {

    public Ball(double _x, double _y, StandardHandler sh) {
        super(_x, _y, StandardID.Ball);
        sh.addEntity(this);
        this.width = 15;
        this.height = 15;
        this.velX = 5;
        this.velY = -5;
    }

    /**
     * This method is the motion of the ball along with the other in objects in
     * the game and putting them into motion all as one.
     */
    @Override
    public void tick() {
        if (this._x < 0 || this._x >= Game.window.width() - this.width) {
            this.velX = -this.velX;
        }
        if (this._y < 0) {
            this.velY = -this.velY;
        }
        if (this._y >= Game.window.height()) {
            JOptionPane.showMessageDialog(null, "You lost! Your score was: " + Game.score);
            System.exit(0);
        }
        this._x += this.velX;
        this._y += this.velY;
    }

    /**
     * This method draws the ball onto the canvas.
     *
     * @param ball
     */
    @Override
    public void render(Graphics2D ball) {
        ball.setColor(Color.blue);
        ball.fillOval((int) _x, (int) _y, (int) this.width, (int) this.height);
    }
}
