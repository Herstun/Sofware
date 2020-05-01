/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

/**
 *
 * @author meije
 */
public final class TestData {
    private int attack;
    private int score;
    private int expected = 0;
    private int bonusPointsMulti = 0;
    private int bonusPoints=250;
    public TestData(int _attack, int _score) {
        this.attack = _attack;
        this.score = _score;
        this.calcTestRun();
    }

     public static void runTest(int _attack, int _score) {
        TestData aTest = new TestData(_attack, _score);
    }

    public void calcTestRun() {
        this.expected = this.attack*100;
        this.bonusPointsMulti = this.attack/10;
        this.expected += (this.bonusPoints*this.bonusPointsMulti);
    }
    private String getResult() {
        if (this.expected == this.score) {
            return "PASS";
        }
        return "FAIL";
    }

    /**
     * The toString method formats the results of the test into a single string.
     * @return String
     */
    @Override
    public String toString() {
        return this.getResult() + " the value of " + this.attack +" result in a score of " +this.score + " Expected: " + this.expected;
    }
}
