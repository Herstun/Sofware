package BrickBreaker.ApiTest;

/**
 * This class is the adapter/translator class that gathers the score form the
 * game and passes the score to the twitter connector through the interface.
 *
 * @author Tyler Roux, Last updated 4/05/2020
 */
public class TwitterAdapter implements TwitterInterface {

    protected static final TwitterInterface thisApi = new TwitterConnector();

    @Override
    public void postTweet(int _score) {
        thisApi.postTweet(_score);
    }
}