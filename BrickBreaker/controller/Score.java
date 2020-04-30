package BrickBreaker.controller;

/**
 * This gets the score from the translator and than prints the score onto the text file.
 * @author Tyler 4/22/2020
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Score implements ScoreInterface{
    private final String sourceOfScoreTextFile = "src/resources/Score/score.txt";
    private final String messagePerScorePrint = "The score was:" //+_+ _score

    //This will be the portion where it will be get the score, find the text file, and than print a message into the text file.
    @Override
    public void writeScore(int _score) {
        try {
            //This is where the text file is called on.
            FileWriter fw = new FileWriter(sourceOfScoreTextFile, true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                //Prints the message that writes into the text file/\.
                if(_score > 0){
                    bw.write(messagePerScorePrint + " " + _score);
                    //Print a new line for next entry.
                    bw.newLine();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    //=====================GETTTERS=============================
    public String getSourceOfScoreTextFile() {
        return sourceOfScoreTextFile;
    }

    public String getMessagePerScorePrint() {
        return messagePerScorePrint;
    }
}
