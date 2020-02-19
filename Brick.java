package TylerRoux;

/**
 *
 * @author Rouxk
 */
import TylerGame.StandardID;
import TylerGame.StandardGameObject;
import java.awt.Color;
import java.awt.Graphics2D;

public class Brick extends StandardGameObject{

private Color color;
	
public Brick(double _x, double _y, int val){
	super(x, y, StandardID.Brick);
		
	this.width = 80;
	this.height = 20;
		
	switch(val){
	    case 0: return;
		case 1: this.color = Color.RED; break; //red
		case 2: this.color = Color.BLUE; break; //blue
		case 3: this.color = Color.GREEN;break;//green
		case 4: this.color = Color.ORANGE;break;//yellow
		}
	}
	
	public void tick(){	
	}
}
