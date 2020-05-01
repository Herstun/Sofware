/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

import BrickBreaker.view.Brick;

/**
 *
 * @author meije
 */
public class BrickBreakerTest {
    private static final int intArray[] = new int[]{10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,};
    private static int testResult;
    public static void main(String[] args){
        testArrayOfOptions();
    }
    public static void  testArrayOfOptions(){
        for(int i = 0; i< intArray.length; i++){
            TestData.runTest(intArray[i], fromBricks(intArray[i]));
        }
    }
    public static int fromBricks(int i){
        testResult = i*100;
        testResult += Brick.ifComboBrickBroken( i);
        return testResult;
    }
    //======================================GETTERS===================================================

    public static int[] getIntArray() {
        return intArray;
    }

    public static int getTestResult() {
        return testResult;
    }
    //=========================================SETTERS==================================================

    public static void setTestResult(int testResult) {
        BrickBreakerTest.testResult = testResult;
    }
}
