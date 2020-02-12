/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TylerGame;

/**
 *
 * @author Rouxk
 */
import TylerGame.StandardGameObject;
import TylerRoux.Game;
import TylerRoux.Level;
//import java.io.File;
//import TylerRoux.level;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tjroux
 */
public class StandardHandler{

	private ArrayList<StandardGameObject> entities;
   // private StandardHandler sh;
    private Level Level;

	public StandardHandler(){
		this.entities = new ArrayList<StandardGameObject>();
	}

	public void tick(){
		
		if(this.countBricksAndDetermineWin()){
                    for(int i = 0; i > Level; i++){
                    
                    Level = new Level("Resources/Levels/level2.txt" ,this);
                    //for(int i = 0; i > 1; i++){
                    //System.out.println("Congrats You Win");
                   //System.exit(0);
                    }
                JOptionPane.showMessageDialog(null, "Congrats, you won!");
               // System.exit(0);
        }
                if(this.countBricksAndDetermineWin()){
                    JOptionPane.showMessageDialog(null, "Congrats, you won!");
                        System.exit(0);
                }
                //System.exit(1);
                        //this.file(level)++;
                //}else{
                    //this.File(Level2);
                //else{
                    //(this.countBricksAndDetermineWin());
                  //  JOptionPane.showMessageDialog(null, "Congrats, you won!");
			//System.exit(0);
                        //return "You won";
               // }
		for(int i = 0; i < entities.size(); i++){

			//Grabs the player
			if(this.entities.get(i).id == StandardID.Player){

				for(int j = 0; j < entities.size(); j++){

					if(entities.get(j).id == StandardID.Ball){

						//Collision between player & ball
						if(entities.get(i).getBounds().intersects(entities.get(j).getBounds())){
							entities.get(j).velY = -entities.get(j).velY;
						}

					}

				}

			}

			//Grabs the ball
			if(entities.get(i).id == StandardID.Ball){

				for(int j = 0; j < entities.size(); j++){

					if(entities.get(j).id == StandardID.Brick){

						if(entities.get(i).getBounds().intersects(entities.get(j).getBounds())){

							Game.score += 100;
							
							entities.remove(j);
							j--;
							
							entities.get(i).velY = -entities.get(i).velY;

						}
					}

				}
			}

			this.entities.get(i).tick();

		}
	}

	public void render(Graphics2D g2){
		for(int i = 0; i < entities.size(); i++){
			entities.get(i).render(g2);
		}
	}

	public void addEntity(StandardGameObject obj){
		this.entities.add(obj);
	}

	public void removeEntity(StandardGameObject obj){
		for(int i = 0; i < entities.size(); i++){
			if(obj == entities.get(i)){
				entities.remove(i);
				i--;
			}
		}
	}

	public void remove(StandardGameObject obj){
		this.entities.remove(obj);
	}
	
	public boolean countBricksAndDetermineWin(){
		
		int brick = 0;
		
		for(int i = 0; i < entities.size(); i++){
			if(entities.get(i).id == StandardID.Brick){
				brick++;
			}
		}
		
		return brick == 0;
	}
}

