package TylerGame;
/**
 *
 * @author Rouxk
 */
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class StandardGameObject {
        protected double x;
	protected double y;
	protected double velX;
	protected double velY;
	protected int width;
	protected int height;
	protected StandardID id;
	
public StandardGameObject(double _x, double _y, StandardID id){
	this.x = x;
	this.y = y;
	this.id = id;
}
	
public abstract void tick();
public abstract void render(Graphics2D g2);
public Rectangle getBounds(){
	return new Rectangle((int) _x,(int) _y,(int) width, (int) height);
}
}
