import BrickBreaker.view.Brick;

public class BrickBreakerTest {
    private static final int testNumbers[] = new int[]{10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,};
    private static int testResult;
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
        testResult += Brick.ifComboBrickBroken( i);
        return testResult;
    }
    //======================================GETTERS===================================================

    public static int[] getIntArray() {
        return testNumbers;
    }

    public static int getTestResult() {
        return testResult;
    }
    //=========================================SETTERS==================================================

    public static void setTestResult(int testResult) {
        BrickBreakerTest.testResult = testResult;
    }
}
