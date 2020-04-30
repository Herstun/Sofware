package BrickBreaker.controller;

/**
 * This is the translator class that gather the score and translates it to the
 * ScoreDataStore class.
 *
 * @author Tyler Roux, Last updated 4/25/2020
 */
public class ScoreAdapter implements ScoreInterface {

    protected static final ScoreInterface scores = new ScoreDataStore();

    @Override
    public void writeScore(int _score) {
        scores.writeScore(_score);
    }

    //======================= Getters ==========================================
    public static ScoreInterface getScores() {
        return scores;
    }

    //======================= Setters ==========================================
}

//}
