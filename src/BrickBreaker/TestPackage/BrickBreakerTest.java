/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

/**
 * Gets all the variables and has an array of values we can use to test various amounts.
 * @author Jerid 4/30/2020
 */
import BrickBreaker.view.Brick;

public class BrickBreakerTest {
    private static final int testNumbers[] = new int[]{10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,};
    private static int testResult;
    private static int amountOfBonus;
    public static void main(String[] args){
        testArrayOfOptions();
    }
    public static void  testArrayOfOptions(){
        for(int i = 0; i< testNumbers.length; i++){
            TestData.runTest(testNumbers[i], fromBricks(testNumbers[i]));
        }
    }
    public static int fromBricks(int i){
        testResult = i*100;
        amountOfBonus += Brick.ifComboBrickBroken( i);
        testResult += amountOfBonus;
        return testResult;
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
