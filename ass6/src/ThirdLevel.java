//215487695 Noam Kaplinski

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The function creates the third level.
 *
 * @author Noam kaplinski
 */
public class ThirdLevel implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 2;
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
        return "hard amusement park";
    }

    @Override
    public Sprite getBackground() {
        Background b = new Background();
        for (int i = 0; i < 10; i++) {
            b.addText(35 + i * 76, 80, "\uD83C\uDF87", 40, Color.YELLOW);
            b.addText(35 + i * 76, 130, "\uD83C\uDF87", 40, Color.YELLOW);
            b.addText(35 + i * 76, 350, "\uD83C\uDF8A", 40, Color.PINK);
        }
        b.addText(150, 450, "\uD83C\uDFA1", 100, Color.MAGENTA);
        b.addText(350, 450, "\uD83C\uDFA2", 100, Color.MAGENTA);
        b.addText(550, 450, "\uD83C\uDFA0", 100, Color.MAGENTA);
        return b;
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Point point = new Point(800 - 60, 150);
        Color color;
        Block block;
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
            for (int j = 12 - i; j > 0; j--) {
                block = new Block(new Rectangle(point, 40, 20), color);
                list.add(block);
                point = new Point(point.getX() - 40, point.getY());
            }
            point = new Point(800 - 60, point.getY() + 20);
        }
        block = new Block(new Rectangle(new Point(370, 500), 60, 15), Color.GREEN);
        list.add(block);
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
}
