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
    private  int score;
    private int expected = 0;
    protected int bonusPointsMulti = 2;
    private int bonusPoints=250;
    public TestData(int _attack, int _score) {
        this.attack = _attack;
        this.score = _score;
        this.calcTestRun();
    }

     public static void runTest(int _attack, int _score) {
        TestData aTest = new TestData(_attack, _score);
        System.out.println(aTest.toString());
    }

    public void calcTestRun() {
        this.expected += this.attack*100;
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
    //=====================================================GETTERS==================================================

    public int getAttack() {
        return attack;
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
    //=======================================================SETTERS===================================================

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setExpected(int expected) {
        this.expected = expected;
    }

    public void setBonusPointsMulti(int bonusPointsMulti) {
        this.bonusPointsMulti = bonusPointsMulti;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }
}
