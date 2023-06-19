//215487695 Noam Kaplinski

/**
 * The class defines the function getCollisionRectangle and hit.
 *
 * @author Noam kaplinski
 */
public interface Collidable {
    /**
     * The function returns the Collision rectangle.
     *
     * @return rec The rectangle which the ball collide with.
     */
    Rectangle getCollisionRectangle();

    /**
     * The function calculates the velocity of the ball after he hits the block.
     *
     * @param ball            ball The ball which collide with the block.
     * @param collisionPoint  collisionPoint The point which represent the collision point with the block.
     * @param currentVelocity currentVelocity The velocity of the ball before he hits the block.
     * @return Velocity which is the velocity of the ball (if exists) after he hits the block.
     */
    Velocity hit(Ball ball, Point collisionPoint, Velocity currentVelocity);
}


