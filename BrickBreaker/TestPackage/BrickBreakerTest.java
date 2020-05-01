package BrickBreaker.TestPackage;

/**
 * Gets all the variables and has an array of values we can use to test various
 * amounts.
 *
 * @author Jerid, Last updated: 4/30/2020
 */
import BrickBreaker.view.Brick;

public class BrickBreakerTest {

    private static final int testNumbers[] = new int[]{-10, 22, 33, 49, 55, 60, 70, 80, 95, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190,};
    private static int testResult;
    private static int amountOfBonus;

    /**
     * Creates an array for testing of various numbers.
     */
    public static void testArrayOfOptions() {
        for (int i = 0; i < testNumbers.length; i++) {
            TestData.runTest(testNumbers[i], fromBricks(testNumbers[i]));
        }
    }

    /**
     * Part will be to calculate what Brick would calculate for us. The purpose
     * is to add them up and get the result.
     *
     * @param i Counter for blocks tested.
     * @return Returns the score.
     */
    public static int fromBricks(int i) {
        testResult = i * Brick.getPointsPerBlock();
        amountOfBonus += Brick.ifComboBrickBroken(i);
        testResult += amountOfBonus;
        return testResult;
    }

    public static void main(String[] args) {
        testArrayOfOptions();
    }
    //======================================GETTERS===================================================

    public static int[] getIntArray() {
        return testNumbers;
    }

    public static int[] getTestNumbers() {
        return testNumbers;
    }

    public static int getAmountOfBonus() {
        return amountOfBonus;
    }

    public static int getTestResult() {
        return testResult;
    }
    //=========================================SETTERS==================================================

    public static void setTestResult(int testResult) {
        BrickBreakerTest.testResult = testResult;
    }

    public static void setAmountOfBonus(int amountOfBonus) {
        BrickBreakerTest.amountOfBonus = amountOfBonus;
    }
}
