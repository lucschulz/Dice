package ca.lucschulz.dice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ca.lucschulz.dice.green.Colours;

public class Dice implements Serializable {

    private List<Die> diceList = new ArrayList<>();
    private static Colours dieColour;
    private static String DIE_COLOUR_WHITE_NAME = "WHITE";
    private static String DIE_COLOUR_TRANSPARENT_NAME = "TRANSPARENT";


    public Dice() {}

    public void rollDice() {
        for (Die die : diceList) {
            die.rollDie();
        }
    }

    // Changes all dice to the colour that has been set.
    public void changeColorOfDice() {
        for (Die die : diceList) {
            die.setDieColor(this.dieColour);
        }
    }

    public static void setDieColour(Colours dieColour) {
        Dice.dieColour = dieColour;
    }

    public static Colours getDieColour() {
        return dieColour;
    }


    public static String getDieColourWhiteName() {
        return DIE_COLOUR_WHITE_NAME;
    }

    public static String getDieColourTransparentName() {
        return DIE_COLOUR_TRANSPARENT_NAME;
    }

    public static void setDieColourWhiteName(String dieColourWhiteName) {
        DIE_COLOUR_WHITE_NAME = dieColourWhiteName;
    }

    public static void setDieColourTransparentName(String dieColourTransparentName) {
        DIE_COLOUR_TRANSPARENT_NAME = dieColourTransparentName;
    }

    public void setDiceVisibility(int numberOfDiceVisible) {
        Die[] dice = diceList.toArray(new Die[diceList.size()]);

        for (Die die : dice) {
            die.setVisible(false);
        }

        for (int i = 0; i < numberOfDiceVisible; i++) {
            Die die = dice[i];
            die.setVisible(true);
        }
    }

    public void makeLastDieInvisible() {
        List<Die> list = new ArrayList<>();

        for (Die die : diceList) {
            if (die.isVisible()) {
                list.add(die);
            }
        }

        if (list.size() > 0) {
            list.get(list.size() - 1).setVisible(false);
        }
    }

    public void makeNextDieVisible() {
        List<Die> list = new ArrayList<>();

        for (Die die : diceList) {
            if (die.isVisible() == false) {
                list.add(die);
            }
        }

        if (list.size() > 0) {
            list.get(0).setVisible(true);
        }
    }

    public void addDieToArray(Die die) {
        diceList.add(die);
    }
}
