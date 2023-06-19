//215487695 Noam Kaplinski

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The class can create ScoreIndicator and draw him on the draw surface.
 *
 * @author Noam kaplinski
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * The function create a score indicator.
     *
     * @param score The counter we create the score indicator with.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.drawText(370, 15, "score : " + this.score.getValue(), 15);
        d.setColor(Color.gray);
    }

    @Override
    public void timePassed() {
        return;
    }
}
