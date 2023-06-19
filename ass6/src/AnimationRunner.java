//215487695 Noam Kaplinski

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * The class creates an AnimationRunner, can return his gui and run an animation.
 *
 * @author Noam kaplinski
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * The function creates an animationRunner.
     *
     * @param gui             The gui we draw the animation on.
     * @param framesPerSecond The number of frames per second.
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {
        this.framesPerSecond = framesPerSecond;
        this.sleeper = new Sleeper();
        this.gui = gui;
    }

    /**
     * The function returns the AnimationRunner gui.
     *
     * @return The AnimationRunner gui.
     */
    public GUI getGui() {
        return this.gui;
    }

    /**
     * The function runs the given Animation.
     *
     * @param animation The animation we run.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
        if (animation.shouldStop()) {
            return;
        }
    }
}