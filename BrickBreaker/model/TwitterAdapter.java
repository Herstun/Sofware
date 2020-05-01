package BrickBreaker.model;

/**
 * This class is the adapter/translator class that gathers the score form the
 * game and passes the score to the twitter connector through the interface.
 *
 * @author Tyler Roux, Last updated 4/19/2020
 */
public class TwitterAdapter implements TwitterInterface {

    protected static final TwitterInterface thisApi = new TwitterConnector();

    //Gathers score from game.
    @Override
    public void postTweet(int _score) {
        thisApi.postTweet(_score);
    }

    //======================= Getters ==========================================
    public static TwitterInterface getThisApi() {
        return thisApi;
    }

    //======================= Setters ==========================================
}
