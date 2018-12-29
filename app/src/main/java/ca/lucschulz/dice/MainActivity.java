package ca.lucschulz.dice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
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
        getMenuInflater().inflate(R.menu.frament_menu, menu);
        return true;
    }


    //region MENU
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                startNewActivity(About.class);
                break;
            case R.id.menu_settings:
                startNewActivity(SettingsActivity.class);
                break;
            default:
                break;
        }
        return false;
    }

    private void startNewActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
    //endregion






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

            Die die = new Die(imgView, diceColours.white);
            die.setVisible(true);
            dice.addDieToArray(die);
            dice.rollDice();
        }
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
