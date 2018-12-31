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

import org.greenrobot.greendao.database.Database;

import ca.lucschulz.dice.green.Colours;
import ca.lucschulz.dice.green.DaoMaster;
import ca.lucschulz.dice.green.DaoSession;


public class MainActivity extends AppCompatActivity {

    private Dice dice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dice.setDieColor(DieColors.WHITE);

        dice = new Dice();

        configureButtons();
        configureDice();

        setDiceVisibility(6);

        dbSetup();
    }

    void dbSetup() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "settingsdb.db");
        Database db = helper.getWritableDb();
        DaoSession session = new DaoMaster(db).newSession();

        Colours colours = new Colours();
        colours.setColour("TRANSPARENT");
        colours.setIsSelected(false);
        session.insert(colours);

        db.close();
    }

    @Override
    public void onResume() {
        super.onResume();
        dice.changeColorOfDice();
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
                launchAboutActivity();
                break;
            case R.id.menu_settings:
                launchSettingsActivity();
                break;
            default:
                break;
        }
        return false;
    }

    private void launchAboutActivity() {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    private void launchSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class);
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

            Die die = new Die(imgView, Dice.getDieColor());
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
