package com.example.tfar;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int clickCount = 0;
    private RelativeLayout mainLayout;
    private RelativeLayout mainLayout2;
    private RelativeLayout plusButtonLayout;
    private MediaPlayer mediaPlayer;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        mainLayout.setVisibility(View.INVISIBLE);
        mainLayout2 = findViewById(R.id.mainLayout1);
        mainLayout2.setVisibility(View.INVISIBLE);

        plusButtonLayout = findViewById(R.id.plusButtonLayout);
        plusButtonLayout.setVisibility(View.VISIBLE);
        editText = findViewById(R.id.editText1);

        mediaPlayer = MediaPlayer.create(this, R.raw.custon_sound);
        Button plusButton = findViewById(R.id.plusButton);
        Button submit = findViewById(R.id.submitbutton);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;

                if (clickCount == 1) {
                    showCreativeToast();
                } else if (clickCount == 7) {
                    // Switch to the main layout
                    mainLayout.setVisibility(View.VISIBLE);
                    mainLayout2.setVisibility(View.VISIBLE);
                    plusButtonLayout.setVisibility(View.GONE);
                    playCustomSound();
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the EditText value is "7"
                if (editText.getText().toString().trim().equals("7")) {
                    // Show success toast
                    showSuccessToast();
                    // Hide the keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                else{
                    showFailureToast();
                }
            }
        });

        Button submit2 = findViewById(R.id.submitbutton2);
        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the EditText value is exactly 7 characters
                EditText editText2 = findViewById(R.id.editText2);
                String text = editText2.getText().toString().trim();
                if (text.length() == 7) {
                    // Show success toast
                    showSuccessToast();
                    // Hide the keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                } else {
                    showFailureToast();
                }
            }
        });
    }

    public void onPlusButtonClick(View view) {
        // Handle the plus button click here if needed
    }

    private void showCreativeToast() {
        Toast.makeText(this, "🏏 Thala, there's a reason you're pressing! Keep going! 🌟", Toast.LENGTH_SHORT).show();
    }

    private void playCustomSound() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    private void showSuccessToast() {
        Toast.makeText(this, "Thala for a reason!🌟", Toast.LENGTH_SHORT).show();
    }

    private void showFailureToast() {
        Toast.makeText(this, "You are not a Thala fan :(", Toast.LENGTH_SHORT).show();
    }
}
