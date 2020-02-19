package TylerRoux;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
import TylerGame.StandardGameObject;
import TylerGame.StandardID;
import TylerGame.StandardHandler;

public class Ball extends StandardGameObject{

public Ball(double _x, double _y, StandardHandler sh){
	super(x, y, StandardID.Ball);
	sh.addEntity(this);
	this.width = 15;
	this.height = 15;
	this.velX = 5;
	this.velY = -5;
}

@Override
public void tick() {
	if(this.x < 0 || this.x >= Game.window.width() - this.width){
		this.velX = -this.velX;
	}	
	if(this.y < 0){
		this.velY = -this.velY;
	}
   if(this.y >= Game.window.height()){	
		JOptionPane.showMessageDialog(null, "You lost! Your score was: "+Game.score);
		System.exit(0);
		}
	this.x += this.velX;
	this.y += this.velY;	
	}
}
