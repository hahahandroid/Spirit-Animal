package com.example.android.spiritanimal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView congrats = findViewById(R.id.congrats);
        ImageView picture = findViewById(R.id.picture);
        TextView message = findViewById(R.id.message);

        Intent thisActivity = getIntent();

        String name = thisActivity.getStringExtra("name");
        congrats.setText(getString(R.string.congratulation, name));

        int variant = thisActivity.getIntExtra("variant", 0);
        switch (variant) {
            case 1:
                picture.setImageResource(R.drawable.tiger);
                message.setText(getString(R.string.message, getString(R.string.tiger)));
                break;
            case 2:
                picture.setImageResource(R.drawable.owl);
                message.setText(getString(R.string.message, getString(R.string.owl)));
                break;
            case 3:
                picture.setImageResource(R.drawable.sloth);
                message.setText(getString(R.string.message, getString(R.string.sloth)));
                break;
        }

    }

    public void startAgain(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}
