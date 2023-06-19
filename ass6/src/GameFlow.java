//215487695 Noam Kaplinski

import biuoop.KeyboardSensor;

import java.util.List;

/**
 * The class can create a GameFlow and run the game levels.
 *
 * @author Noam kaplinski
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter score;

    /**
     * The function creates a GameFlow.
     *
     * @param ar The animationRunner for the game flow.
     * @param ks The KeyboardSensor for the game flow.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.keyboardSensor = ks;
        this.animationRunner = ar;
        this.score = new Counter();
    }

    /**
     * The function runs the game levels according to the level information array.
     *
     * @param levels The level information array which contains the information about the levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean indicator = true;
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo,
                    this.keyboardSensor,
                    this.animationRunner, this.score, this.animationRunner.getGui());

            level.initialize();

            while (level.getCounterBlock().getValue() != 0 && level.getCounterBall().getValue() != 0) {
                level.run();
            }

            if (level.getCounterBall().getValue() == 0) {
                this.animationRunner.run(new KeyPressStoppableAnimation(
                        this.animationRunner.getGui().getKeyboardSensor(),
                        keyboardSensor.SPACE_KEY, new YouLoseScreen(this.animationRunner.getGui().getKeyboardSensor(),
                        this.animationRunner.getGui(), this.score)));
                indicator = false;
                break;
            }

        }
        if (indicator) {
            this.animationRunner.run(new KeyPressStoppableAnimation(this.animationRunner.getGui().getKeyboardSensor(),
                    keyboardSensor.SPACE_KEY, new YouWinScreen(this.animationRunner.getGui().getKeyboardSensor(),
                    this.animationRunner.getGui(), this.score)));
        }
    }
}