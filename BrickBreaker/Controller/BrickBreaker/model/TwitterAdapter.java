package BrickBreaker.model;

/**
 * This class is the adapter/translator class that gathers the score form the
 * game and passes the score to the twitter connector through the interface.
 *
 * @author Tyler Roux, Last updated 4/19/2020
 */
public class TwitterAdapter implements TwitterInterface {

    protected static final TwitterInterface thisApi = new TwitterConnector();
    protected static final ScoreInterface scores = new ScoreDataStore();

    @Override
    public void postTweet(int _score) {
        thisApi.postTweet(_score);
        	/*try {
		FileWriter fw = new FileWriter("src/resources/Score/score.txt", true);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            if(_score > 0){
                bw.write("The score was:" + " " + _score);
                bw.newLine();
            }
        }
            System.out.println("new player added");
       }catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    //======================= Getters ==========================================
    public static TwitterInterface getThisApi() {
        return thisApi;
    }

    //======================= Setters ==========================================
}
