package BrickBreaker.model;

/**
 * The font being used in the application // shows the list of items vertically
 * down (both Start Game and Exit) // current item shows highlighted selection
 * of Vbox size of window
 */
import BrickBreaker.*;
import BrickBreaker.controller.GameController;
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

public class BrickBreakerMenu extends Application {

    private static final Font FONT = Font.font("arial", FontWeight.THIN, 18);
    private VBox menuBox;
    private int currentItem = 0;
    private static int gameSizeWidth = 800;
    private static int gameSizeHeight = 800;
    String title = "Brick Breaker";
    private final int placingFrameTitleX = 3000;
    private final int placingFrameTitleY = 600;
    private final int sizeFrameWindowX = 800;
    private final int sizeFrameWindowY = 600;
    private final String exit = "EXIT";
    private final String gameStart = "Start Game";
    private final int positionOfHboxX = 300;
    private final int positionOfHboxY = 50;
    private static final int contentFrameX = 200;
    private static final int contentFrameY = 200;
    private final int menuBoxPositionX = 370;
    private final int menuBoxPositionY = 300;
    private final boolean activateMenu = true;
    private final Color colorForTitle = Color.YELLOWGREEN;
    private final Pos positionOfTitle = Pos.CENTER;
    private final Pos menuBoxAlignment = Pos.TOP_CENTER;
    private static final Pos contentFrameAlignment = Pos.CENTER;
    private static final Color contentFrameColor = Color.WHITE;
    private static final Pos menuItemPosition = Pos.CENTER;
    private static boolean isActiveOrNot = false;
    private static Color highlightedOption = Color.GREEN;
    private static Color notHighlightedOption = Color.GREY;
    private boolean movedAwayFrom = false;
    private boolean movedOnto = true;
    private final int space = 10;

