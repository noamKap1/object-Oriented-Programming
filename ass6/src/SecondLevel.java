//215487695 Noam Kaplinski

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The function creates the second level.
 *
 * @author Noam kaplinski
 */
public class SecondLevel implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            Velocity velocity = Velocity.fromAngleAndSpeed((int) (180 / (this.numberOfBalls() + 1)) * (i + 1),
                    5);
            list.add(velocity);
        }
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 0;
    }

    @Override
    public int paddleWidth() {
        return 0;
    }

    /**
     * The function returns the level name.
     *
     * @return String which is the level name.
     */
    public String levelName() {
        return "easy proud israeli";
    }

    @Override
    public Sprite getBackground() {
        Background b = new Background();
        for (int i = 0; i < this.numberOfBlocksToRemove(); i++) {
            b.addText(45 + i * 76, 330, "\u2721", 40, Color.RED);
            b.addText(35 + i * 76, 250, "\uD83D\uDD4E", 40, Color.YELLOW);
        }
        b.addText(354, 160, "\uD83D\uDC93", 100, Color.red);

        return b;
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Block block;
        for (int i = 0; i < this.numberOfBlocksToRemove(); i++) {
            block = new Block(new Rectangle(new Point(20 + 76 * i, 300), 76, 40), Color.white);
            list.add(block);
        }
        block = new Block(new Rectangle(new Point(100, 500), 600, 15), Color.GREEN);
        list.add(block);
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 10;
    }
}
