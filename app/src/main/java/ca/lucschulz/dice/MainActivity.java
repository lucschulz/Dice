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

public class MainActivity extends AppCompatActivity {

    private Dice dice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice = new Dice();

        configureButtons();
        configureDice();

        setDiceVisibility(2);
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

    private void setDiceVisibility(int numberOfDiceVisible) {
        dice.setDiceVisibility(numberOfDiceVisible);
    }

    // Adds a die up to a maximum of six.
    private void makeNextDieVisible() {
        dice.makeNextDieVisible();
    }

    // Remove the last die in the list.
    private void makeLastDieInvisible() {
        dice.makeLastDieInvisible();
    }



    private void configureDice() {
        for(int i = 1; i <= 6; i++){
            String imgId = "img_die" + i;
            int imageResourceId = getResources().getIdentifier(imgId, "id", getPackageName());
            ImageView imgView = findViewById(imageResourceId);

            Die die = new Die(imgView);
            die.setVisible(true);
            dice.addDieToArray(die);
            dice.rollDice();
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
                makeNextDieVisible();
            }
        });

        FloatingActionButton btnRemoveDie = findViewById(R.id.btnRemoveDie);
        btnRemoveDie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeLastDieInvisible();
            }
        });
    }







    private void rollDice() {
        dice.rollDice();
    }
}
