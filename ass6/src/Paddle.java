//215487695 Noam Kaplinski

import biuoop.DrawSurface;

import biuoop.GUI;

import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The class can create a paddle, move him left and right, draw him on a drawing surface and return
 * the Block he contains.
 *
 * @author Noam kaplinski
 */
public class Paddle implements Sprite, Collidable {
    private KeyboardSensor keyboard;
    private Block block;

    /**
     * The function gets a block and a keyboard and returns the paddle.
     *
     * @param b   The block which the paddle contains.
     * @param gui The keyboard which affects how to paddle move.
     */
    public Paddle(Block b, GUI gui) {
        this.keyboard = gui.getKeyboardSensor();
        this.block = b;
    }

    /**
     * The function moves the paddle left.
     */
    public void moveLeft() {
        if (this.block.getCollisionRectangle().getUpperLeft().getX() - 5 <= 25) {
            this.block = new Block(new Rectangle(new Point(25,
                    this.block.getCollisionRectangle().getUpperLeft().getY()), this.block.getCollisionRectangle().
                    getWidth(), this.block.getCollisionRectangle().getHeight()), this.block.getColor());
        }
        this.block.getCollisionRectangle().setUpperLeft(new Point(this.block.getCollisionRectangle().
                getUpperLeft().getX() - 5, this.block.getCollisionRectangle().getUpperLeft().getY()));
    }

    /**
     * The function moves the paddle right.
     */
    public void moveRight() {
        if (this.block.getCollisionRectangle().getUpperLeft().getX() + 5
                + this.block.getCollisionRectangle().getWidth() >= 775) {
            this.block = new Block(new Rectangle(new Point(775 - this.block.getCollisionRectangle().getWidth(),
                    this.block.getCollisionRectangle().getUpperLeft().getY()),
                    this.block.getCollisionRectangle().getWidth(),
                    this.block.getCollisionRectangle().getHeight()), this.block.getColor());
        }
        this.block.getCollisionRectangle().setUpperLeft(new Point(this.block.getCollisionRectangle().
                getUpperLeft().getX() + 5, this.block.getCollisionRectangle().getUpperLeft().getY()));
    }

    /**
     * The function calls the moving functions according to what is pressed on the keyboard
     * and notify the paddle that time has passed.
     */
    public void timePassed() {
        if (this.keyboard.isPressed(this.keyboard.RIGHT_KEY)) {
            this.moveRight();
        }
        if (this.keyboard.isPressed(this.keyboard.LEFT_KEY)) {
            this.moveLeft();
        }
    }

    /**
     * The function draws the paddle on the drawing surface.
     *
     * @param d The drawing surface which we draw the paddle on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.GREEN);
        this.block.drawOn(d);
    }

    /**
     * The function returns the block which the paddle contain.
     *
     * @return The block which the paddle contain.
     */
    public Rectangle getCollisionRectangle() {
        return this.block.getCollisionRectangle();
    }

    /**
     * The function returns the velocity of the ball after he hits the paddle.
     *
     * @param ball            The ball which collide with the paddle.
     * @param collisionPoint  The point which represent the collision point with the block.
     * @param currentVelocity The velocity of the ball before he hits the block.
     * @return The velocity of the ball after he hits the paddle.
     */
    public Velocity hit(Ball ball, Point collisionPoint, Velocity currentVelocity) {
        Velocity velocity = currentVelocity;
        double regionWidth = this.block.getCollisionRectangle().getWidth() / 5;
        double x = this.block.getCollisionRectangle().getUpperLeft().getX();
        if (x <= collisionPoint.getX() && collisionPoint.getX() <= x + regionWidth) {
            velocity = Velocity.fromAngleAndSpeed(150, currentVelocity.speed());
        } else if (x + regionWidth <= collisionPoint.getX() && collisionPoint.getX() <= x + 2 * regionWidth) {
            velocity = Velocity.fromAngleAndSpeed(120, currentVelocity.speed());
        } else if (x + 2 * regionWidth <= collisionPoint.getX() && collisionPoint.getX() <= x + 3 * regionWidth) {
            velocity = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        } else if (x + 3 * regionWidth <= collisionPoint.getX() && collisionPoint.getX() <= x + 4 * regionWidth) {
            velocity = Velocity.fromAngleAndSpeed(60, currentVelocity.speed());
        } else if (x + 4 * regionWidth <= collisionPoint.getX() && collisionPoint.getX() <= x + 5 * regionWidth) {
            velocity = Velocity.fromAngleAndSpeed(30, currentVelocity.speed());
        }
        return velocity;
    }

    /**
     * The function adds the paddle to the game.
     *
     * @param g The game which we add the paddle to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}