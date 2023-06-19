//215487695 Noam Kaplinski

/**
 * The class can create ball remover, and with him can delete balls that's hit death-region block.
 *
 * @author Noam kaplinski
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBall;

    /**
     * The function creates ball remover.
     *
     * @param game          The game we create the ball remover with.
     * @param removedBlocks The counter we create the ball remover with.
     */
    public BallRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBall = removedBlocks;
    }

    /**
     * The function removes ball that hit the death-region block from the game.
     *
     * @param beingHit The block that has been hit.
     * @param hitter   The ball that hits the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        hitter.removeHitListener(this);
        this.remainingBall.decrease(1);
    }
}
