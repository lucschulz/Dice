package ca.lucschulz.dice;

public class Dice {

    private Die leftDie;
    private Die rightDie;


    public Dice() {
        leftDie = new Die();
        rightDie = new Die();
    }

    public void rollDice() {
        leftDie.rollDie();
        rightDie.rollDie();
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
