package BrickBreaker;

/**
 * This creates a canvas for the game to run on.
 * @author Marquis, Last updated: 2/10/2020
 */
import java.awt.Canvas;
import javax.swing.JFrame;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
