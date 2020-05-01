package BrickBreaker.model;

/**
 * This class connects the game score to twitter and posts a tweet because this
 * calls the twitter Api.
 *
 * @author Tyler Roux, Last updated 4/05/2020
 */
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConnector implements TwitterInterface {

    //These are the keys that are used to access the twitter api.
    //This also configures the ccess credentials.
    private final String consumerKey = "mWJlAt8ZFaJ9BCAvQhZhoWYWA";
    private final String consumerSecret = "NiH1HVNLe4ZWYRxBOyGj4uxy3gzAnCroh00Sfg6VlcslNRBDiX";
    private final String accessToken = "1247978652937129987-txU3ImvqXjExiVHkVdAulKWCMTPbwv";
    private final String accessTokenSecret = "3leJtOQLMbDeoX4qhssxyuAmeq72eLtLf2SXpjOHZNeI1";
    private final ConfigurationBuilder cb = new ConfigurationBuilder();

    /**
     * This method gathers the keys to connect to twitter and posts a tweet and
     * displays them in the output.
     *
     * @param _score This is the score from the end of the game.
     */
    @Override
    public void postTweet(int _score) {
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(this.consumerKey)
                .setOAuthConsumerSecret(this.consumerSecret)
                .setOAuthAccessToken(this.accessToken)
                .setOAuthAccessTokenSecret(this.accessTokenSecret);

        //This configures the twitter api and allows for building.
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        //This posts a tweet to twitter with your score from the end of the game.
        try {
            twitter.updateStatus("Your score was : " + _score);
        } catch (TwitterException _ex) {
            Logger.getLogger(TwitterConnector.class.getName()).log(Level.SEVERE, null, _ex);
        }
        //This will gather the status from twitter.
        List<Status> status = null;
        try {
            //This will get the twitter home timeline.
            status = twitter.getHomeTimeline();
        } catch (TwitterException ex) {
            Logger.getLogger(TwitterConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Status st : status) {
            //This statement will print the posts from twitter.
            System.out.println(st.getText());
        }
    }

    //============================= Getters ====================================
    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }

    public ConfigurationBuilder getCb() {
        return cb;
    }

    //============================== Setters ===================================
}
