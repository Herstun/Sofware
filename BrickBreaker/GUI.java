package BrickBreaker;

/**
 * This class will be used for the scoring system and lives.
 *
 * @author Tyler 03/30/20
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * This class displays the score and health amount.
 *
 * @author Tyler
 */
public class GUI {

    private static final int health = 3;
    private static final int startScore = 0;
    private Color RED;
    private Color WHITE;
    private final int scoreWidth = 30;
    private final int scoreHeight = 45;
    private final int livesWidth = 670;
    private final int livesHeight = 45;
    private final String fontType = "Arial";
    protected Game game;
    protected StandardHandler sh;
    public static int lives = health;
    public static int score = startScore;

    public GUI(Game game, StandardHandler sh) {
        this.sh = sh;
        this.game = (Game) game;
    }

    public void tick() {
    }

    public void render(Graphics2D g2) {
        RED = g2.getColor();
        Font fontType = g2.getFont();;
        g2.setColor(WHITE);
        g2.drawString("Score: " + score, scoreWidth, scoreHeight);
        g2.drawString("Lives: " + lives, livesWidth, livesHeight);
        g2.setColor(RED);
        g2.setFont(fontType);
    }
}
