/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TylerRoux;

/**
 *
 * @author Rouxk
 */
import TylerGame.StandardHandler;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

/**
 *
 * @author tjroux
 */
public class Game extends Canvas implements Runnable{

	//private static final long serialVersionUID = 5754222609488830452L;
	private Thread thread;
	private boolean running = false;
	
	public static Window window;
	
	private StandardHandler sh;
	
	private Paddle paddle;
	public static int score = 0;
	
	private Font font;
        
        private final int MAX_LEVELS = 7;
	public Level[] levels = new Level[MAX_LEVELS];
	public int levelNum = 0;
			 //0 <= n < MAX_LEVELS
	
	public Game(int width, int height){
		Game.window = new Window(width, height, "Bricks Be Gone", this);
		
		this.sh = new StandardHandler();
		
		this.paddle = new Paddle(300, 700, this.sh);
		
		new Ball(380, 180, this.sh);
		
		new Level("Resources/Levels/level1.txt", this.sh);
                
               // new Level("Resources/Levels/level2.txt", this.sh);
		
		this.font = new Font("Arial", Font.TRUETYPE_FONT, 30);
		
		this.addKeyListener(paddle);
		
		this.start();
	}
	
	private synchronized void start(){
		if(running) return;
		else{
			this.running = true;
			this.thread = new Thread(this);
			this.thread.start();
		}
	}
	
	private synchronized void stop(){
		if(!running) return;
		try{
			this.thread.join();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		this.running = false;
		System.exit(0);
	}

	public void run(){
		this.requestFocus();
		
		while(running){
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tick();
			render();
		}
		
		this.stop();
	}
	
	private void tick(){
		this.sh.tick();
		
		
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics2D g2 = (Graphics2D) bs.getDrawGraphics();
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, Game.window.width(), Game.window.height());
		
		this.sh.render(g2);
		
		g2.setColor(Color.WHITE);
		g2.setFont(this.font);
		g2.drawString("Score: "+Game.score, 20, 45);
		
		g2.dispose();
		bs.show();
	}
	
	
	
	public static void main(String[] args) {
		new Game(800, 800);
	}
}
    /*    
        public enum State {Menu,Game, GameOver};
	public State gameState = State.Menu;
	public int difficulty = 0;
	public boolean firstPass = true;
	public boolean lost = false;
	public boolean won = false;

        
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
/*
		g.dispose();
		g2.dispose();

		bs.show();
	}

        
        public StandardHandler handler;
       // this.handler = new StandardHandler();
        
        private void initLevels(){
		for(int i = 0; i<levels.length; i++){
			//Exception is handled in the Level constructor.
			levels[i] = new Level("Resources/Levels/level"+(i+1)+".txt", this.handler);
		}
	}

        
	/**
	 * This method will reload every level in the game, in the case of a game over situation.
	 */

//	public void reloadAllLevels(){
//		for(int i = 0; i<levels.length; i++){
//			levels[i].reload();
//		}
//	}

//}

