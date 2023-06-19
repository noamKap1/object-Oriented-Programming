//215487695 Noam Kaplinski

/**
 * The class can create ScoreIndicator and draw him on the draw surface.
 *
 * @author Noam kaplinski
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * The function create a ScoreTrackingListener.
     *
     * @param scoreCounter The counter we create the ScoreTrackingListener with.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * The function increases the score by 1 when we hit a block (not the borders).
     *
     * @param beingHit The block that has been hit.
     * @param hitter   The ball that hits the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }

    /**
     * The function returns the current score.
     *
     * @return Counter which contain the current score.
     */
    public Counter getCurrentScore() {
        return currentScore;
    }
}