    /**
     * new rectangle is shown as a new background to show off white text of both
     * exit and Start game //Placements of location for "tittle box" //creates
     * Exit for the menu page // placement of options
     */
    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(sizeFrameWindowX, sizeFrameWindowY);
        Rectangle bg = new Rectangle(placingFrameTitleX, placingFrameTitleY);
        ContentFrame frame = new ContentFrame(Content());
        HBox hbox = new HBox(frame);
        hbox.setTranslateX(positionOfHboxX);
        hbox.setTranslateY(positionOfHboxY);
        MenuItem itemExit = new MenuItem(exit);
        itemExit.setOnActivate(() -> System.exit(0));
        menuBox = new VBox(space, new MenuItem(gameStart), (itemExit));
        menuBox.setAlignment(menuBoxAlignment);
        menuBox.setTranslateX(menuBoxPositionX);
        menuBox.setTranslateY(menuBoxPositionY);
        getMenuItem(0).setActive(activateMenu);
        root.getChildren().addAll(bg, hbox, menuBox);
        return root;
    }

    /**
     * Set title of the game in the center using X and y coordinates.
     *
     * @return
     */
    private Node Content() {
        HBox letters = new HBox(0);
        letters.setAlignment(positionOfTitle);
        for (int i = 0; i < title.length(); i++) {
            Text letter = new Text(title.charAt(i) + " ");
            letter.setFont(FONT);
            //set color of text in title to any color
            letter.setFill(colorForTitle);
            letters.getChildren().add(letter);
        }
        return letters;
    }

    private MenuItem getMenuItem(int _index) {
        return (MenuItem) menuBox.getChildren().get(_index);
    }

    private static class ContentFrame extends StackPane {

        public ContentFrame(Node content) {
            setAlignment(contentFrameAlignment);
            Rectangle frame = new Rectangle(contentFrameX, contentFrameY);
            frame.setStroke(contentFrameColor);
            getChildren().addAll(frame, content);
        }
    }

    private static class MenuItem extends HBox {

        private final Text text;
        private Runnable script;

        private MenuItem(String name) {
            setAlignment(menuItemPosition);
            text = new Text(name);
            text.setFont(FONT);
            getChildren().addAll(text);
            setActive(isActiveOrNot);
            setOnActivate(() -> new GameController(gameSizeWidth, gameSizeHeight));
        }

        public void setActive(boolean _boolean) {
            text.setFill(_boolean ? highlightedOption : notHighlightedOption);
        }

        public void setOnActivate(Runnable _run) {
            script = _run;
        }

        public void activate() {
            if (script != null) {
                script.run();
            }
        }
    }

    /**
     * // For all key press set up (going up and down also enter) // set to 0
     * to set for "limiting" so person cant go up again.
     *
     * @param _primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage _primaryStage) throws Exception {
        Scene scene = new Scene(createContent());

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                if (currentItem > 0) {
                    getMenuItem(currentItem).setActive(movedAwayFrom);
                    getMenuItem(--currentItem).setActive(movedOnto);
                }
            }
            if (event.getCode() == KeyCode.DOWN) {
                if (currentItem < menuBox.getChildren().size() - 1) {
                    getMenuItem(currentItem).setActive(movedAwayFrom);
                    getMenuItem(++currentItem).setActive(movedOnto);
                }
            }
            if (event.getCode() == KeyCode.ENTER) {
                getMenuItem(currentItem).activate();
            }
        });
        _primaryStage.setScene(scene);
        _primaryStage.setOnCloseRequest(event -> {
        });
        _primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //================================== Getters ===============================
    public static Font getFONT() {
        return FONT;
    }

    public VBox getMenuBox() {
        return menuBox;
    }

    public int getCurrentItem() {
        return currentItem;
    }

    public static int getGameSizeWidth() {
        return gameSizeWidth;
    }

    public static int getGameSizeHeight() {
        return gameSizeHeight;
    }

    public String getTitle() {
        return title;
    }

    public int getPlacingFrameTitleX() {
        return placingFrameTitleX;
    }

    public int getPlacingFrameTitleY() {
        return placingFrameTitleY;
    }

    public int getSizeFrameWindowX() {
        return sizeFrameWindowX;
    }

    public int getSizeFrameWindowY() {
        return sizeFrameWindowY;
    }

    public String getExit() {
        return exit;
    }

    public String getGameStart() {
        return gameStart;
    }

    public int getPositionOfHboxX() {
        return positionOfHboxX;
    }

    public int getPositionOfHboxY() {
        return positionOfHboxY;
    }

    public static int getContentFrameX() {
        return contentFrameX;
    }

    public static int getContentFrameY() {
        return contentFrameY;
    }

    public int getMenuBoxPositionX() {
        return menuBoxPositionX;
    }

    public int getMenuBoxPositionY() {
        return menuBoxPositionY;
    }

    public boolean isActivateMenu() {
        return activateMenu;
    }

    public Color getColorForTitle() {
        return colorForTitle;
    }

    public Pos getPositionOfTitle() {
        return positionOfTitle;
    }

    public Pos getMenuBoxAlignment() {
        return menuBoxAlignment;
    }

    public static Pos getContentFrameAlignment() {
        return contentFrameAlignment;
    }

    public static Color getContentFrameColor() {
        return contentFrameColor;
    }

    public static Pos getMenuItemPosition() {
        return menuItemPosition;
    }

    public static boolean isIsActiveOrNot() {
        return isActiveOrNot;
    }

    public static Color getHighlightedOption() {
        return highlightedOption;
    }

    public static Color getNotHighlightedOption() {
        return notHighlightedOption;
    }

    public boolean isMovedAwayFrom() {
        return movedAwayFrom;
    }

    public boolean isMovedOnto() {
        return movedOnto;
    }

    //========================= Setters ========================================
    public void setMenuBox(VBox menuBox) {
        this.menuBox = menuBox;
    }

    public void setCurrentItem(int currentItem) {
        this.currentItem = currentItem;
    }

    public static void setGameSizeWidth(int gameSizeWidth) {
        BrickBreakerMenu.gameSizeWidth = gameSizeWidth;
    }

    public static void setGameSizeHeight(int gameSizeHeight) {
        BrickBreakerMenu.gameSizeHeight = gameSizeHeight;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static void setIsActiveOrNot(boolean isActiveOrNot) {
        BrickBreakerMenu.isActiveOrNot = isActiveOrNot;
    }

    public static void setHighlightedOption(Color highlightedOption) {
        BrickBreakerMenu.highlightedOption = highlightedOption;
    }

    public static void setNotHighlightedOption(Color notHighlightedOption) {
        BrickBreakerMenu.notHighlightedOption = notHighlightedOption;
    }

    public void setMovedAwayFrom(boolean movedAwayFrom) {
        this.movedAwayFrom = movedAwayFrom;
    }

    public void setMovedOnto(boolean movedOnto) {
        this.movedOnto = movedOnto;
    }

}
