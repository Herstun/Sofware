package BrickBreaker;

/**
 * This is the main class of the game and controls the starting and stopping of
 * the game.
 *
 * @author Tyler Roux, Last updated 3/20/2020
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.concurrent.TimeUnit;
import BrickBreaker.view.*;
import BrickBreaker.model.Paddle;
import BrickBreaker.controller.TwitterAdapter;
//import model.TwitterAdapter;

/**
 * This is the enumeration of the properties of game and makes it runnable.
 */
public class Game extends Canvas implements Runnable {

    protected Thread thread;
    protected boolean running = false;
    public static Window window;
    protected StandardHandler sh;
    protected Paddle paddle;
    public static int score = 0;
    protected Font font;
    private final int paddlePlacementWidth = 300;
    private final int paddlePlacementHeight = 700;
    private final int ballPlacementWidth = 350;
    private final int ballPlacementHeight = 650;
    private final String fontType = "Arial";
    private final int fontSize = 30;
    private final int sleep = 15;
    private final int exit = 0;
    private final int scoreSizeWidthPlacement = 50;
    private final int scoreSizeHeightPlacement = 50;
    private final int backgroundWidth = 0;
    private final int backgroundHeight = 0;
    private final int inFrontOfBackgroundPlacement = 3;
    protected Boost boost;
    protected static final int boostPlacementWidth = 500;
    protected static final int boostPlacementHeight = 500;
    protected BallGameMenu menu;
    protected final String scoreMessage2 = "Score: ";
    protected final String levelLocation = "src/Resources/Levels/Level1.txt";
    protected final String title = "Bricks Be Gone";
    public static TwitterAdapter twitter = new TwitterAdapter();

    /**
     * This method displays the games height and width.
     */
    public Game(int _width, int _height) {
        Game.window = new Window(_width, _height, title, this);
        //This pulls the information from the StandardHandler.
        this.sh = new StandardHandler();
        //This gathers the information from the paddle.
        this.paddle = new Paddle(paddlePlacementWidth, paddlePlacementHeight, this.sh);
        //This gathers the information from the ball.
        new Ball(ballPlacementWidth, ballPlacementHeight, this.sh);
        //This gathers the information from the level resource folder.
        new Level(levelLocation, this.sh);
        //new Level("src/Resources/Levels/level2.txt", this.sh);
        //This diplays the information in a font.
        this.font = new Font(fontType, Font.TRUETYPE_FONT, fontSize);
        //This adds the use of being able to use the keys.
        this.addKeyListener(paddle);
        //This starts the game.
        this.start();
        this.boost = new Boost(Game.boostPlacementWidth, Game.boostPlacementHeight, this.sh);
    }

    /**
     * This method allows the game to start and run from the game.
     */
    private synchronized void start() {
        if (running) {
        } else {
            this.running = true;
            this.thread = new Thread(this);
            this.thread.start();
        }
    }

    /**
     * This method allows the game to stop.
     */
    private synchronized void stop() {
        if (!running) {
            return;
        }
        try {
            this.thread.join();
        } catch (InterruptedException e) {
        }
        this.twitter.postTweet(score);

        this.running = false;
        System.exit(exit);
    }

    /**
     * This method allows the game to run and be in sync with the rest of the
     * game.
     */
    @Override
    public void run() {
        this.requestFocus();
        while (running) {
            try {
                TimeUnit.MILLISECONDS.sleep(sleep);
            } catch (InterruptedException e) {
            }
            tick();
            render();
        }
        this.stop();
    }

    /**
     * This is the method to have the components running together in sync.
     */
    public void tick() {
        this.sh.tick();
        sh.tick();
    }

    /**
     * This is the method that allows the game to be displayed to the window.
     */
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(inFrontOfBackgroundPlacement);
            return;
        }

        Graphics2D g2 = (Graphics2D) bs.getDrawGraphics();
        g2.setColor(Color.BLACK);
        g2.fillRect(backgroundWidth, backgroundHeight, Game.window.width(), Game.window.height());
        this.sh.render(g2);
        g2.setColor(Color.WHITE);
        g2.setFont(this.font);
        g2.drawString(scoreMessage2 + Game.score, scoreSizeWidthPlacement, scoreSizeHeightPlacement);
        g2.dispose();
        bs.show();
    }
    //=================================== Getters =============================================

    public int getScore() {
        return score;
    }

    //================================== Setters ==============================================
}
