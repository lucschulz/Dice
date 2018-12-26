package ca.lucschulz.dice;

import java.util.concurrent.ThreadLocalRandom;

public class Die {

    private int dieValue;

    public Die() {
        rollDie();
    }

    public void rollDie() {
        dieValue = ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }

    public int getDieValue() {
        return dieValue;
    }

    public void setDieValue(int dieValue) {
        this.dieValue = dieValue;
    }
}
