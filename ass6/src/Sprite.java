//215487695 Noam Kaplinski

import biuoop.DrawSurface;

/**
 * The class defines the function drawOn and timePassed.
 *
 * @author Noam kaplinski
 */
public interface Sprite {
    /**
     * The function draws the sprite on the draw surface.
     *
     * @param d The draw surface we draw on.
     */
    void drawOn(DrawSurface d);

    /**
     * The function notify the sprite that time has passed.
     */
    void timePassed();
}