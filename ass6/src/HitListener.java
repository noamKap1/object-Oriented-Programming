//215487695 Noam Kaplinski

/**
 * The class defines the function hitEvent.
 *
 * @author Noam kaplinski
 */
public interface HitListener {
    /**
     * The function is called whenever the beingHit object is hit.
     *
     * @param beingHit The block that has been hit.
     * @param hitter   The ball that hits the block.
     */
    void hitEvent(Block beingHit, Ball hitter);
}