package BrickBreaker.model;

/**
 * This is an enumeration method.
 *
 * @author Dymond, Last updated: 2/20/2020
 */
public enum StandardID {
    Player, Ball, Brick, Boost, blockBroken;

    //=========================== Getters ======================================
    public static StandardID getPlayer() {
        return Player;
    }

    public static StandardID getBall() {
        return Ball;
    }

    public static StandardID getBrick() {
        return Brick;
    }

    public static StandardID getBoost() {
        return Boost;
    }

    //============================= Stetters ===================================
}
