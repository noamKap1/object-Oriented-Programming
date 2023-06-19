//215487695 Noam kaplinski

import biuoop.DrawSurface;

import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.Color;

import java.util.Random;

/**
 * The class can build a Game add a sprite, add a collidable, initialize the game and run the game.
 *
 * @author Noam kaplinski
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter counterBlock = new Counter();
    private Counter counterBall = new Counter();
    private Counter score = new Counter();
    private GUI gui;
    private Animation animation;
    private boolean running;
    private AnimationRunner runner;
    private LevelInformation levelInformation;

    /**
     * The function create a new game environment and a new sprite collection.
     */
    public GameLevel() {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
    }

    /**
     * The function create a new game environment and a new sprite collection.
     *
     * @param levelInformation The levelInformation for the game level.
     * @param animationRunner  The animationRunner for the game level.
     */
    public GameLevel(LevelInformation levelInformation, AnimationRunner animationRunner) {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.levelInformation = levelInformation;
        this.runner = animationRunner;
    }

    /**
     * The function create a new game environment and a new sprite collection.
     *
     * @param levelInformation The levelInformation for the game level.
     * @param keyboardSensor   The keyboardSensor for the game level.
     * @param animationRunner  The animationRunner for the game level.
     * @param score            The score we have.
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboardSensor,
                     AnimationRunner animationRunner, Counter score) {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.levelInformation = levelInformation;
        this.runner = animationRunner;
        this.score = score;
    }

    /**
     * The function create a new game environment and a new sprite collection.
     *
     * @param levelInformation The levelInformation for the game level.
     * @param keyboardSensor   The keyboardSensor for the game level.
     * @param animationRunner  The animationRunner for the game level.
     * @param score            The score we have.
     * @param gui              The gui we draw the game level on.
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboardSensor,
                     AnimationRunner animationRunner, Counter score, GUI gui) {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.levelInformation = levelInformation;
        this.runner = animationRunner;
        this.score = score;
        this.gui = gui;
        this.counterBall.increase(this.levelInformation.numberOfBalls());
    }

    /**
     * The function returns the game level gui.
     *
     * @return The game level gui.
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * The function adds a sprite to the sprite collection of the game.
     *
     * @param s The sprite we add to the sprite collection.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * The function adds a Collidable to the game environment of the game.
     *
     * @param c The Collidable we add to the game environment.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * The function returns the game environment of the game.
     *
     * @return GameEnvironment the game environment of the game.
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * The function returns the sprite collection of the game.
     *
     * @return SpriteCollection the sprite collection of the game.
     */
    public SpriteCollection getSprites() {
        return sprites;
    }

    /**
     * The function returns the current score.
     *
     * @return The current score.
     */
    public Counter getScore() {
        return this.score;
    }

    /**
     * The function initialize the game, create the blocks, the paddle and the ball and adds them to the game.
     */
    public void initialize() {
        Block block1 = new Block(new Rectangle(new Point(0, 20), 20, 600), Color.gray);
        Block block2 = new Block(new Rectangle(new Point(0, 20), 800, 20), Color.gray);
        Block block3 = new Block(new Rectangle(new Point(0, 600 - 20), 800, 20), Color.gray);
        Block block4 = new Block(new Rectangle(new Point(800 - 20, 20), 20, 600), Color.gray);
        block1.addToGame(this);
        block2.addToGame(this);
        block3.addToGame(this);
        block4.addToGame(this);
        Random rand = new Random();
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        BallRemover ballRemover = new BallRemover(this, this.counterBall);
        block3.addHitListener(ballRemover);
        BlockRemover blockRemover = new BlockRemover(this, this.counterBlock);
        Block block;
        for (int i = 0; i < this.levelInformation.blocks().size() - 1; i++) {
            block = this.levelInformation.blocks().get(i);
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
            this.counterBlock.increase(1);
        }
        Paddle paddle = new Paddle(this.levelInformation.blocks().get(this.levelInformation.blocks().size() - 1), gui);
        paddle.addToGame(this);
        this.runner = new AnimationRunner(gui, 60);
        this.running = true;
        this.addSprite(this.levelInformation.getBackground());
    }

    /**
     * The function runs the game according to his initialization.
     */
    public void run() {
        this.createBallsOnTopOfPaddle();
        this.runner.run(new CountdownAnimation(2, 3, gui, this.sprites, this));
        this.runner.run(this);
    }

    /**
     * The function returns how many balls left.
     *
     * @return Counter which has how many balls left.
     */
    public Counter getCounterBall() {
        return counterBall;
    }

    /**
     * The function returns how many blocks left.
     *
     * @return Counter which has how many blocks left.
     */
    public Counter getCounterBlock() {
        return counterBlock;
    }

    /**
     * The function returns the level information of the game level.
     *
     * @return The level information of the game level.
     */
    public LevelInformation getLevelInformation() {
        return this.levelInformation;
    }

    /**
     * The function removes the collidable from the collidbles list.
     *
     * @param c The collidable we delete.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * The function removes the collidable from the collidbles list.
     *
     * @param s The collidable we delete.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * The function draws on the draw surface.
     *
     * @param drawSurface The draw surface we draw on.
     */
    public void draw(DrawSurface drawSurface) {
        drawSurface.setColor(Color.BLUE);
        drawSurface.fillRectangle(0, 0, 800, 600);
        drawSurface.setColor(Color.GRAY);
        drawSurface.setColor(Color.RED);
        drawSurface.fillRectangle(0, 0, 800, 20);
        drawSurface.setColor(Color.black);
        drawSurface.drawText(200, 20, "Score: " + this.score.getValue(), 15);
        drawSurface.drawText(450, 20, "Level name: " + this.levelInformation.levelName(), 15);
        this.sprites.drawAllOn(drawSurface);
        gui.show(drawSurface);
    }

    /**
     * The function creates balls on top of the paddle.
     */
    public void createBallsOnTopOfPaddle() {
        Block block3 = new Block(new Rectangle(new Point(0, 600 - 20), 800, 20), Color.gray);
        BallRemover ballRemover = new BallRemover(this, this.counterBall);
        block3.addHitListener(ballRemover);
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(400, 475, 5, Color.RED);
            ball.setVelocity(this.levelInformation.initialBallVelocities().get(i));
            ball.setGameEnvironment(this.environment);
            ball.addToGame(this);
            ball.addHitListener(ballRemover);
        }
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.gui.getKeyboardSensor().isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.gui.getKeyboardSensor(),
                    KeyboardSensor.SPACE_KEY, new PauseScreen(this.gui.getKeyboardSensor(), this.gui)));
        }
        draw(d);
        this.sprites.notifyAllTimePassed();
        if (this.counterBlock.getValue() == 0) {
            this.score.increase(100);
            Sleeper sleeper = new Sleeper();
            this.running = false;
            d = this.gui.getDrawSurface();
            draw(d);
            sleeper.sleepFor(100);
        }
        if (this.counterBall.getValue() == 0) {
            this.running = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}