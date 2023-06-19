//215487695 Noam Kaplinski

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The class can create Block, draw the Block on the given draw surface,
 * return what happen when ball hit the block, add the block to a game and can return the ball features.
 *
 * @author Noam kaplinski
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rec;
    private Color color;
    private ArrayList<HitListener> hitListeners;

    /**
     * The function gets a rectangle and a color returns the block.
     *
     * @param rec   The rectangle which the block contain.
     * @param color The color of the block.
     */
    public Block(Rectangle rec, Color color) {
        this.rec = rec;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * The function sets an array list of hitListeners to this.hitListeners.
     *
     * @param hitListeners The array list we set with.
     */
    public void setHitListeners(ArrayList<HitListener> hitListeners) {
        this.hitListeners = hitListeners;
    }


    /**
     * The function returns the rectangle of the block.
     *
     * @return rec The rectangle the block contain.
     */
    public Rectangle getCollisionRectangle() {
        return this.rec;
    }

    /**
     * The function sets a Rectangle to this.rec.
     *
     * @param rec The Rectangle we set with.
     */
    public void setRec(Rectangle rec) {
        this.rec = rec;
    }

    /**
     * The function returns the color of the block.
     *
     * @return color The color of the block.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * The function gets a DrawSurface and Block the ball on it.
     *
     * @param d The DrawSurface which we draw on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.getCollisionRectangle().getWidth(), (int) this.getCollisionRectangle().getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.getCollisionRectangle().getWidth(), (int) this.getCollisionRectangle().getHeight());
        d.setColor(Color.GRAY);
    }

    /**
     * The function notifies all the hit listeners that there was a hit.
     *
     * @param hitter The ball that hit.
     */
    private void notifyHit(Ball hitter) {
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * @param ball            The ball which hits the block.
     * @param collisionPoint  The point which represent the collision point with the block.
     * @param currentVelocity The velocity of the ball before he hits the block.
     * @return The velocity of the ball after he hits the block.
     */
    public Velocity hit(Ball ball, Point collisionPoint, Velocity currentVelocity) {
        Point[] edges = new Point[4];
        edges[0] = new Point(this.rec.getUpperLeft().getX(), this.rec.getUpperLeft().getY());
        edges[1] = new Point(this.rec.getUpperLeft().getX() + this.rec.getWidth(), this.rec.getUpperLeft().getY());
        edges[2] = new Point(this.rec.getUpperLeft().getX() + this.rec.getWidth(),
                this.rec.getUpperLeft().getY() + this.rec.getHeight());
        edges[3] = new Point(this.rec.getUpperLeft().getX(), this.rec.getUpperLeft().getY() + this.rec.getHeight());
//        if (this.equals(new Block(new Rectangle(new Point(0, 600 - 20), 800, 20), Color.gray))) {
//            notifyHit(ball);
//        }
        for (int i = 0; i < edges.length; i++) {
            if (collisionPoint.equals(edges[i])) {
                notifyHit(ball);
                return new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy() * -1);
            }
        }
        if (Math.abs(collisionPoint.getY() - this.rec.getUpperLeft().getY()
                - this.rec.getHeight()) <= Math.pow(0.1, 10)
                || Math.abs(collisionPoint.getY() - this.rec.getUpperLeft().getY()) <= Math.pow(0.1, 10)) {
            currentVelocity.setDy(-currentVelocity.getDy());
        }
        if (Math.abs(collisionPoint.getX() - this.rec.getUpperLeft().getX()) <= Math.pow(0.1, 10)
                || Math.abs(collisionPoint.getX() - this.rec.getUpperLeft().getX()
                - this.rec.getWidth()) <= Math.pow(0.1, 10)) {
            currentVelocity.setDx(-currentVelocity.getDx());
        }
        notifyHit(ball);
        return currentVelocity;
    }

    /**
     * The function gets a Game and adds the Block to it.
     *
     * @param g The game which we add the Block to.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * The function notify the block time has passed.
     */
    public void timePassed() {
        return;
    }

    /**
     * The function removes the block from the game.
     *
     * @param game The game we delete the ball from.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    /**
     * The function adds the HitListener to the HitListeners list.
     *
     * @param hl The HitListener we add.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * The function removes the HitListener from the HitListeners list.
     *
     * @param hl The HitListener we delete.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}