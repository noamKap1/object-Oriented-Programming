//215487695 Noam Kaplinski

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

/**
 * The function can create a PauseScreen, do one frame of him and return when we should stop doing frames.
 *
 * @author Noam kaplinski
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private GUI gui;

    /**
     * The function creates a PauseScreen.
     *
     * @param k   The KeyboardSensor of the PauseScreen.
     * @param gui The gui of the PauseScreen.
     */
    public PauseScreen(KeyboardSensor k, GUI gui) {
        this.keyboard = k;
        this.stop = false;
        this.gui = gui;
    }

    /**
     * The function do one frame of the PauseScreen.
     *
     * @param d The draw surface we draw on.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
        this.gui.show(d);
    }

    /**
     * The function return if we should stop using the PauseScreen animation.
     *
     * @return The function return yes if we should keep using, false otherwise.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}