/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BrickBreaker.ApiTest;

import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Rouxk
 */
public class TwitterConnector implements TwitterInterface {

    private final String consumerKey = "mWJlAt8ZFaJ9BCAvQhZhoWYWA";
    private final String consumerSecret = "NiH1HVNLe4ZWYRxBOyGj4uxy3gzAnCroh00Sfg6VlcslNRBDiX";
    private final String accessToken = "1247978652937129987-txU3ImvqXjExiVHkVdAulKWCMTPbwv";
    private final String accessTokenSecret = "3leJtOQLMbDeoX4qhssxyuAmeq72eLtLf2SXpjOHZNeI1";
    private final ConfigurationBuilder cb = new ConfigurationBuilder();
    //These are the keys that are used to access the twitter api.
    //This also configures the ccess credentials.

    /**
     *
     * @param _score
     * @return
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
        // twitter.getScreenName();
        // System.out.println(twitter.getHomeTimeline());
        // twitter.getAccountSettings();//return null;
        //return null;
        // return 0;
        //  System.out.println(twitter.getAccountSettings());
        try {
            twitter.updateStatus("Your score was : " + _score);
        } catch (TwitterException _ex) {
            Logger.getLogger(TwitterConnector.class.getName()).log(Level.SEVERE, null, _ex);
        }
        // twitter.updateStatus( _user + " score is " + _score + "congrats you won!");
        // return null;

    }
    //return null;
    //@Override

    public String postUserTweet(int _score) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
