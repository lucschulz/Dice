package ca.lucschulz.dice;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Dice dice;
    private List<ImageView> dieImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dieImages = new ArrayList<ImageView>();
        dice = new Dice();
        configureButtons();
        configureDice();
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


    private void configureDice() {
        for(int i = 0; i < 6; i++){
            String imgId = "img_die" + i;
            int imageResourceId = getResources().getIdentifier(imgId, "id", getPackageName());
            ImageView imgView = findViewById(imageResourceId);

            Die die = new Die();
            die.setVisible(true);
            die.setImageView(imgView);
            dice.addDie(die);
        }
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

        FloatingActionButton btnAddDie = findViewById(R.id.btn_AddDie);
        btnAddDie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDie();
            }
        });

        FloatingActionButton btnRemoveDie = findViewById(R.id.btnRemoveDie);
        btnRemoveDie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeDie();
            }
        });
    }




    // Adds a die up to a maximum of six.
    private void addDie() {
        ImageView imgDieLeft2 = findViewById(R.id.img_die2);
        imgDieLeft2.setVisibility(View.VISIBLE);

        if (dice.countActiveDice() < 6) {
            Die die = new Die();
            dice.addDie(die);
        }
    }


    // Remove the last die in the list.
    private void removeDie() {
        int activeDice = dice.countActiveDice();
        dice.removeDie(activeDice - 1);
    }




    private void rollDice() {
        ImageView imgDieLeft = findViewById(R.id.img_die1);
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
