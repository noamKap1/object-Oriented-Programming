//215487695 Noam Kaplinski

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The class can create a KeyPressStoppableAnimation do one frame of him and return if we should stop the animation.
 *
 * @author Noam kaplinski
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop = false;
    private boolean isAlreadyPressed;

    /**
     * The function creates a KeyPressStoppableAnimation.
     *
     * @param sensor    The KeyboardSensor that gets the keys the been pressed.
     * @param key       The key for the KeyPressStoppableAnimation.
     * @param animation The animation of the KeyPressStoppableAnimation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.sensor = sensor;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (sensor.isPressed(key)) {
            if (!this.isAlreadyPressed) {
                stop = true;
            }
            this.isAlreadyPressed = true;
        } else {
            this.isAlreadyPressed = false;
        }
        animation.doOneFrame(d);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}