package ca.lucschulz.dice;


import java.util.ArrayList;
import java.util.List;

public class Dice {

    private List<Die> diceList = new ArrayList<>();
    private int numberOfDiceVisible;

    public Dice() {}

    public void rollDice() {
        for (Die die : diceList) {
            die.rollDie();
        }
    }

    public void setDiceVisibility(int numberOfDiceVisible) {
        this.numberOfDiceVisible = numberOfDiceVisible;
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
