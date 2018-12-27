package ca.lucschulz.dice;

import java.util.ArrayList;
import java.util.List;

public class Dice {

    private Die leftDie;
    private Die rightDie;

    private List<Die> dice;


    public Dice() {
        dice = new ArrayList<Die>();

        leftDie = new Die();
        rightDie = new Die();
    }

    public void rollDice() {
        leftDie.rollDie();
        rightDie.rollDie();
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

    public Die getRightDie() {
        return rightDie;
    }

    public void setRightDie(Die rightDie) {
        this.rightDie = rightDie;
    }

    public int getRightDieValue() {
        return rightDie.getDieValue();
    }

    public Die getLeftDie() {
        return leftDie;
    }

    public void setLeftDie(Die leftDie) {
        this.leftDie = leftDie;
    }

    public int getLeftDieValue() {
        return leftDie.getDieValue();
    }
}
