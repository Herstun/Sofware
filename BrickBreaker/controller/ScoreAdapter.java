package BrickBreaker.controller;

/**
 *
 * @author Rouxk
 */
public class ScoreAdapter implements ScoreInterface{
     protected static final ScoreInterface scores = new Score();

    @Override
    public void writeScore(int _score) {
        scores.writeScore(_score);
    }
}
    
//}
