package com.example.android.spiritanimal;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    public void seeTheResult(View view) {
        RadioGroup question1 = findViewById(R.id.question1);
        int answer1 = question1.getCheckedRadioButtonId();
        RadioGroup question2 = findViewById(R.id.question2);
        int answer2 = question2.getCheckedRadioButtonId();
        RadioGroup question3 = findViewById(R.id.question3);
        int answer3 = question3.getCheckedRadioButtonId();
        RadioGroup question4 = findViewById(R.id.question4);
        int answer4 = question4.getCheckedRadioButtonId();
        RadioGroup question5 = findViewById(R.id.question5);
        int answer5 = question5.getCheckedRadioButtonId();

        CheckBox answer6_1 = findViewById(R.id.answer6_1);
        CheckBox answer6_2 = findViewById(R.id.answer6_2);
        CheckBox answer6_3 = findViewById(R.id.answer6_3);

        int variant1 = 0;
        int variant2 = 0;
        int variant3 = 0;

        boolean err = false;

        switch (answer1) {
            case R.id.answer1_1:
                variant1++;
                break;
            case R.id.answer1_2:
                variant2++;
                break;
            case R.id.answer1_3:
                variant3++;
                break;
            default:
                err = true;

        }
        switch (answer2) {
            case R.id.answer2_1:
                variant1++;
                break;
            case R.id.answer2_2:
                variant2++;
                break;
            case R.id.answer2_3:
                variant3++;
                break;
            default:
                err = true;
        }
        switch (answer3) {
            case R.id.answer3_1:
                variant1++;
                break;
            case R.id.answer3_2:
                variant2++;
                break;
            case R.id.answer3_3:
                variant3++;
                break;
            default:
                err = true;
        }
        switch (answer4) {
            case R.id.answer4_1:
                variant1++;
                break;
            case R.id.answer4_2:
                variant2++;
                break;
            case R.id.answer4_3:
                variant3++;
                break;
            default:
                err = true;
        }
        switch (answer5) {
            case R.id.answer5_1:
                variant1++;
                break;
            case R.id.answer5_2:
                variant2++;
                break;
            case R.id.answer5_3:
                variant3++;
                break;
            default:
                err = true;
        }

        if (err) {
            Toast.makeText(this, getText(R.string.err_questions), Toast.LENGTH_SHORT).show();
            return;
        }

        if (answer6_1.isChecked()) variant1++;
        if (answer6_2.isChecked()) variant2++;
        if (answer6_3.isChecked()) variant3++;

        Intent resultActivity = new Intent(this, ResultActivity.class);

        Log.v("quiz", "v1: " + variant1);
        Log.v("quiz", "v2: " + variant2);
        Log.v("quiz", "v3: " + variant3);

        int max = Math.max(variant1, Math.max(variant2, variant3));

        Log.v("quiz", "max: " + max);

        if (variant1 >= max) {
            resultActivity.putExtra("variant", 1);
        } else if (variant2 >= max) {
            resultActivity.putExtra("variant", 2);
        } else {
            resultActivity.putExtra("variant", 3);
        }
        Intent thisActivity = getIntent();
        String name = thisActivity.getStringExtra("name");
        resultActivity.putExtra("name", name);
        startActivity(resultActivity);
    }
}
