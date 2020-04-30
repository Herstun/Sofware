package BrickBreaker.controller;

/**
 * This class is the interface between the score adapter and the score data
 * store. It gathers the score from the game controller and is implemented into
 * the adapter and translated.
 *
 * @author Tyler Roux, Last updated 4/30/2020
 */
public interface ScoreInterface {

    public void writeScore(int _score);

}
