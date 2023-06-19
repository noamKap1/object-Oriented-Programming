//215487695 Noam Kaplinski

import java.util.ArrayList;

/**
 * The class can create rectangle, return his intersection points with other lines,
 * return the rectangle edges and get the features of the rectangle.
 * and if two points are the same.
 *
 * @author Noam kaplinski
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * The function gets a point a width and a height and returns the rectangle.
     *
     * @param upperLeft The point which we build the rectangle with.
     * @param width     The double which represent the width of the rectangle.
     * @param height    The double which represent the width of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * The function returns if exists the intersection points with a line.
     *
     * @param line The line which return the intersection points with.
     * @return points The point list which contains the intersection points with the line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Point> points = new ArrayList<>();
        Line[] lines = this.edges();
        for (int i = 0; i < 4; i++) {
            if (lines[i].isIntersecting(line)) {
                points.add(lines[i].intersectionWith(line));
            }
        }
        return points;
    }

    /**
     * The function returns the edges of the rectangle.
     *
     * @return lines The Line[] which contains the edges of the rectangle.
     */
    public Line[] edges() {
        Line[] lines = new Line[4];
        Point[] ver = new Point[4];
        ver[0] = new Point(this.upperLeft.getX(), this.upperLeft.getY());
        ver[1] = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        ver[2] = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
        ver[3] = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        lines[0] = new Line(ver[0], ver[1]);
        lines[1] = new Line(ver[1], ver[2]);
        lines[2] = new Line(ver[2], ver[3]);
        lines[3] = new Line(ver[3], ver[0]);
        return lines;
    }

    /**
     * The function returns the upper left point of the rectangle.
     *
     * @return The upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * The function returns the width of the rectangle.
     *
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * The function returns the height of the rectangle.
     *
     * @return The height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * The function sets the upper left point of the rectangle.
     *
     * @param upperLeft The upper left point which we set the rectangle to have.
     */
    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }
}
