package com.example.florafusionapp;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ObjectAnimator rotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView flowerImageView = findViewById(R.id.flowerImageView);
        rotation = ObjectAnimator.ofFloat(flowerImageView, "rotation", 0f, 360f);
        rotation.setDuration(1000); // 1 second
        rotation.setInterpolator(new LinearInterpolator());
        rotation.setRepeatCount(0); // Play once
        rotation.start(); // Start the rotation animation
    }

    @Override
    protected void onPause() { //final update 15/4
        super.onPause();
        // Stop the rotation animation when the activity is paused
        if (rotation != null && rotation.isRunning()) {
            rotation.cancel();
        }
    }


    public void openSignUpActivity(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void openLogInActivity(View view) {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
