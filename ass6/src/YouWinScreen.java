//215487695 Noam Kaplinski

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

/**
 * The function can create a YouWinScreen do one frame of him and return if we should keep doing frames of him.
 *
 * @author Noam kaplinski
 */
public class YouWinScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private GUI gui;

    private Counter score;

    /**
     * The function creates a YouWinScreen.
     *
     * @param k     The KeyboardSensor of the YouWinScreen.
     * @param gui   The gui of the YouWinScreen.
     * @param score The score we have.
     */
    public YouWinScreen(KeyboardSensor k, GUI gui, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.gui = gui;
        this.score = score;
    }

    /**
     * The function do one frame of the YouWinScreen.
     *
     * @param d The draw surface we draw on.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + this.score.getValue(), 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
        this.gui.show(d);
    }

    /**
     * The function return if we should stop using the YouWinScreen animation.
     *
     * @return The function return yes if we should keep using, false otherwise.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
