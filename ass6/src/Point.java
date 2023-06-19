// 215487695 Noam Kaplinski

/**
 * The class can create point,return length between points,get the coordinates of the point,
 * and if two points are the same.
 *
 * @author Noam kaplinski
 */
public class Point {

    private double x;
    private double y;

    /**
     * The function return a point according to the coordinates it gets.
     *
     * @param x The double value which represent the x coordinate value of the point.
     * @param y The double value which represent the y coordinate value of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The function returns the x coordinate of the point.
     *
     * @return x The x coordinate of the point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * The function returns the y coordinate of the point.
     *
     * @return y The y coordinate of the point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * The function receives a point and return the length between this point and the other point.
     *
     * @param other The other Point which we compare with.
     * @return double the distance between the two points.
     */
    public double distance(Point other) {
        return Math.sqrt((other.x - this.x) * (other.x - this.x) + (other.y - this.y) * (other.y - this.y));
    }

    /**
     * The function receives a point and return if it equals to this point.
     *
     * @param other The point which we compare with.
     * @return boolean if the points are equals - return true, false otherwise
     */
    public boolean equals(Point other) {
        return Math.sqrt(Math.abs(this.y - other.y)) <= Math.pow(0.1, 10)
                && Math.sqrt(Math.abs(this.x - other.x)) <= Math.pow(0.1, 10);
    }
}
