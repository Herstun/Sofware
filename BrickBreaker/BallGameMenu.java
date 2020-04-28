import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The font being used in the application
 * // shows the list of items vertically down (both Start Game and Exit)
 * // current item shows highlighted selection of Vbox
 * size of window
 */

public class BallGameMenu extends Application {
    private static final Font FONT = Font.font("arial", FontWeight.THIN, 18);
    private VBox menuBox;
    private int currentItem = 0;
    /** new rectangle is shown as a new background to show off white text of both exit and Start game
     * //Placements of location for "tittle box"
     *  //creates Exit for the menu page
     * // placement of  options
     */
    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(800, 600);
        Rectangle bg = new Rectangle(3000, 600);
        ContentFrame frame = new ContentFrame(Content());
        HBox hbox = new HBox(frame);
        hbox.setTranslateX(300);
        hbox.setTranslateY(50);
        MenuItem itemExit = new MenuItem("EXIT");
        itemExit.setOnActivate(() -> System.exit(0));
        menuBox = new VBox(10, new MenuItem("Start Game"), (itemExit));
        menuBox.setAlignment(Pos.TOP_CENTER);
        menuBox.setTranslateX(370);
        menuBox.setTranslateY(300);
        getMenuItem(0).setActive(true);
        root.getChildren().addAll(bg, hbox, menuBox);
        return root;
    }
    /**
     *Set title of the game in the center using X and y coordinance
     * @return
     */
    private Node Content() {
        String title = "Brick Breaker";
        HBox letters = new HBox(0);
        letters.setAlignment(Pos.CENTER);
        for (int i = 0; i < title.length(); i++) {
            Text letter = new Text(title.charAt(i) + " ");
            letter.setFont(FONT);
            //set color of text in title to any color
            letter.setFill(Color.YELLOWGREEN);
            letters.getChildren().add(letter);
        }
        return letters;
    }
    private MenuItem getMenuItem(int index) {
        return (MenuItem) menuBox.getChildren().get(index);
    }
    private static class ContentFrame extends StackPane {
        public ContentFrame(Node content) {
            setAlignment(Pos.CENTER);
            Rectangle frame = new Rectangle(200, 200);
            frame.setStroke(Color.WHITE);
            getChildren().addAll(frame, content);
        }
    }

    private static class MenuItem extends HBox {
        private static int gameSizeWidth = 800;
        private static int gameSizeHeight = 800;
        private Text text;
        private Runnable script;
        private MenuItem(String name) {
            setAlignment(Pos.CENTER);
            text = new Text(name);
            text.setFont(FONT);
            getChildren().addAll(text);
            setActive(false);
            setOnActivate(() -> new Game(gameSizeWidth, gameSizeHeight));   
        }
        public void setActive(boolean b) {
            text.setFill(b ? Color.GREEN : Color.GREY);
        }
        public void setOnActivate(Runnable r) {
            script = r;
        }
        public void activate() {
            if (script != null)
                script.run();
        }
    }

 
    /**
     * // For all key press set up (going up and down also enter)
     *  // set to 0 to set for "limiting" so person cant go up again
     * @param primaryStage
     * @throws Exception
     */
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
       
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                if (currentItem > 0) {
                    getMenuItem(currentItem).setActive(false);
                    getMenuItem(--currentItem).setActive(true);
                }
            }
            if (event.getCode() == KeyCode.DOWN) {
                if (currentItem < menuBox.getChildren().size() - 1) {
                    getMenuItem(currentItem).setActive(false);
                    getMenuItem(++currentItem).setActive(true);
                }
            }
            if (event.getCode() == KeyCode.ENTER) {
                getMenuItem(currentItem).activate();
            }
        });
        primaryStage.setScene(scene);
   primaryStage.setOnCloseRequest(event -> {
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/**
 * TODO
* implement music and animation background for menu 
 * 
 * 
 */
