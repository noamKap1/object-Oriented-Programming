//215487695 Noam Kaplinski

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The function creates the first level.
 *
 * @author Noam kaplinski
 */
public class FirstLevel implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        list.add(Velocity.fromAngleAndSpeed(90, 5));
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
     * The function returns the name of the level.
     *
     * @return String which contains the name of the level.
     */
    public String levelName() {
        return "easy card game";
    }

    @Override
    public Sprite getBackground() {
        Background b = new Background();
        b.addRectangle(110, 40, 100, 150, Color.WHITE);
        b.addRectangle(270, 40, 100, 150, Color.WHITE);
        b.addRectangle(430, 40, 100, 150, Color.WHITE);
        b.addRectangle(590, 40, 100, 150, Color.WHITE);
        b.addText(145, 130, "\u2660", 25, Color.black);
        b.addText(155, 130, "\u2660", 25, Color.black);
        b.addText(150, 120, "\u2660", 25, Color.black);
        b.addText(135, 115, "\u2660", 25, Color.black);
        b.addText(140, 115, "\u2660", 25, Color.black);
        b.addText(145, 115, "\u2660", 25, Color.black);
        b.addText(150, 115, "\u2660", 25, Color.black);
        b.addText(155, 115, "\u2660", 25, Color.black);
        b.addText(160, 115, "\u2660", 25, Color.black);
        b.addText(165, 115, "\u2660", 25, Color.black);
        b.addText(140, 110, "\u2660", 25, Color.black);
        b.addText(145, 110, "\u2660", 25, Color.black);
        b.addText(150, 110, "\u2660", 25, Color.black);
        b.addText(155, 110, "\u2660", 25, Color.black);
        b.addText(160, 110, "\u2660", 25, Color.black);
        b.addText(145, 105, "\u2660", 25, Color.black);
        b.addText(150, 105, "\u2660", 25, Color.black);
        b.addText(155, 105, "\u2660", 25, Color.black);
        b.addText(150, 100, "\u2660", 25, Color.black);
        b.addText(310, 130, "\u2665", 15, Color.red);
        b.addText(305, 125, "\u2665", 15, Color.red);
        b.addText(310, 125, "\u2665", 15, Color.red);
        b.addText(315, 125, "\u2665", 15, Color.red);
        b.addText(300, 120, "\u2665", 15, Color.red);
        b.addText(305, 120, "\u2665", 15, Color.red);
        b.addText(310, 120, "\u2665", 15, Color.red);
        b.addText(315, 120, "\u2665", 15, Color.red);
        b.addText(320, 120, "\u2665", 15, Color.red);
        b.addText(295, 115, "\u2665", 15, Color.red);
        b.addText(300, 115, "\u2665", 15, Color.red);
        b.addText(305, 115, "\u2665", 15, Color.red);
        b.addText(310, 115, "\u2665", 15, Color.red);
        b.addText(315, 115, "\u2665", 15, Color.red);
        b.addText(320, 115, "\u2665", 15, Color.red);
        b.addText(325, 115, "\u2665", 15, Color.red);
        b.addText(295, 110, "\u2665", 15, Color.red);
        b.addText(300, 110, "\u2665", 15, Color.red);
        b.addText(305, 110, "\u2665", 15, Color.red);
        b.addText(315, 110, "\u2665", 15, Color.red);
        b.addText(320, 110, "\u2665", 15, Color.red);
        b.addText(325, 110, "\u2665", 15, Color.red);
        b.addText(300, 108, "\u2665", 15, Color.red);
        b.addText(320, 108, "\u2665", 15, Color.red);
        b.addText(470, 130, "\u2666", 25, Color.red);
        b.addText(470, 100, "\u2666", 25, Color.red);
        b.addText(468, 125, "\u2666", 25, Color.red);
        b.addText(468, 105, "\u2666", 25, Color.red);
        b.addText(472, 125, "\u2666", 25, Color.red);
        b.addText(472, 105, "\u2666", 25, Color.red);
        b.addText(465, 120, "\u2666", 25, Color.red);
        b.addText(465, 110, "\u2666", 25, Color.red);
        b.addText(470, 120, "\u2666", 25, Color.red);
        b.addText(470, 110, "\u2666", 25, Color.red);
        b.addText(475, 120, "\u2666", 25, Color.red);
        b.addText(475, 110, "\u2666", 25, Color.red);
        b.addText(463, 115, "\u2666", 25, Color.red);
        b.addText(465, 115, "\u2666", 25, Color.red);
        b.addText(470, 115, "\u2666", 25, Color.red);
        b.addText(477, 115, "\u2666", 25, Color.red);
        Random random = new Random();
        b.addText(620, 125, "\u2663", 60, Color.black);
        b.addText(380, 135, "\uD83D\uDC51", 40, Color.black);
        b.addText(662, 250, "\uD83C\uDFB0", 40, new Color(random.nextInt(255),
                random.nextInt(255), random.nextInt(255)));
        b.addText(742, 350, "\uD83C\uDFB0", 40, new Color(random.nextInt(255),
                random.nextInt(255), random.nextInt(255)));
        b.addText(742, 250, "\uD83C\uDFB0", 40, new Color(random.nextInt(255),
                random.nextInt(255), random.nextInt(255)));
        for (int i = 0; i < 9; i++) {
            b.addText(22 + i * 80, 350, "\uD83C\uDFB0", 40, new Color(random.nextInt(255),
                    random.nextInt(255), random.nextInt(255)));
            b.addText(62 + i * 80, 300, "\uD83C\uDFB0", 40, new Color(random.nextInt(255),
                    random.nextInt(255), random.nextInt(255)));
            b.addText(22 + i * 80, 250, "\uD83C\uDFB0", 40, new Color(random.nextInt(255),
                    random.nextInt(255), random.nextInt(255)));
        }
        for (int i = 0; i < 19; i++) {
            b.addText(20 + 40 * i, 400, "\uD83D\uDCB5", 40, Color.green);
            b.addText(20 + 40 * i, 430, "\uD83D\uDC8E", 40, Color.cyan);
            b.addText(20 + 40 * i, 465, "\uD83D\uDCB0", 40, Color.yellow);

        }
        return b;
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Block block = new Block(new Rectangle(new Point(380, 100), 40, 40), Color.RED);
        list.add(block);
        block = new Block(new Rectangle(new Point(370, 500), 60, 15), Color.GREEN);
        list.add(block);
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
