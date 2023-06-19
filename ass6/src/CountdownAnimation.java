//215487695 Noam Kaplinski

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * The class can create a count-down animation, draw one frame of him, and return when we need to stop counting.
 *
 * @author Noam kaplinski
 */
public class CountdownAnimation implements Animation {
    private int countFrom;
    private double numOfSeconds;
    private SpriteCollection gameScreen;
    private GUI gui;
    private Sleeper sleeper = new Sleeper();
    private boolean stop;
    private GameLevel gameLevel;

    /**
     * The function creates a count-down animation.
     *
     * @param numOfSeconds The numbers of seconds.
     * @param countFrom    The number which we start counting from.
     * @param gui          The gui we draw on.
     * @param gameScreen   The sprites we draw with the count-down.
     */
    public CountdownAnimation(double numOfSeconds,
                              int countFrom, GUI gui,
                              SpriteCollection gameScreen) {
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.numOfSeconds = numOfSeconds;
        this.gui = gui;
        this.stop = false;
    }

    /**
     * The function creates a count-down animation.
     *
     * @param numOfSeconds The numbers of seconds.
     * @param countFrom    The number which we start counting from.
     * @param gui          The gui we draw on.
     * @param gameScreen   The sprites we draw with the count-down.
     * @param gameLevel    The game level we are playing.
     */
    public CountdownAnimation(double numOfSeconds,
                              int countFrom, GUI gui,
                              SpriteCollection gameScreen, GameLevel gameLevel) {
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.numOfSeconds = numOfSeconds;
        this.gui = gui;
        this.stop = false;
        this.gameLevel = gameLevel;
    }

    /**
     * The function draws the sprites and the count-down onto the draw surface.
     *
     * @param d The draw surface we draw on.
     */
    public void doOneFrame(DrawSurface d) {
        for (int i = this.countFrom; i > 0; i--) {
            DrawSurface drawSurface = gui.getDrawSurface();
            d = drawSurface;
            d.setColor(Color.BLUE);
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(Color.GRAY);
            d.setColor(Color.RED);
            d.fillRectangle(0, 0, 800, 20);
            this.gameScreen.drawAllOn(d);
            d.setColor(Color.WHITE);
            d.fillRectangle(325, 200, 150, 150);
            d.setColor(Color.BLACK);
            d.drawText(350, 225, "Get ready!!!", 20);
            d.drawText(395, 300, "" + i, 20);
            d.drawText(331, 270, "\uD83C\uDFC1", 40);
            d.drawText(381, 270, "\uD83C\uDFC1", 40);
            d.drawText(431, 270, "\uD83C\uDFC1", 40);
            d.drawText(200, 20, "Score: " + this.gameLevel.getScore().getValue(), 15);
            d.drawText(450, 20, "Level name: " + this.gameLevel.getLevelInformation().levelName(), 15);
            gui.show(d);
            this.sleeper.sleepFor((long) (this.numOfSeconds / this.countFrom * 1000));
        }
        this.stop = true;
    }

    /**
     * The function return if we should stop using the count-down animation.
     *
     * @return The function return yes if we should keep using, false otherwise.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}