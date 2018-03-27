package com.example.android.spiritanimal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTest(View view) {
        EditText nameInput = findViewById(R.id.nameInput);
        String name = nameInput.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(this, getText(R.string.err_name), Toast.LENGTH_SHORT).show();
            return;
        }
        Intent quizActivity = new Intent(this, QuizActivity.class);
        quizActivity.putExtra("name", name);
        startActivity(quizActivity);
    }

}
