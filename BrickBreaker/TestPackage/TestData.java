package BrickBreaker.TestPackage;

/**
 * The calculation part where we see if they match or not and prints the
 * statement.
 *
 * @author Jerid, Last updated: 4/30/2020
 */
import BrickBreaker.view.Brick;

public final class TestData {

    private int blocks;
    private int score;
    private int expected = 0;
    protected int bonusPointsMulti = 0;
    private int bonusPoints = 250;
    private final String pass = "PASS";
    private final String fail = "FAIL";

    /**
     * This part will be setting up the data from the runTest so it can be
     * separated to each individual use.
     *
     * @param _blocks Tells you haw many blocks there are.
     * @param _score This is the score from the game.
     */
    public TestData(int _blocks, int _score) {
        this.blocks = _blocks;
        this.score = _score;
        this.calcTestRun();
    }

    /**
     * This gets the data from the BirckBreakerTest class and prints the message
     * of every test.
     *
     * @param _blocks The number of blocks needed for the test to work.
     * @param _score The score will change from the test case.
     */
    public static void runTest(int _blocks, int _score) {
        TestData aTest = new TestData(_blocks, _score);
        System.out.println(aTest.toString());
    }

    /**
     * This creates the expected value used in the toString.
     */
    public void calcTestRun() {
        this.expected += this.blocks * Brick.getPointsPerBlock();
        this.bonusPointsMulti = (this.blocks / 10);
        this.expected += (this.bonusPoints * this.bonusPointsMulti);
    }

    /**
     * Finds if the test was pass or fail and than prints that message.
     *
     * @return Returns if it passes or not.
     */
    private String getResult() {
        if (this.expected == this.score) {
            return pass;
        }
        return fail;
    }

    /**
     * The toString method formats the results of the test into a single string.
     *
     * @return String
     */
    @Override
    public String toString() {
        return this.getResult() + " the value of " + this.blocks + " result in a score of " + this.score + " Expected: " + this.expected;
    }
    //=====================================================GETTERS==================================================

    public int getBlocks() {
        return blocks;
    }

    public int getScore() {
        return score;
    }

    public int getExpected() {
        return expected;
    }

    public int getBonusPointsMulti() {
        return bonusPointsMulti;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public String getPass() {
        return pass;
    }

    public String getFail() {
        return fail;
    }
    //=======================================================SETTERS===================================================

    public void setAttack(int blocks) {
        this.blocks = blocks;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setExpected(int expected) {
        this.expected = expected;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public void setBonusPointsMulti(int bonusPointsMulti) {
        this.bonusPointsMulti = bonusPointsMulti;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }
}
