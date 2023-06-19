// 215487695 Noam Kaplinski

/**
 * The class can create line,return length of the line,the middle of the line,the end and the start of the line,
 * whether he intersects with other line and if he does where he intersects, if two lines are equal,
 * the closest intersection to start of line and if a point is on a line.
 *
 * @author Noam kaplinski
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * The function gets the coordinates of the starting and the ending points and sets them to the line.
     *
     * @param x1 The double value which represent the x coordinate value of the starting point.
     * @param y1 The double value which represent the y coordinate value of the starting point.
     * @param x2 The double value which represent the x coordinate value of the starting end.
     * @param y2 The double value which represent the y coordinate value of the starting end.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * The function gets the starting and the ending points and sets them to the line.
     *
     * @param start The point which represent the start of the line.
     * @param end   The point which represent the end of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The function calculates the length between the starting point and the end point and return the answer.
     *
     * @return double The length of the line.
     */
    public double length() {
        return this.start().distance(this.end());
    }

    /**
     * The function calculates and return the middle of the line.
     *
     * @return point The middle of the line.
     */
    public Point middle() {
        return new Point((this.start().getX() + this.end().getX()) / 2,
                (this.start().getY() + this.end().getY()) / 2);
    }

    /**
     * The function return the start of the line.
     *
     * @return point The start of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * The function return the end of the line.
     *
     * @return point The end of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * The function gets two lines and then checks if they intersect and,
     * Returns true if they are, false otherwise.
     *
     * @param other The other line which we check with.
     * @return boolean if the lines intersect return true, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        Point point = this.intersectionPoint(other);
        if (point == null) {
            return false;
        } else if (!onLine(point, this)) {
            return false;
        } else {
            return onLine(point, other);
        }
    }

    /**
     * The function returns the intersection point between the lines if it exists, null otherwise.
     *
     * @param other The line which we search the intersection point.
     * @return p The point which is null or the intersection point.
     */
    public Point intersectionWith(Line other) {
        if (this.isIntersecting(other)) {
            return this.intersectionPoint(other);
        }
        return null;
    }

    /**
     * The function gets two lines and returns the intersect point between the two lines if,
     * the intersection point exist.
     *
     * @param other The other line which we return, if exists, the intersection point with.
     * @return line if the intersection point exists return the intersection point, null otherwise.
     */
    private Point intersectionPoint(Line other) {
        double x1 = this.end.getY() - this.start.getY(), x2 = other.end.getY() - other.start.getY(),
                y1 = this.start.getX() - this.end.getX(), y2 = other.start.getX() - other.end.getX(),
                z1 = x1 * (this.start.getX()) + y1 * (this.start.getY()),
                z2 = x2 * (other.start.getX()) + y2 * (other.start.getY());
        double a = (x1 * y2) - (x2 * y1);
        if (a == 0) {
            if (this.equals(other)) {
                return null;
            } else if (this.start.equals(other.start) && !onLine(this.end, other)) {
                return this.start;
            } else if (this.start.equals(other.end) && !onLine(this.end, other)) {
                return this.start;
            } else if (this.end.equals(other.start) && !onLine(this.start, other)) {
                return this.end;
            } else if (this.end.equals(other.end) && !onLine(this.start, other)) {
                return this.end;
            } else {
                return null;
            }
        } else {
            double a1 = (y2 * z1 - y1 * z2) / a, a2 = (x1 * z2 - x2 * z1) / a;
            return new Point(a1, a2);
        }
    }

    /**
     * The function returns the closest intersection point to start of the line.
     *
     * @param rect The Rectangle which with him, we search the closest intersection point to start of the line.
     * @return p The closest intersection point to start of the line
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        java.util.List<Point> points = rect.intersectionPoints(this);
        if (points.size() == 0) {
            return null;
        }
        Point p = points.get(0);
        for (Point point : points) {
            if (point.distance(this.start()) < p.distance(this.start)) {
                p = point;
            }
        }
        return p;
    }

    /**
     * The function gets a line and return if this line and the other line is the same line.
     *
     * @param other The other line which we compare with.
     * @return boolean if the lines are the same return true, false otherwise.
     */
    public boolean equals(Line other) {
        return ((this.start.equals(other.end)) && (other.start().equals(this.end))
                || (this.start.equals(other.start)) && (other.end().equals(this.end)));
    }

    /**
     * The function gets a line and a point and return true if the point is on the line, false otherwise.
     *
     * @param point The point which we compare with.
     * @param line  The line which we compare with.
     * @return true if the point is on the line, false otherwise.
     */
    private boolean onLine(Point point, Line line) {
        double x = line.start.getX(), y = line.start.getY(), x1 = line.end.getX(), y1 = line.end.getY();
        if (point.getX() - Math.pow(0.1, 10) > Math.max(x, x1)
                || Math.min(x, x1) > point.getX() + Math.pow(0.1, 10)) {
            return false;
        }
        return point.getY() - Math.pow(0.1, 10) <= Math.max(y, y1)
                && Math.min(y, y1) <= point.getY() + Math.pow(0.1, 10);
    }
}
