package Menu;

import javafx.application.Application;
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
// import geometry positioning will help with the positioning of where menu items are placecd in the Menu

public class BallGameMenu extends Application {
    private static final Font FONT = Font.font("", FontWeight.THIN, 18);
   // shows the list of items vertically down (both Start Game and Exit)
    private VBox menuBox;
// current item shows highlighted selection of Vbox
    private int currentItem = 0;
    private Parent createContent() {
        Pane root = new Pane();
        //size of window
        root.setPrefSize(900, 600);
// new rectangle is shown as a new background to show off white text of both exit and Start game
        //default color is black
        Rectangle bg = new Rectangle(3000, 600);
        ContentFrame frame = new ContentFrame(createMiddleContent());
        HBox hbox = new HBox(frame);
        //Placements of location for hbox
        hbox.setTranslateX(330);
        hbox.setTranslateY(50);
        //creates Exit for the menu page
        MenuItem itemExit = new MenuItem("EXIT");
        itemExit.setOnActivate(() -> System.exit(0));
        menuBox = new VBox(10, new MenuItem("Start Game"),(itemExit));
        menuBox.setAlignment(Pos.TOP_CENTER);
        menuBox.setTranslateX(360);
        menuBox.setTranslateY(300);
        getMenuItem(0).setActive(true);
        root.getChildren().addAll(bg, hbox, menuBox);
        return root;
    }


    private Node createMiddleContent() {
        String title = " Brick Breaker";
        HBox letters = new HBox(0);
        letters.setAlignment(Pos.CENTER);
        for (int i = 0; i < title.length(); i++) {
            Text letter = new Text(title.charAt(i) + "");
            letter.setFont(FONT);
            //set color of text in title to any color
            letter.setFill(Color.WHITE);
            letters.getChildren().add(letter);
        }
        return letters;
    }


    private MenuItem getMenuItem(int index) {
        return (MenuItem)menuBox.getChildren().get(index);
    }
    private static class ContentFrame extends StackPane {
        public ContentFrame(Node content) {
            setAlignment(Pos.CENTER);

            Rectangle frame = new Rectangle(200, 200);
            frame.setArcWidth(25);
            frame.setArcHeight(25);
            frame.setStroke(Color.WHITE);

            getChildren().addAll(frame, content);
        }
    }

    private static class MenuItem extends HBox {
        private TriCircle c1 = new TriCircle(), c2 = new TriCircle();
        private Text text;
        private Runnable script;
        public MenuItem(String name) {
            setAlignment(Pos.CENTER);
            text = new Text(name);
            text.setFont(FONT);
            getChildren().addAll(c1, text, c2);
            setActive(false);
            setOnActivate(() -> System.out.println(name + " activated"));
        }

        public void setActive(boolean b) {
            c1.setVisible(b);
            text.setFill(b ? Color.WHITE : Color.GREY);
        }

        public void setOnActivate(Runnable r) {
            script = r;
        }

        public void activate() {
            if (script != null)
                script.run();
        }
    }

    private static class TriCircle extends Parent {
        public TriCircle() {
            Shape shape1 = Shape.subtract(new Circle(5), new Circle(2));
            shape1.setFill(Color.WHITE);
            getChildren().addAll(shape1);
            setEffect(new GaussianBlur(2));
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        //This is for all key press set up (going up and down also enter)
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                // set to 0 to set for "limiting" so person cant go up again
                if (currentItem > 0)
                {
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