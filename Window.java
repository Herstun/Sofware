
package TylerRoux;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Window extends Canvas{
	private JFrame frame;
	
	public Window(int width, int height, String title, Game game){
		
		this.frame = new JFrame(title);
		this.frame.setSize(width, height);
		this.frame.setDefaultCloseOperation(3);
		this.frame.setResizable(false);
		this.frame.setLocationRelativeTo(null);
		this.frame.add(game);
		this.frame.setVisible(true);
	}
	
	public int width(){
		return this.frame.getWidth();
	}

	public int height(){
		return this.frame.getHeight();
	}
}
