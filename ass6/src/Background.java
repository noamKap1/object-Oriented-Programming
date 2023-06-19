//215487695 Noam Kaplinski

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The class creates a background for the level, can draw him, and add text,rectangles,lines and circles to
 * the background, and notify that time has passed.
 *
 * @author Noam kaplinski
 */
public class Background implements Sprite {
    private List<String> text;
    private List<Integer> rectangle;
    private List<Integer> lines;
    private List<Integer> circle;
    private List<Integer> drawText;
    private List<Color> textColor;
    private List<Color> rectangleColor;
    private List<Color> linesColor;
    private List<Color> circleColor;

    /**
     * The function creates an empty background.
     */
    public Background() {
        this.text = new ArrayList<>();
        this.rectangle = new ArrayList<>();
        this.lines = new ArrayList<>();
        this.circle = new ArrayList<>();
        this.drawText = new ArrayList<>();
        this.textColor = new ArrayList<>();
        this.rectangleColor = new ArrayList<>();
        this.linesColor = new ArrayList<>();
        this.circleColor = new ArrayList<>();
    }

    /**
     * The function draws the background onto the drawing surface.
     *
     * @param d The draw surface we draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        int j = 0;
        for (int i = 0; i < rectangle.size(); i++) {
            d.setColor(rectangleColor.get(j));
            d.fillRectangle(rectangle.get(i), rectangle.get(i + 1), rectangle.get(i + 2), rectangle.get(i + 3));
            i += 3;
            j++;
        }
        j = 0;
        for (int i = 0; i < lines.size(); i++) {
            d.setColor(linesColor.get(j));
            d.drawLine(lines.get(i), lines.get(i + 1), lines.get(i + 2), lines.get(i + 3));
            i += 3;
            j++;
        }
        j = 0;
        for (int i = 0; i < circle.size(); i++) {
            d.setColor(circleColor.get(j));
            d.fillCircle(circle.get(i), circle.get(i + 1), circle.get(i + 2));
            j++;
            i += 2;
        }
        j = 0;
        for (int i = 0; i < text.size(); i++) {
            j = i * 3;
            d.setColor(textColor.get(i));
            d.drawText(drawText.get(j), drawText.get(j + 1), text.get(i), drawText.get(j + 2));
        }

    }

    /**
     * The function adds a text to the background.
     *
     * @param width  The width of where the text will appear.
     * @param height The height of where the text will appear.
     * @param str    The text.
     * @param size   The size of the text.
     * @param color  The color of the text.
     */
    public void addText(int width, int height, String str, int size, Color color) {
        text.add(str);
        drawText.add(width);
        drawText.add(height);
        drawText.add(size);
        textColor.add(color);
    }

    /**
     * The function adds a rectangle to the background.
     *
     * @param xCor  The starting x coordinate.
     * @param yCor  The starting y coordinate.
     * @param xMore The length of the rectangle.
     * @param yMore The height of the rectangle.
     * @param color The color of the rectangle.
     */
    public void addRectangle(int xCor, int yCor, int xMore, int yMore, Color color) {
        rectangle.add(xCor);
        rectangle.add(yCor);
        rectangle.add(xMore);
        rectangle.add(yMore);
        rectangleColor.add(color);
    }

    /**
     * The function adds a line to the background.
     *
     * @param xStart The starting x coordinate.
     * @param yStart The starting y coordinate.
     * @param xEnd   The ending x coordinate.
     * @param yEnd   The ending y coordinate.
     * @param color  The color of the line.
     */
    public void addLines(int xStart, int yStart, int xEnd, int yEnd, Color color) {
        lines.add(xStart);
        lines.add(yStart);
        lines.add(xEnd);
        lines.add(yEnd);
        linesColor.add(color);
    }

    /**
     * The function adds a circle to the background.
     *
     * @param x     The x coordinate.
     * @param y     The y coordinate.
     * @param size  The radius of the circle.
     * @param color The color of the circle.
     */
    public void addCircle(int x, int y, int size, Color color) {
        circle.add(x);
        circle.add(y);
        circle.add(size);
        circleColor.add(color);
    }

    @Override
    public void timePassed() {
        return;
    }
}
