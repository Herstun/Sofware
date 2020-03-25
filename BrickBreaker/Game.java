package BrickBreaker;

/**
 *This is the main class of the game and controls
 *the starting and stopping of the game.
 * @author Tyler Roux, Last updated 3/20/2020
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.concurrent.TimeUnit;

//This is the enumeration of the properties of game and makes it runnable.
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
    private final int scoreSizeWidthPlacement =50;
    private final int scoreSizeHeightPlacement =50;
    private final int backgroundWidth = 0;
    private final int backgroundHeight = 0;
    private final static int gameSizeWidth = 800;
    private final static int gameSizeHeight = 800;

    /*
    This method displays the games height and width.
    */
    public Game(int width, int height) {
        Game.window = new Window(width, height, "Bricks Be Gone", this);

        this.sh = new StandardHandler();

        this.paddle = new Paddle(paddlePlacementWidth, paddlePlacementHeight, this.sh);

        new Ball(ballPlacementWidth, ballPlacementHeight, this.sh);

        new Level("src/Resources/Levels/Level1.txt", this.sh);

        this.font = new Font(fontType, Font.TRUETYPE_FONT, fontSize);

        this.addKeyListener(paddle);

        this.start();
    }


    /*
    This method allows the game to start and run from the game.
    */
    private synchronized void start() {
        if (running) {
        } else {
            this.running = true;
            this.thread = new Thread(this);
            this.thread.start();
        }
    }

    /*
    This method allows the game to stop.
    */
    private synchronized void stop() {
        if (!running) {
            return;
        }
        try {
            this.thread.join();
        } catch (InterruptedException e) {
        }

        this.running = false;
        System.exit(0);
    }

    /**
     *This method allows the game to run and  be in sync with the rest of the game.
     */
    @Override
    public void run() {
        this.requestFocus();
        while (running) {
            try {
                TimeUnit.MILLISECONDS.sleep(15);
            } catch (InterruptedException e) {
            }
            tick();
            render();
        }
        this.stop();
    }

    //This is the method to have the components running together in sync.
    public void tick() {
        this.sh.tick();
    }

    //This is the method that allows the game to be displayed to the window.
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics2D g2 = (Graphics2D) bs.getDrawGraphics();
        g2.setColor(Color.BLACK);
        g2.fillRect(backgroundWidth, backgroundHeight, Game.window.width(), Game.window.height());
        this.sh.render(g2);
        g2.setColor(Color.WHITE);
        g2.setFont(this.font);
        g2.drawString("Score: " + Game.score, scoreSizeWidthPlacement, scoreSizeHeightPlacement);
        g2.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Game(gameSizeWidth, gameSizeHeight);
    }
}
