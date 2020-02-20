package TylerRoux;

import java.awt.Canvas;
import javax.swing.JFrame;

public class Window extends Canvas{
    //2/20 Class creates a window that will get width and height, than builds the window after checking some parameters.
    private JFrame frame;

    protected static int defaultOperationVariable = 3;

    public Window(int _width, int _height, String _title, Game _game){
        //Creates the window from imputted width, height, title, and inputs the game into the window.
	this.frame = new JFrame(_title);
	this.frame.setSize(_width, _height);
	this.frame.setDefaultCloseOperation(defaultOperationVariable);
	this.frame.setResizable(false);
	this.frame.setLocationRelativeTo(null);
	this.frame.add(_game);
	this.frame.setVisible(true);
    }

//======================GETTERS==========================
    public int width(){
		return this.frame.getWidth();
    }

    public int height(){
		return this.frame.getHeight();
    }
}
