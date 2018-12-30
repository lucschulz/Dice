package ca.lucschulz.dice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dice implements Serializable {

    private List<Die> diceList = new ArrayList<>();
    private static DieColors dieColor;



    public Dice() {}

    public void rollDice() {
        for (Die die : diceList) {
            die.rollDie();
        }
    }

    /**
     * Sets the color of the dice to the one that was specified in setDieColor()
     */
    public void changeColorOfDice() {
        for (Die die : diceList) {
            die.setDieColor(this.dieColor);
        }
    }

    /**
     * Sets the color of the dice.
     * @param dieColor the color to change the dice to
     */
    public static void setDieColor(DieColors dieColor) {
        Dice.dieColor = dieColor;
    }

    /*
    * Returns the currently set color for the dice.
    */
    public static DieColors getDieColor() {
        return dieColor;
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
