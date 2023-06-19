//215487695 Noam Kaplinski

/**
 * The class can build a CollisionInfo and return his features.
 *
 * @author Noam kaplinski
 */
public class CollisionInfo {
    private Point point;
    private Collidable collidable;

    /**
     * The function gets a Point and a Collidable and returns the CollisionInfo.
     *
     * @param collisionPoint  The point which represent the collision point.
     * @param collisionObject The Collidable which represent the collision object.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.point = collisionPoint;
        this.collidable = collisionObject;
    }

    /**
     * The function returns the collision point.
     *
     * @return memberCollisionPoint The collision point with the ball.
     */
    public Point collisionPoint() {
        return this.point;
    }

    /**
     * The function returns the collision object.
     *
     * @return memberCollisionObject The collision object which collide with the ball.
     */
    public Collidable collisionObject() {
        return this.collidable;
    }
}