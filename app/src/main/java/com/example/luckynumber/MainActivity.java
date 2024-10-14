package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finding views by their IDs
        TextView welcomeText = findViewById(R.id.welcome_text);
        EditText nameEditText = findViewById(R.id.name_edit_text);
        Button wishMeLuckButton = findViewById(R.id.wish_me_luck_button);

        // Setting welcome message
        welcomeText.setText("Welcome to Lucky Number");

        // Setting onClickListener for the button
        wishMeLuckButton.setOnClickListener(view -> {
            // Getting username from EditText
            String username = nameEditText.getText().toString();

            // to Check if the username is not empty
            if (!username.isEmpty()) {
                // Generating a random number
                int randomNumber = new Random().nextInt(900); // Random number between 0 and 900

                // Creating an Intent to start the SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("USERNAME", username);
                intent.putExtra("LUCKY_NUMBER", randomNumber);

                // Starting SecondActivity
                startActivity(intent);
            } else {
                // To Show error if no name is entered
                nameEditText.setError("Please enter your name");
            }
        });
    }
}
