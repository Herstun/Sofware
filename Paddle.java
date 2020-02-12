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
import TylerGame.StandardID;
import TylerGame.StandardHandler;
import TylerGame.StandardGameObject;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author tjroux
 */
public class Paddle extends StandardGameObject implements KeyListener{

	private StandardHandler sh;

	public Paddle(double x, double y,StandardHandler handler) {
		super(x, y, StandardID.Player);

		this.sh = handler;

		this.sh.addEntity(this);
		
		this.width = 100;
		this.height = 20;

	}

	public void tick(){

		if(this.x < 0){
			this.x = 0;
		}

		if(this.x > Game.window.width() - this.width){
			this.x = Game.window.width() - this.width;
		}

		if(this.y < 0){
			this.y = 0;
		}

		if(this.y > Game.window.height() - this.height){
			this.y = Game.window.height() - this.height;
		}

		this.x += velX;


	}

    /**
     *
     * @param g2
     */
    @Override
	public void render(Graphics2D g2){
		g2.setColor(Color.RED);
		g2.fillRect((int)this.x, (int)this.y, (int)this.width, (int)this.height);
	}


	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT: this.velX = -10; break;
		case KeyEvent.VK_RIGHT: this.velX = 10; break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT: this.velX = 0; break;
		case KeyEvent.VK_RIGHT: this.velX = 0; break;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
        }
}