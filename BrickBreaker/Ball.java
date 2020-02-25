package BrickBreaker;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;

/**
 *
 * @author tjroux
 */
public class Ball extends StandardGameObject {
    private final int ballWidth = 15;
    private final int ballHeight = 15;
    private final int ballVelocityX = 5;
    private final int ballVelocityY = -5;
    public Ball(double _x, double _y, StandardHandler sh) {
        super(_x, _y, StandardID.Ball);
        sh.addEntity(this);
        this.width = ballWidth;
        this.height = ballHeight;
        this.velX = ballVelocityX;
        this.velY = ballVelocityY;
    }

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

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.blue);
        g2.fillOval((int) _x, (int) _y, (int) this.width, (int) this.height);
    }
}
