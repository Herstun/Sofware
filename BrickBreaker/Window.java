package BrickBreaker;

import java.awt.Canvas;
import javax.swing.JFrame;

/**
 * This creates a canvas for the game to run on.
 *
 * @author Marquis, Last updated: 2/10/2020
 */
public class Window extends Canvas {

    protected final JFrame frame;

    public Window(int width, int height, String title, Game game) {

        this.frame = new JFrame(title);
        this.frame.setSize(width, height);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        this.frame.add(game);
        this.frame.setVisible(true);
    }

    public int width() {
        return this.frame.getWidth();
    }

    public int height() {
        return this.frame.getHeight();
    }
}
