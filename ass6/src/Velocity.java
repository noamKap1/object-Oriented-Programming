// Noam Kaplinski 215487695

/**
 * The class can create velocity and Take a point with position (x,y) and return a new point
 * with position (x+dx, y+dy).
 *
 * @author Noam kaplinski
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * The function gets the dx and dy and sets them to the new velocity.
     *
     * @param dx The double which represent the velocity in the x line.
     * @param dy The double which represent the velocity in the y line.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * The function gets a point and return a new point with new coordinates according to the velocity.
     *
     * @param p The point which we change the coordinates of.
     * @return Point the point with new coordinates according to the velocity.
     */
    public Point applyToPoint(Point p) {
        Point point = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return point;
    }

    /**
     * The function return "this" velocity in the x-axis.
     *
     * @return double the velocity in the x-axis
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * The function return "this" velocity in the x-axis.
     *
     * @return double the velocity in the x-axis
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * The function gets an angle and speed and calculates the velocity from this two ingredients and
     * returns the velocity.
     *
     * @param angle The double which represent the angle of the velocity.
     * @param speed The double which represent the total speed of the velocity.
     * @return Velocity the calculated velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double rad = Math.PI / 180;
        double dx = Math.cos(rad * angle) * speed, dy = Math.sin(rad * angle) * -speed;
        return new Velocity(dx, dy);
    }

    /**
     * The function calculates the speed according to the velocity.
     *
     * @return The speed according to the velocity.
     */
    public double speed() {
        return Math.sqrt(this.dx * this.dx + this.dy * this.dy);
    }

    /**
     * The function sets the value she gets to the dx of the velocity.
     *
     * @param dx The value which we set to be the dx of the velocity.
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     * The function sets the value she gets to the dy of the velocity.
     *
     * @param dy The value which we set to be the dy of the velocity.
     */
    public void setDy(double dy) {
        this.dy = dy;
    }
}