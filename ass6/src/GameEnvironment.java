//215487695 Noam Kaplinski

import java.util.ArrayList;
import java.util.List;

/**
 * The class can build a Game environment add a collidable and return the collidable with the Closest Collision point.
 *
 * @author Noam kaplinski
 */
public class GameEnvironment {
    private java.util.List<Collidable> collidables;

    /**
     * The function builds a GameEnvironment.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * The function adds a Collidable to the Collidable list of the game environment.
     *
     * @param c The Collidable we add to the Collidable list of the game environment.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * The function returns the collidable with the Closest Collision point.
     *
     * @param trajectory The line which with him we check which collidable is the collidable with the
     *                   closest collidable point.
     * @return The CollisionInfo about the collidable with the Closest Collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        if (this.collidables.size() == 0) {
            return null;
        }
        Collidable collidable1 = this.collidables.get(0);
        Point point = trajectory.closestIntersectionToStartOfLine(collidable1.getCollisionRectangle());
        for (Collidable collidable2 : this.collidables) {
            Point cPoint = trajectory.closestIntersectionToStartOfLine(collidable2.getCollisionRectangle());
            if (cPoint != null && (point == null || cPoint.distance(trajectory.start())
                    < point.distance(trajectory.start()))) {
                point = cPoint;
                collidable1 = collidable2;
            }
        }
        if (point == null) {
            return null;
        }
        return new CollisionInfo(point, collidable1);
    }

    /**
     * The function removes the collidable from the collidbles list.
     *
     * @param collidable The collidable we delete.
     */
    public void removeCollidable(Collidable collidable) {
        this.collidables.remove(collidable);
    }
}