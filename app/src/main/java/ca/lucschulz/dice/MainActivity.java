package ca.lucschulz.dice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Dice dice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice = new Dice();
        configureButtons();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.frament_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                showAboutInfo();
                break;
            default:
                break;
        }
        return false;
    }


    private void showAboutInfo() {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }





    private void configureButtons() {
        Button btnRollDice = findViewById(R.id.btnRollDice);
        btnRollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        ImageView imgDieLeft = findViewById(R.id.img_dieLeft);
        ImageView imgDieRight = findViewById(R.id.img_dieRight);

        dice.rollDice();

        setDieValue(imgDieLeft, dice.getLeftDieValue());
        setDieValue(imgDieRight, dice.getRightDieValue());
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
