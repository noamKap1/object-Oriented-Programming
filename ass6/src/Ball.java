//215487695 Noam Kaplinski

import java.awt.Color;
import java.util.ArrayList;

import biuoop.DrawSurface;

/**
 * The class can create ball, draw the ball on the given draw surface,
 * move the ball, add the ball to a game, sets the ball features and coordinates and can return the ball features
 * and coordinates.
 *
 * @author Noam kaplinski
 */
public class Ball implements Sprite, HitNotifier {
    private Point point;
    private int size;
    private Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
    private ArrayList<HitListener> hitListeners;

    /**
     * The function gets the coordinates of the middle of the ball, his color and radius and return the ball.
     *
     * @param x     The x coordinate of the middle of the ball.
     * @param y     The y coordinate of the middle of the ball.
     * @param r     The int which represent the radius of the ball.
     * @param color The java.awt.Color which represent the color of the ball.
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.size = r;
        this.point = new Point(x, y);
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * The function gets the point of the middle of the ball, his color and radius and return the ball.
     *
     * @param center The point which represents the middle of the ball.
     * @param r      The int which represent the radius of the ball.
     * @param color  The java.awt.Color which represent the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.size = r;
        this.point = center;
        this.color = color;
    }

    /**
     * The function returns the x coordinate of the middle of the ball.
     *
     * @return x The int which represent the x coordinate of the middle of the ball.
     */
    public int getX() {
        return (int) this.point.getX();
    }

    /**
     * The function returns the y coordinate of the middle of the ball.
     *
     * @return y The int which represent the x coordinate of the middle of the ball.
     */
    public int getY() {
        return (int) this.point.getY();
    }

    /**
     * The function returns the size of the ball.
     *
     * @return x The int which represent the size of the middle of the ball.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * The function returns the point of the middle of the ball.
     *
     * @return x The point which represent the middle of the ball.
     */
    public Point getCenter() {
        return this.point;
    }

    /**
     * The function returns the color of the ball.
     *
     * @return x The color which represent the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * The function returns velocity color of the ball.
     *
     * @return x The int which represent the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * The function sets a Point to this.point.
     *
     * @param point The Point we set with.
     */
    public void setPoint(Point point) {
        this.point = point;
    }

    /**
     * The function gets a GameEnvironment and sets it to "this" GameEnvironment.
     *
     * @param game The GameEnvironment which represent the game environment the ball in.
     */
    public void setGameEnvironment(GameEnvironment game) {
        this.gameEnvironment = game;
    }

    /**
     * The function gets a velocity and sets it to "this" velocity.
     *
     * @param v The velocity which represent the velocity of the ball.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * The function gets a DrawSurface and draws the ball on it.
     *
     * @param surface The DrawSurface which we draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     * The function calls the function moveOneStep for the ball.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * The function moves the ball one step according th the other collidables in the game environment.
     */
    public void moveOneStep() {
        if (this.getX() + this.size > 780 && this.getY() + this.size > 580) {
            this.setPoint(new Point(this.getX() - this.size, this.getY() - this.size));
        }
        if (this.getX() + this.size < 20 && this.getY() + this.size < 20) {
            this.setPoint(new Point(this.getX() + this.size + this.getVelocity().speed(),
                    this.getY() + this.size + this.getVelocity().speed()));
        }
        if (this.getX() + this.size < 20 && this.getY() + this.size > 580) {
            this.setPoint(new Point(this.getX() + this.size + this.getVelocity().speed(),
                    this.getY() - this.size));
        }
        if (this.getX() + this.size < 780 && this.getY() + this.size < 20) {
            this.setPoint(new Point(this.getX() - this.size,
                    this.getY() + this.size + this.getVelocity().speed()));
        }
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(new Line(this.getCenter(),
                (this.getVelocity().applyToPoint(this.point))));
        if (collisionInfo != null) {
            this.setVelocity(collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(),
                    this.getVelocity()));
        }
        this.point = this.getVelocity().applyToPoint(this.point);
    }

    /**
     * The function gets a Game and adds the ball to it.
     *
     * @param g The game which we add the ball to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * The function removes the ball from the sprites list of the game.
     *
     * @param game The game we delete the ball from.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

}