package com.android.rexben.rexquiz;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declaring checkboxes as fields so that it will can be accessed by the @submit method
    private CheckBox checkBox, checkBox2, checkBox3;

    /* Declaring the scores of each questions as field so that it
    *  be accessed by the @subit method
    *  @mScore is for the checkboxes
    *  @rScore is for the RadioGroup
    *  @rBScore is for the RadiGroup2
    *  @eScore is for the Editext
     *  @edScore is for the Editext2
     */
    private int mScore = 0;
    private int rScore = 0;
    private int rbScore = 0;
    private int eScore = 0;
    private int edScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //casting Views into resource IDs
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);


        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.radioButton:
                        // Adds 1 to the rScore when it is checked
                        rScore++;
                        break;
                    case R.id.radioButton2:
                        // Do nothing
                        break;
                    case R.id.radioButton3:
                        //Do nothing
                        break;
                }

            }
        });
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radioGrp);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.radioButton4:
                        //Do nothing
                        break;
                    case R.id.radioButton5:
                        //Do nothing
                        break;
                    case R.id.radioButton6:
                        //Adds 1 to the rbScore when it is checked
                        rbScore++;
                }
            }
        });


    }


    // When clicked it displays a toast message showing the total score of the user
    public void Submit(View view) {


        // When checkBox, checkBox2 and checkBoxes are checked
        //Add 1 to mScore
        if (checkBox.isChecked() && checkBox2.isChecked() && checkBox3.isChecked()) {

            mScore++;
        } else {

            //Do nothing
        }

        //Get user's input and casting user's input into String and remove excess white spaces
        String answer = ((EditText) findViewById(R.id.editText)).getText().toString().trim();

        //Correct answer
        String correctAnswer = getString(R.string.truee);
        //If the user input is equal to the correct answer
        //Add 1 to eScore
        if (answer.equalsIgnoreCase(correctAnswer)) {
            eScore++;
        } else {

            //Do nothing

        }


        //Get user's input and casting user's input into String and remove excess white spaces
        String answer2 = ((EditText) findViewById(R.id.editText2)).getText().toString().trim();

        //Correct answer
        String correctAnswer2 = getString(R.string.irina_blok);

        if (answer2.equalsIgnoreCase(correctAnswer2)) {
            //If the user input is equal to the correct answer
            //Add 1 to eScore
            edScore++;
        } else {
            //Do nothing
        }


        //Add the total scores together and cast into the variable @totalScore
        int totalScore = mScore + eScore + rScore + edScore + rbScore;

        //Display a toast message showing the total score gotten by the user
        Toast.makeText(MainActivity.this, "Total Score: " + totalScore +"/5" + "\n Thank You, Udacity", Toast.LENGTH_LONG).show();


    }

}