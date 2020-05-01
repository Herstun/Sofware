package BrickBreaker.view;

/**
 * This creates a canvas for the game to run on.
 *
 * @author Marquis, Last updated: 3/20/2020
 */
import BrickBreaker.controller.GameController;
import java.awt.Canvas;
import javax.accessibility.AccessibleContext;
import javax.swing.JFrame;

public class Window extends Canvas {

    protected final JFrame frame;

    public Window(int _width, int _height, String _title, GameController _game) {
        this.frame = new JFrame(_title);
        this.frame.setSize(_width, _height);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        this.frame.add(_game);
        this.frame.setVisible(true);
    }

    //This gathers the width for the game canvas.
    public int width() {
        return this.frame.getWidth();
    }

    //This gathers the height for the game canvas.
    public int height() {
        return this.frame.getHeight();
    }

    //============================ Getters =====================================
    public JFrame getFrame() {
        return frame;
    }

    //============================ Setters =====================================

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }
}
