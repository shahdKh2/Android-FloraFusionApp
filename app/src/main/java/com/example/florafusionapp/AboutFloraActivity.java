package com.example.florafusionapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;

public class AboutFloraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_florafusion);
        //-------------------------------------------------------------------
        SharedPreferences sharedPreferences = getSharedPreferences("FloraFusionPrefs", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("userName", "");

        TextView aboutFloraTextView = findViewById(R.id.AboutFloraTextView);//here i put the shared preferences. i shared user name to this welcoming textview.
        String aboutFloraText = "Welcome to FloraFusion, " + userName + "!\nFloraFusion is an educational app designed for grade 5 students that blends interactive learning with plant science exploration. Using the sunflower plant as an example, the app teaches students about plant anatomy, including roots, stems, leaves, flowers, and fruits, through interactive diagrams and quizzes. It also delves into the plant life cycle, covering seed germination, growth, reproduction, and death, with interactive activities to aid understanding. The app's main activity serves as a hub for users, offering navigation options to explore various topics. The Plant Anatomy Activity provides detailed information and interactive content about plant parts, while the Quiz Activity tests users' knowledge with multiple-choice questions. Through (FloraFusion) grade 5 students can engage in a fun and informative learning experience about plants.";
        aboutFloraTextView.setText(aboutFloraText);

//        android:text="Welcome to FloraFusion!\nFloraFusion is an educational app designed for grade 5 students that blends interactive learning with plant science exploration. Using the sunflower plant as an example, the app teaches students about plant anatomy, including roots, stems, leaves, flowers, and fruits, through interactive diagrams and quizzes. It also delves into the plant life cycle, covering seed germination, growth, reproduction, and death, with interactive activities to aid understanding. The app's main activity serves as a hub for users, offering navigation options to explore various topics. The Plant Anatomy Activity provides detailed information and interactive content about plant parts, while the Quiz Activity tests users' knowledge with multiple-choice questions. Through (FloraFusion) grade 5 students can engage in a fun and informative learning experience about plants."
    }
    //-------------------------------------------------------------

    public void startLearning(View view) { // start learning anatomy button
        Intent intent = new Intent(this, AnatomyActivity.class);
        startActivity(intent);
    }

}