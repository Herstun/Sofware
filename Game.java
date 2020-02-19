package TylerRoux;

import TylerGame.StandardHandler;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{
//2/17 The class opens the window and create a score tracker, opens a new window and creates the object rendering the game.
	private Thread thread;
	private boolean running = false;
	public static Window window;
	private StandardHandler sh;
	private Paddle paddle;
	public static int score = 0;
	private Font font;
     
public Game(int width, int height){
	Game.window = new Window(width, height, "Bricks Be Gone", this);
	this.sh = new StandardHandler();
	this.paddle = new Paddle(300, 700, this.sh);
	new Ball(380, 180, this.sh);
	new Level("Resources/Levels/level1.txt", this.sh);
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
			TimeUnit.MILLISECONDS.sleep(20);
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
public static void main(String[] args) {
	new Game(800, 800);
}
}
