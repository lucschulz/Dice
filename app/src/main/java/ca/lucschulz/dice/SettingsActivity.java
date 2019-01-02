package ca.lucschulz.dice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import ca.lucschulz.dice.green.Colours;

public class SettingsActivity extends AppCompatActivity {

    private RadioGroup radioGroupColors;
    private RadioButton radioSelectedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setColorTagsOnRadioButtons();

        configureButtons();
    }


    /*
    * Assigns a unique tag to each radio button to match it with a unique color.
    */
    private void setColorTagsOnRadioButtons() {
        RadioButton btnWhite = findViewById(R.id.radioWhite);
        RadioButton btnTransparent = findViewById(R.id.radioTransparent);

        btnWhite.setTag(Dice.getDieColourWhiteName());
        btnTransparent.setTag(Dice.getDieColourTransparentName());
    }


    private void configureButtons() {
        Button btnChangeColor = findViewById(R.id.btnChangeColor);
        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveColorChange();
            }
        });
    }


    private void saveColorChange() {
        Colours die = new Colours();
        die.setColour(getSelectedColor());
        Dice.setDieColour(die);

        finish();
    }


    private String getSelectedColor() {
        radioGroupColors = findViewById(R.id.radioGroupColors);
        int selectedColorId = radioGroupColors.getCheckedRadioButtonId();

        radioSelectedColor = findViewById(selectedColorId);
        return (String)radioSelectedColor.getTag();
    }
}
