package BrickBreaker;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Marquis, Last updated 2/15/2020
 */
public class Game extends Canvas implements Runnable {

    protected Thread thread;
    protected boolean running = false;
    public static Window window;
    protected StandardHandler sh;
    protected Paddle paddle;
    public static int score = 0;
    protected Font font;
//protected final int MAX_LEVELS = 7;
//public Level[] levels = new Level[MAX_LEVELS];
//public int levelNum = 0;
    //0 <= n < MAX_LEVELS

    public Game(int width, int height) {
        Game.window = new Window(width, height, "Bricks Be Gone", this);

        this.sh = new StandardHandler();

        this.paddle = new Paddle(300, 700, this.sh);

        new Ball(380, 180, this.sh);

        new Level("src/Resources/Levels/Level1.txt", this.sh);
        //new Level("Resources/Levels/level2.txt", this.sh);
       // new Level();

        this.font = new Font("Arial", Font.TRUETYPE_FONT, 30);

        this.addKeyListener(paddle);

        this.start();

        //this.level();
    }

    private synchronized void start() {
        if (running) {
        } else {
            this.running = true;
            this.thread = new Thread(this);
            this.thread.start();
        }
    }

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
     *
     */
    @Override
    public void run() {
        this.requestFocus();

        while (running) {
            try {
                TimeUnit.MILLISECONDS.sleep(15);
                //Thread.sleep(17);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block

            }
            tick();
            render();
        }

        this.stop();
    }

    public void tick() {
        this.sh.tick();
        //this.disable();
        // Level[] levels1 = this.levels;
        // if (sh.countBricksAndDetermineWin()){
        //new Level("Resources/Levels/level2.txt", this.sh);
        //  this.sh.countBricksAndDetermineWin();
        //}
        // sh.countBricksAndDetermineWin();
        //System.exit(0);
        //}
        //for(int i = 0; i > 2; i++){

        //  if (sh.countBricksAndDetermineWin() == true){
        // new Level("Resources/Levels/level2.txt", this.sh);
        ////this.brick
        // }
        //switch(tick){
        //   case 1: s
    }
    //if(sh.countBricksAndDetermineWin() == true){
    //  Level level = new Level("Resources/Levels/level2.txt", this.sh);
    // endGame();

    //  }
    // sh.countBricksAndDetermineWin();
    //}
    //public Level[] getLevels() {
    //new Level("Resources/Levels/level2.txt", this.sh);
    // return levels;
    // }
//sh.countBricksAndDetermineWin();
    //}
    //}
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics2D g2 = (Graphics2D) bs.getDrawGraphics();

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Game.window.width(), Game.window.height());

        this.sh.render(g2);

        g2.setColor(Color.WHITE);
        g2.setFont(this.font);
        g2.drawString("Score: " + Game.score, 20, 45);

        g2.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Game(800, 800);
    }

    //private boolean endGame() {
    //      boolean game = sh.countBricksAndDetermineWin() == false;
    //   return false;
//}

    /*private void level() {
            int level = 0;
        switch(level){
            case 1: level1();
            break;
            case 2: level2();
            break;
            default:
        }
      //  new Level("Resources/Levels/level1.txt", this.sh);
       // new Level("Resources/Levels/level2.txt", this.sh);
    }

    private void level1() {
         new Level("Resources/Levels/level1.txt", this.sh);
    }

    private void level2() {
        new Level("Resources/Levels/level2.txt", this.sh);
    }*/
}
