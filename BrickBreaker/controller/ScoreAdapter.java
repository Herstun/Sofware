package BrickBreaker.controller;

/**
 * Wrap between the Score Interface to the main game able to post a permanent record of the score.
 * @author Tyler 4/20/2020
 */

public class ScoreAdapter implements ScoreInterface{
     protected static final ScoreInterface scores = new Score();
     //sends the score to the score class to be written into a text file.
    @Override
    public void writeScore(int _score) {
        scores.writeScore(_score);
    }
    //============GETTERS=======================================================
    public static ScoreInterface getScores() {
        return scores;
    }
}
