package BrickBreaker.view;

/**
 * This creates the bricks height and width as well as the color of the brick.
 *
 * @author Tyler, Last updated 4/23/2020
 */
//import BrickBreaker.model.GameModel;
import BrickBreaker.model.StandardGameObject;
import BrickBreaker.model.StandardID;
import java.awt.Color;
import java.awt.Graphics2D;

public class Brick extends StandardGameObject {

    protected final int brickWidth = 80;
    protected final int brickHeight = 20;
    protected Color color;
    protected final Color firstBrick = Color.red;
    protected final Color secondBrick = Color.blue;
    protected final Color thirdBrick = Color.green;
    protected final Color fourthBrick = Color.orange;
    protected static int pointsPerBlock = 100;
    protected static int blockBroken = 0;
    protected static int noComboPointsAchieved = 0;
    protected static int numberForCombo = 10;
    protected static int comboPointsAchieved = 250;

    /**
     * This method creates the brick and makes the color of the brick with the
     * number it correlates to with the level text.
     *
     * @param _x This is the width of the brick.
     * @param _y This is the height of the brick.
     * @param _val This is the value of the brick number for the text file.
     */
    public Brick(double _x, double _y, int _val) {
        super(_x, _y, StandardID.Brick);
        this.width = brickWidth;
        this.height = brickHeight;

        switch (_val) {
            case 0:
                return;
            case 1:
                //This makes the first brick a red brick.
                this.color = firstBrick;
                break;
            case 2:
                //This makes the first brick a blue brick.
                this.color = secondBrick;
                break;
            case 3:
                //This makes the first brick a green brick.
                this.color = thirdBrick;
                break;
            case 4:
                //This makes the first brick a orange brick.
                this.color = fourthBrick;
                break;
        }
    }

    /**
     * This method keeps the game running with all the components together.
     */
    @Override
    public void tick() {
    }

    //This public method is called on everytime a block is destroyed and counts. If ten blocks have been destroyed than their is a combo points.
    public static int ifComboBrickBroken(int blockBroken){
        if(Brick.blockBroken%numberForCombo == 0){
            return comboPointsAchieved;
        }
        else
            return noComboPointsAchieved;
    }

    /**
     * This method draws the brick onto the canvas.
     *
     * @param _brick This creates the brick and sets the color.
     */
    @Override
    public void render(Graphics2D _brick) {
        _brick.setColor(this.color);
        _brick.fillRect((int) _x, (int) _y, (int) width, (int) height);
    }

    //============================ Getters =====================================
    public static int getComboPointsAchieved() {
        return comboPointsAchieved;
    }
    public int getBrickWidth() {
        return brickWidth;
    }

    public int getBrickHeight() {
        return brickHeight;
    }

    public Color getColor() {
        return color;
    }

    public Color getFirstBrick() {
        return firstBrick;
    }

    public Color getSecondBrick() {
        return secondBrick;
    }

    public Color getThirdBrick() {
        return thirdBrick;
    }

    public Color getFourthBrick() {
        return fourthBrick;
    }

    public static int getPointsPerBlock() {
        return pointsPerBlock;
    }

    public static int getBlockBroken() {
        return blockBroken;
    }

    public static int getNoComboPointsAchieved() {
        return noComboPointsAchieved;
    }

    public static int getNumberForCombo() {
        return numberForCombo;
    }

    //============================ Setters =====================================
    public void setColor(Color color) {
        this.color = color;
    }

    public static void setNoComboPointsAchieved(int noComboPointsAchieved) {
        Brick.noComboPointsAchieved = noComboPointsAchieved;
    }

    public static void setPointsPerBlock(int pointsPerBlock) {
        Brick.pointsPerBlock = pointsPerBlock;
    }

    public static void setBlockBroken(int blockBroken) {
        Brick.blockBroken = blockBroken;
    }

    public static void setNumberForCombo(int numberForCombo) {
        Brick.numberForCombo = numberForCombo;
    }

    public static void setComboPointsAchieved(int comboPointsAchieved) {
        Brick.comboPointsAchieved = comboPointsAchieved;
    }
}