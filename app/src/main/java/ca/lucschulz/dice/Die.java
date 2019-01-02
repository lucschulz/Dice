package ca.lucschulz.dice;

import android.view.View;
import android.widget.ImageView;

import java.util.concurrent.ThreadLocalRandom;

import ca.lucschulz.dice.green.Colours;

public class Die {

    private int dieValue;
    private Colours dieColor;
    private ImageView imageView;

    public Die(ImageView imageView, Colours colour) {
        this.imageView = imageView;
        this.dieColor = colour;
        rollDie();
    }

    public void setDieColor(Colours dieColour) {
        this.dieColor = dieColour;
        setDieValue(imageView, dieValue);
    }

    public void rollDie() {
        dieValue = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        setDieValue(imageView, dieValue);
    }

    public boolean isVisible() {
        int visibility = imageView.getVisibility();
        if (visibility == View.VISIBLE) {
            return true;
        }
        else {
            return false;
        }
    }

    public void setVisible(boolean visible) {
        if (visible) {
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.INVISIBLE);
        }

    }

    private void setDieValue(ImageView dieImg, int value) {

        if (this.dieColor.getColour() == "WHITE") {
            if (value == 1) {
                dieImg.setImageResource(R.drawable.die1_white);
            }
            else if (value == 2) {
                dieImg.setImageResource(R.drawable.die2_white);
            }
            else if (value == 3) {
                dieImg.setImageResource(R.drawable.die3_white);
            }
            else if (value == 4) {
                dieImg.setImageResource(R.drawable.die4_white);
            }
            else if (value == 5) {
                dieImg.setImageResource(R.drawable.die5_white);
            }
            else if (value == 6) {
                dieImg.setImageResource(R.drawable.die6_white);
            }
        }

        else if (this.dieColor.getColour() == "TRANSPARENT") {
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
}
