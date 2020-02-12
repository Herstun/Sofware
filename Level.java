
package TylerRoux;

/**
 *
 * @author Rouxk
 */
import TylerGame.StandardHandler;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Level {

	private Scanner file = null;
	public int brickCount = 0;
	
	public Level(String level, StandardHandler sh){	
		int x = 0; 
		int y = 0;
		
               
                try{
                    
			this.file = new Scanner(new File(level));
		while(this.file.hasNext()){
	
                
		for(int i = 0; i < 8; i++){
			
			x = 0;
			y += 55;
			
			String line = this.file.nextLine();
			
			for(int j = 0; j < 8; j++){
				
				x += 80;
				
				if(Integer.parseInt(line.substring(j, j+1)) != 0){
					sh.addEntity(new Brick(x, y, Integer.parseInt(line.substring(j, j+1))));
					this.brickCount++;
				}
                        }
                }	
			
                }
		}catch(IOException e){
			e.printStackTrace();
                }
                 if(file == null){
			System.err.println((level));
			System.err.println("FILE IS NULL");
			System.exit(0);
		}

	}

    void reload() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        }

