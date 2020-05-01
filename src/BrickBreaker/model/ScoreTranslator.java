/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BrickBreaker.model;

/**
 * This is the translator class that gather the score and translates it to the
 * ScoreDataStore class.
 *
 * @author Tyler Roux, Last updated 4/25/2020
 */
public class ScoreTranslator implements ScoreInterface {

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
