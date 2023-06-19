//215487695 Noam Kaplinski

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The function creates the forth level.
 *
 * @author Noam kaplinski
 */
public class ForthLevel implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            Velocity velocity = Velocity.fromAngleAndSpeed((int) (180 / (this.numberOfBalls() + 1)) * (i + 1),
                    5);
            velocities.add(velocity);
        }
        return velocities;
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
     * The function returns the name of the level.
     *
     * @return String which contains the name of the level.
     */
    public String levelName() {
        return "hard sporty neighborhood";
    }

    @Override
    public Sprite getBackground() {
        Background b = new Background();
        for (int i = 0; i < 20; i++) {
            b.addText(14 + 38 * i, 82, "\uD83C\uDFE2", 50, Color.cyan);
            b.addText(19 + 38 * i, 120, "\uD83C\uDFD8", 40, Color.GREEN);
            b.addText(19 + 38 * i, 162, "\uD83C\uDFE1", 40, Color.LIGHT_GRAY);
            b.addText(19 + 38 * i, 360, "\uD83D\uDEB4", 40, Color.WHITE);
            b.addText(19 + 38 * i, 394, "⛹", 40, Color.WHITE);
            b.addText(19 + 38 * i, 428, "\uD83C\uDFCB", 40, Color.WHITE);
            b.addText(19 + 38 * i, 474, "\uD83E\uDD3C", 40, Color.WHITE);
        }
        return b;
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Block block;
        Random rand = new Random();
        for (int i = 0; i < this.numberOfBlocksToRemove(); i++) {
            block = new Block(new Rectangle(new Point(20 + 50.667 * i, 200), 50, 30),
                    new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            list.add(block);
        }
        for (int i = 0; i < this.numberOfBlocksToRemove(); i++) {
            block = new Block(new Rectangle(new Point(20 + 50.667 * i, 230), 50, 30),
                    new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            list.add(block);
        }
        for (int i = 0; i < this.numberOfBlocksToRemove(); i++) {
            block = new Block(new Rectangle(new Point(20 + 50.667 * i, 260), 50, 30),
                    new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            list.add(block);
        }
        for (int i = 0; i < this.numberOfBlocksToRemove(); i++) {
            block = new Block(new Rectangle(new Point(20 + 50.667 * i, 290), 50, 30),
                    new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            list.add(block);
        }
        block = new Block(new Rectangle(new Point(370, 500), 60, 15), Color.GREEN);
        list.add(block);
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
