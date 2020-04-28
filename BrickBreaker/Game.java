package BrickBreaker;

/**
 *
 * @author Marquis, Last updated 2/15/2020
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.concurrent.TimeUnit;

public final class Game extends Canvas implements Runnable {

    protected Thread thread;
    protected boolean running = false;
    public static Window window;
    protected StandardHandler sh;
    protected Paddle paddle;
    protected Ball ball;
    protected Boost boost;
    protected Level level;
    public static int score = 0;
    protected Font font;
    private final int paddlePlacementWidth = 300;
    private final int paddlePlacementHeight = 700;
    private final int ballPlacementWidth = 200;
    private final int ballPlacementHeight = 400;
    private final String fontType = "Arial";
    private final int fontSize = 30;
    protected static final int gameSizeWidth = 800;
    protected static final int gameSizeHeight = 800;
    protected static int gameScoreIncrease = 100;
    protected static final int boostPlacementWidth = 500;
    protected static final int boostPlacementHeight = 500;
    protected static int currentLevel = 1;
    protected static boolean stopGameForLevelChange = false;

    public Game(int width, int height) {
        Game.window = new Window(width, height, "Bricks Be Gone", this);

        this.sh = new StandardHandler();

        this.paddle = new Paddle(paddlePlacementWidth, paddlePlacementHeight, this.sh);

        this.ball = new Ball(ballPlacementWidth, ballPlacementHeight, this.sh);

        startLevel();

        this.font = new Font(fontType, Font.TRUETYPE_FONT, fontSize);

        this.boost = new Boost(Game.boostPlacementWidth, Game.boostPlacementHeight, this.sh);

        this.addKeyListener(paddle);

        this.start();

       /* if(StandardHandler.atlevel != 1 && Game.stopGameForLevelChange = true){
            this.running = false;
        }
        if(StandardHandler.atlevel != 1 && Game.stopGameForLevelChange = false){
        } else {
            this.running = true;
        }
        */
    }

    private synchronized void start() {
        if (running) {
        } else {
            this.running = true;
            this.thread = new Thread(this);
            this.thread.start();
        }
    }

    protected  synchronized void stop() {
        if (!running) {
            return;
        }
        try {
            this.thread.join();
        } catch (InterruptedException e) {
        }

        this.running = false;
        //System.exit(0);
    }

    /**
     *
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

    public void tick() {
        this.sh.tick();

    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics2D g2 = (Graphics2D) bs.getDrawGraphics();

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, Game.window.width(), Game.window.height());
        this.sh.render(g2);

        g2.setColor(Color.BLACK);
        g2.setFont(this.font);
        g2.drawString("Score: " + Game.score, 20, 45);

        g2.dispose();
        bs.show();
    }
    public void startLevel(){
        this.level =new Level("src/Resources/Levels/Level2.txt", this.sh);
    }

    public static void main(String[] args) {
         new Game(gameSizeWidth, gameSizeHeight);
    }

    /**
     *
     */
    /*
    public static void levelPassStop(){
        Game.stopGameForLevelChange =true;
    }
    public static void startAgain(){
        Game.stopGameForLevelChange = false;
    }
*/
}
