package ca.lucschulz.dice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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

        btnWhite.setTag(DieColors.WHITE);
        btnTransparent.setTag(DieColors.TRANSPARENT);
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
        DieColors dieColor = getSelectedColor();
        Dice.setDieColor(dieColor);

        finish();
    }


    private DieColors getSelectedColor() {
        radioGroupColors = findViewById(R.id.radioGroupColors);
        int selectedColorId = radioGroupColors.getCheckedRadioButtonId();

        radioSelectedColor = findViewById(selectedColorId);
        return (DieColors)radioSelectedColor.getTag();
    }
}
