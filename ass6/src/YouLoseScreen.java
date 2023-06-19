//215487695 Noam Kaplinski

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

/**
 * The function can create a YouLoseScreen do one frame of him and return if we should keep doing frames of him.
 *
 * @author Noam kaplinski
 */
public class YouLoseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private GUI gui;

    private Counter score;

    /**
     * The function creates a YouLoseScreen.
     *
     * @param k     The KeyboardSensor of the YouLoseScreen.
     * @param gui   The gui of the YouLoseScreen.
     * @param score The score we have.
     */
    public YouLoseScreen(KeyboardSensor k, GUI gui, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.gui = gui;
        this.score = score;
    }

    /**
     * The function do one frame of the YouLoseScreen.
     *
     * @param d The draw surface we draw on.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + this.score.getValue(), 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
        this.gui.show(d);
    }

    /**
     * The function return if we should stop using the YouLoseScreen animation.
     *
     * @return The function return yes if we should keep using, false otherwise.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
