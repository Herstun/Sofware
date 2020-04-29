package BrickBreaker.view;

/**
 * This creates a canvas for the game to run on.
 * @author Marquis, Last updated: 2/10/2020
 */
import BrickBreaker.*;
import BrickBreaker.controller.GameController;
import java.awt.Canvas;
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

    public int width() {
        return this.frame.getWidth();
    }

    public int height() {
        return this.frame.getHeight();
    }
    
}

