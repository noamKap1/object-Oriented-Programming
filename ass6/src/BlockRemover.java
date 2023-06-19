//215487695 Noam Kaplinski

/**
 * The class can create BlockRemover, and with him can delete blocks that's been hit from one of the ball.
 *
 * @author Noam kaplinski
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * The function creates a block remover.
     *
     * @param game          The game we create the block remover with.
     * @param removedBlocks The counter we create the block remover with.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * The function removes block that are hit from the game.
     *
     * @param beingHit The block that has been hit.
     * @param hitter   The ball that hits the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        beingHit.removeHitListener(this);
        this.remainingBlocks.decrease(1);
    }
}