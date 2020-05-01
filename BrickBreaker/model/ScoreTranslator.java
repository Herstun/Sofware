package BrickBreaker.model;

/**
 * This is the translator class that gather the score and translates it to the
 * ScoreDataStoreWriter class.
 *
 * @author Tyler Roux, Last updated 4/25/2020
 */
public class ScoreTranslator implements ScoreInterface {

    protected static final ScoreInterface scores = new ScoreDataStoreWriter();

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
