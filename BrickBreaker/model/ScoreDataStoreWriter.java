package BrickBreaker.model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class writes the scores into a text file.
 *
 * @author Tyler Roux, Last updated 4/26/2020
 */
public class ScoreDataStoreWriter implements ScoreInterface {

    @Override
    public void writeScore(int _score) {
        try {
            //This creates a file called score.txt.
            FileWriter fw = new FileWriter("src/resources/Score/ScoreDS.txt", true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                if (_score > 0) {
                    //This writes the score was: 'score' into the new text file.
                    bw.write("The score was:" + " " + _score + "  " + date());
                    bw.newLine();
                }
            }
            //If the file is bad it with throw an error.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
