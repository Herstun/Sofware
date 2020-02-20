package TylerRoux;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
import TylerGame.StandardGameObject;
import TylerGame.StandardID;
import TylerGame.StandardHandler;

public class Ball extends StandardGameObject{
    protected static int ballWidth = 15;
    protected static int ballHeight = 15;
    protected static int ballVelX = 5;
    protected static int ballVelY = -5;

    public Ball(double _x, double _y, StandardHandler sh){
	super(_x, _y, StandardID.Ball);
	sh.addEntity(this);
	this.width = ballWidth;
	this.height = ballHeight;
	this.velX = ballVelX;
	this.velY = ballVelY;
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

    @Override
    public void render(Graphics2D g2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
