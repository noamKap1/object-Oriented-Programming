//215487695 Noam Kaplinski

import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * The class contains a mains that initialize and runs the game.
 *
 * @author Noam kaplinski
 */
public class Ass6Game {
    /**
     * The function main create a level information list according to the args array and runs the levels.
     *
     * @param args command line argument.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", 800, 600);
        GameFlow gameFlow = new GameFlow(new AnimationRunner(gui, 60), gui.getKeyboardSensor());
        List<LevelInformation> levelInformations = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("1") || args[i].equals("2") || args[i].equals("3") || args[i].equals("4")) {
                count++;
            }
        }
        if (count == 0) {
            levelInformations.add(new FirstLevel());
            levelInformations.add(new SecondLevel());
            levelInformations.add(new ThirdLevel());
            levelInformations.add(new ForthLevel());
        } else {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("1")) {
                    levelInformations.add(new FirstLevel());
                }
                if (args[i].equals("2")) {
                    levelInformations.add(new SecondLevel());
                }
                if (args[i].equals("3")) {
                    levelInformations.add(new ThirdLevel());
                }
                if (args[i].equals("4")) {
                    levelInformations.add(new ForthLevel());
                }
            }
        }
        gameFlow.runLevels(levelInformations);
        gui.close();
    }
}
