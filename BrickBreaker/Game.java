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
import BrickBreaker.ApiTest.TwitterAdapter;

/**
 *This is the enumeration of the properties of game and makes it runnable.
 */
public class Game extends Canvas implements Runnable {

    protected Thread thread;
    protected boolean running = false;
    protected static Window window;
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
    private final int scoreSizeWidthPlacement =50;
    private final int scoreSizeHeightPlacement =50;
    private final int backgroundWidth = 0;
    private final int backgroundHeight = 0;
    private final int inFrontOfBackgroundPlacement = 3;
    private final static int gameSizeWidth = 800;
    private final static int gameSizeHeight = 800;
    boolean won;
    boolean lost;
    protected GUI gui;
    protected Boost boost;
    protected static final int boostPlacementWidth = 500;
    protected static final int boostPlacementHeight = 500;
    protected BallGameMenu menu;
    public static TwitterAdapter twitter =new TwitterAdapter();

    private final int MAX_LEVELS = 7;
	public Level[] levels = new Level[MAX_LEVELS];
	public int levelNum = 0;

    /**
     *This method displays the games height and width.
    */
    public Game(int width, int height) {
        Game.window = new Window(width, height, "Bricks Be Gone", this);
        //This pulls the information from the StandardHandler.
        this.sh = new StandardHandler();
        //This gathers the information from the paddle.
        this.paddle = new Paddle(paddlePlacementWidth, paddlePlacementHeight, this.sh);
        //This gathers the information from the ball.
        new Ball(ballPlacementWidth, ballPlacementHeight, this.sh);
        //This gathers the information from the level resource folder.
        new Level("src/Resources/Levels/Level1.txt", this.sh);
        //new Level("src/Resources/Levels/level2.txt", this.sh);
        //This diplays the information in a font.
        this.font = new Font(fontType, Font.TRUETYPE_FONT, fontSize);
        //This adds the use of being able to use the keys.
        this.addKeyListener(paddle);
        //This starts the game.
        this.start();
        this.boost = new Boost(Game.boostPlacementWidth, Game.boostPlacementHeight, this.sh);
        this.gui = new GUI(this,this.sh);
        this.initializeLevels();
    }


    /**
     *This method allows the game to start and run from the game.
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
     *This method allows the game to stop.
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
     *This method allows the game to run and  be in sync with the rest of the game.
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
     *This is the method to have the components running together in sync.
    */
    public void tick() {
        this.sh.tick();
        if(!lost && !won){
            sh.tick();
           // levels[levelNum].tick();
            gui.tick();
        }
    }

    /**
     *This is the method that allows the game to be displayed to the window.
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
        g2.drawString("Score: " + Game.score, scoreSizeWidthPlacement, scoreSizeHeightPlacement);
        g2.dispose();
        bs.show();
    }

    /**
     * This method will initialize the levels.
    */
    private void initializeLevels(){
		for(int i = 0; i<levels.length; i++){
			//Exception is handled in the Level constructor.
			levels[i] = new Level("Resources/Levels/level"+(i+1)+".txt", this, this.sh);
		}
	}

    /**
     * This method will reload the level if you were to die.
     */
    public void reloadAllLevels(){
		for(int i = 0; i<levels.length; i++){
			levels[i].reload();
		}
	}

    /**
     *This is the main method.
    */
    public static void main(String[] args) {
        new Game(gameSizeWidth, gameSizeHeight);
    }
    
    
    public int getScore(){
        return score;
    }
}





















/*
if(lost || won){
			if(firstPass){//allows for a temporary clock to let the screen fade to black.

				if(alpha < 255){
					alpha++;
				}else{
					firstPass = false;

					if(won){
						levelNum++;
						this.bg.setImage("space"+levelNum);
					}

					if(lost){
						GUI.lives--;
						if(GUI.lives == 0){
							this.levels[levelNum].clear();
							this.reloadAllLevels();
							this.bg.setImage("space0");
							this.gameState = State.GameOver;

						}
					}
					//songBox.clearSFX();
					this.levels[levelNum].reload();
					if(this.gameState != State.GameOver)
						this.handler.addEntity(new Ball(300,300,this,this.difficulty));
				}

			}else{
				if(alpha > 0){
					alpha--;
				}else{
					lost = false;
					started = false;
					firstPass = true;
					won = false;
				}

			}

			g2.setColor(new Color(0,0,0,alpha));
			g2.fillRect(0, 0, this.window.returnWidth(), this.window.returnHeight());
		}

		/************************DO NOT PLACE ANY MORE DRAWING INSTRUCTIONS WITHIN THIS SECTION OF THE RENDER METHOD**********************/

	//	g.dispose();
	//	g2.dispose();

	//	bs.show();
	//}
