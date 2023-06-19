//215487695 Noam Kaplinski

import java.util.List;

/**
 * The class defines the function numberOfBalls and initialBallVelocities and levelName and getBackground
 * and numberOfBlocksToRemove.
 *
 * @author Noam kaplinski
 */
public interface LevelInformation {
    /**
     * The function returns the number of balls of the level.
     *
     * @return The number of balls of the level.
     */
    int numberOfBalls();

    /**
     * The function returns the ball velocities of the level.
     *
     * @return The ball velocities of the level.
     */
    List<Velocity> initialBallVelocities();

    /**
     * The function return the paddle speed of the level.
     *
     * @return The paddle speed of the level.
     */
    int paddleSpeed();

    /**
     * The function return the paddle width of the level.
     *
     * @return The paddle width of the level.
     */
    int paddleWidth();

    /**
     * The function return the level name of the level.
     *
     * @return The level name of the level.
     */
    String levelName();

    /**
     * The function returns the background of the level.
     *
     * @return The background of the level.
     */
    Sprite getBackground();


    /**
     * The function returns the list of all the blocks of the level.
     *
     * @return The list of all the blocks of the level.
     */
    List<Block> blocks();


    /**
     * The function returns the number of blocks left to remove of the level.
     *
     * @return The number of blocks left to remove of the level.
     */
    int numberOfBlocksToRemove();
}