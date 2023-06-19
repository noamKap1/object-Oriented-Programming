//215487695 Noam Kaplinski

import biuoop.DrawSurface;

/**
 * The class defines the function doOneFrame and shouldStop.
 *
 * @author Noam kaplinski
 */
public interface Animation {
    /**
     * The function draws one frame onto the given draw surface.
     *
     * @param d The draw surface we draw on.
     */
    void doOneFrame(DrawSurface d);

    /**
     * The function return if we should stop drawing or not.
     *
     * @return The function return yes if we should keep using, false otherwise.
     */
    boolean shouldStop();
}