package BrickBreaker.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Rouxk
 */
public class Writer {
    
	public void writeTo(String _text) throws IOException {
		try {
			FileWriter fw = new FileWriter("src/resources/GameScores.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			//String text = "new string for the file";
			bw.write(_text + ":" + " " + _score);
                        bw.newLine();
			bw.close();

            System.out.println("Scores added");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

