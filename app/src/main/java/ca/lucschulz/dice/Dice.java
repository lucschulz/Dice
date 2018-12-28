package ca.lucschulz.dice;

import java.util.ArrayList;
import java.util.List;

public class Dice {

    private List<Die> dice;


    public Dice() {
        dice = new ArrayList<Die>();
    }

    public void rollDice() {
        for (Die die : dice) {
            die.rollDie();
        }
    }

    public void addDie(Die die) {
        dice.add(die);
    }

    public void removeDie() {
        dice.remove(0);
        // TODO method should remove a random die out of those in the List.
    }

    public void removeDie(int index) {
        dice.remove(index);
    }

    public int countActiveDice() {
        return dice.size();
    }
}
