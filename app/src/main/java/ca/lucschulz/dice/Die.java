package ca.lucschulz.dice;

import android.widget.ImageView;

import java.util.concurrent.ThreadLocalRandom;

public class Die {

    private int dieValue;
    private boolean isVisible;
    private ImageView imageView;

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

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
