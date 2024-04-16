package com.example.florafusionapp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button checkButton;
    private TextView resultTextView;
    private Button nextButton;
    private CardView questionCardView;

    private String[] questions = {
            "What is the function of leaves in a sunflower?",
            "Where are sunflower seeds produced?",
            "What is the main stem of a sunflower called?",
            "How do sunflowers adapt to face the sun throughout the day?",
            "What is the name of the process by which sunflowers convert sunlight into energy?",
            "What is the purpose of the bracts in a sunflower?"
    };

    private String[][] options = {
            {"To attract pollinators", "To store water", "To perform photosynthesis", "To anchor the plant in the soil"},
            {"In the center of the flower head", "On the stem", "On the leaves", "Under the ground"},
            {"Stalk", "Root", "Branch", "Leaf"},
            {"By rotating their stems", "By bending their leaves", "By changing the direction of their roots", "By changing the color of their petals"},
            {"Respiration", "Transpiration", "Photosynthesis", "Evaporation"},
            {"To protect the seeds", "To attract insects", "To provide structural support", "To regulate temperature"}
    };


    private int[] answers = {0, 3, 1, 2, 3, 3}; // array to save the index of correct answer for each question
    private  int score = 0; // the user score in the quiz
    private int QsNo = 6; //questions number
    private static int currRound = 0; //cuurent round nevegator

    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        checkButton = findViewById(R.id.checkButton);
        resultTextView = findViewById(R.id.resultTextView);
        nextButton = findViewById(R.id.nextButton);
        questionCardView = findViewById(R.id.questionCardView);

        displayQuestion();

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
            }
        });
    }

    private void displayQuestion() {

        if (currentQuestionIndex == QsNo) {
            showScore();
        } else {
            questionTextView.setText(questions[currentQuestionIndex]);
            resultTextView.setVisibility(View.GONE);
            nextButton.setVisibility(View.GONE);
            optionsRadioGroup.clearCheck();

            String[] questionOptions = options[currentQuestionIndex];
            for (int i = 0; i < optionsRadioGroup.getChildCount(); i++) {
                RadioButton radioButton = (RadioButton) optionsRadioGroup.getChildAt(i);
                radioButton.setText(questionOptions[i]);
            }

        }
    } //

    private void showScore() {
        resultTextView.setText("\n\n\n\n\n\nQuiz completed\nYour Quiz Score is " + score + "/6");
        resultTextView.setTextSize(30);
        resultTextView.setGravity(Gravity.CENTER); // Center the text
        resultTextView.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.GONE);
    } //show user score in the quiz


    private void checkAnswer() {
        int selectedRadioButtonId = optionsRadioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedAnswer = selectedRadioButton.getText().toString();

            int selectedAnswerIndex = -1;
            String[] questionOptions = options[currentQuestionIndex];
            for (int i = 0; i < questionOptions.length; i++) {
                if (questionOptions[i].equals(selectedAnswer)) {
                    selectedAnswerIndex = i;
                    break;
                }
            }

            if (selectedAnswerIndex == answers[currentQuestionIndex]) {
                resultTextView.setText("Correct! :)");
                score++;
            } else {
                resultTextView.setText("Incorrect. :( \n The correct answer is: " + questionOptions[answers[currentQuestionIndex]]);
            }

            resultTextView.setVisibility(View.VISIBLE);
            nextButton.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, "Please select an answer!", Toast.LENGTH_SHORT).show();
        }
    }//checkAnswer method ends

    private void nextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            displayQuestion();
        } else {
            showScore();
            questionCardView.setVisibility(View.GONE);
        }
    } //go to the next question

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}