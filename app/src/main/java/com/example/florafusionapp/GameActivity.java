package com.example.florafusionapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private Button startButton, submitButton, tryAgainButton, goToMenuButton;

    private TextView timerTextView, resultTextView,NoteTextView;
    private LinearLayout leafLayout, stemLayout, rootsLayout, inflorescenceLayout;
    private Spinner spinnerLeaf, spinnerStem, spinnerRoots, spinnerInflorescence;
    private CountDownTimer countDownTimer;
    private boolean gameStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        // Initialize views
        startButton = findViewById(R.id.startButton);
        submitButton = findViewById(R.id.submitButton);
        tryAgainButton = findViewById(R.id.tryAgainButton);
        goToMenuButton = findViewById(R.id.goToMenuButton);

        timerTextView = findViewById(R.id.timerTextView);
        resultTextView = findViewById(R.id.resultTextView);
        NoteTextView= findViewById(R.id.NoteTextView);

        leafLayout = findViewById(R.id.leafLayout);
        stemLayout = findViewById(R.id.stemLayout);
        rootsLayout = findViewById(R.id.rootsLayout);
        inflorescenceLayout = findViewById(R.id.inflorescenceLayout);

        // Initialize Spinners
        spinnerLeaf = findViewById(R.id.spinnerLeaf);
        spinnerStem = findViewById(R.id.spinnerStem);
        spinnerRoots = findViewById(R.id.spinnerRoots);
        spinnerInflorescence = findViewById(R.id.spinnerInflorescence);

        // Initially set individual layouts to invisible and submit button to gone
        setLayoutsVisibility(View.GONE);
        submitButton.setVisibility(View.GONE);

        




        // Set up the start button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gameStarted) {
                    gameStarted = true;
                    startGame();
                }
            }
        });


        // Set up the try again button
        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartGame();
            }
        });


        // Set up the go to menu button
        goToMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish GameActivity and go back to MenuActivity
                finish();
            }
        });
        // Set up the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameStarted) {
                    gameStarted = false;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }
                    submitButton.setVisibility(View.GONE);
                    timerTextView.setVisibility(View.INVISIBLE);
                    if (checkAnswers()) {
                        endGameWin();
                    } else {
                        endGameLose();
                    }
                }
            }
        });
    }

    private void startGame() {
        NoteTextView.setVisibility(View.GONE);
        startButton.setVisibility(View.GONE);

        submitButton.setVisibility(View.VISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        setLayoutsVisibility(View.VISIBLE);

        countDownTimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.format("00:%02d", millisUntilFinished / 1000));
            }

            public void onFinish() {
                if (submitButton.getVisibility() == View.VISIBLE) {
                    submitButton.setVisibility(View.GONE);
                    resultTextView.setText("Time's up!");
                    resultTextView.setVisibility(View.VISIBLE);
                    tryAgainButton.setVisibility(View.VISIBLE);
                }
            }
        }.start();
    }

    private void setLayoutsVisibility(int visibility) {
        leafLayout.setVisibility(visibility);
        stemLayout.setVisibility(visibility);
        rootsLayout.setVisibility(visibility);
        inflorescenceLayout.setVisibility(visibility);
    }

    private boolean checkAnswers() {
        boolean correctLeaf = spinnerLeaf.getSelectedItem().toString().equals("Leaves");
        boolean correctStem = spinnerStem.getSelectedItem().toString().equals("Stem");
        boolean correctRoots = spinnerRoots.getSelectedItem().toString().equals("Roots");
        boolean correctInflorescence = spinnerInflorescence.getSelectedItem().toString().equals("Disk floret");

        return correctLeaf && correctStem && correctRoots && correctInflorescence;
    }

    private void restartGame() {
        resultTextView.setVisibility(View.GONE);
        tryAgainButton.setVisibility(View.GONE);

        NoteTextView.setVisibility(View.VISIBLE);
        startButton.setVisibility(View.VISIBLE);

        setLayoutsVisibility(View.GONE);
        gameStarted = false; // Set gameStarted to false to allow the game to start again
    }

    private void endGameWin() {
        // Display the win message and show the Go to Menu button
        resultTextView.setText("Congratulations! You win!");
        resultTextView.setVisibility(View.VISIBLE);
        goToMenuButton.setVisibility(View.VISIBLE);
    }

    private void endGameLose() {
        // Display the lose message and show the Try Again button
        resultTextView.setText("Game Over");
        resultTextView.setVisibility(View.VISIBLE);
        tryAgainButton.setVisibility(View.VISIBLE);
    }
}
