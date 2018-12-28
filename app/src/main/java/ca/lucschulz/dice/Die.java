package ca.lucschulz.dice;

import android.widget.ImageView;

import java.util.concurrent.ThreadLocalRandom;

public class Die {

    private int dieValue;
    private boolean isVisible;
    private ImageView imageView;

    public Die(ImageView imageView) {
        this.imageView = imageView;
        rollDie();
    }

    public void rollDie() {
        dieValue = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        setDieValue(imageView, dieValue);
    }

    public int getDieValue() {
        return dieValue;
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

    private void setDieValue(ImageView dieImg, int value) {
        if (value == 1) {
            dieImg.setImageResource(R.drawable.die1);
        }
        else if (value == 2) {
            dieImg.setImageResource(R.drawable.die2);
        }
        else if (value == 3) {
            dieImg.setImageResource(R.drawable.die3);
        }
        else if (value == 4) {
            dieImg.setImageResource(R.drawable.die4);
        }
        else if (value == 5) {
            dieImg.setImageResource(R.drawable.die5);
        }
        else if (value == 6) {
            dieImg.setImageResource(R.drawable.die6);
        }
    }
}
