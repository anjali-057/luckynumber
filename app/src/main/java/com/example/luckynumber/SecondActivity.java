package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Retrieving the username and lucky number from the intent
        String username = getIntent().getStringExtra("USERNAME");
        int luckyNumber = getIntent().getIntExtra("LUCKY_NUMBER", 0);

        // Setting the username in the TextView
        TextView usernameText = findViewById(R.id.username_text);
        usernameText.setText(username + "'s Lucky Number:");

        // Setting the lucky number in the TextView
        TextView luckyNumberText = findViewById(R.id.lucky_number_text);
        luckyNumberText.setText(String.valueOf(luckyNumber));

        // Setting up the share button to share the lucky number
        Button shareButton = findViewById(R.id.share_button);
        shareButton.setOnClickListener(view -> {
            String shareText = username + "'s lucky number is " + luckyNumber;
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, shareText);
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, "Share via"));
        });
    }
}
