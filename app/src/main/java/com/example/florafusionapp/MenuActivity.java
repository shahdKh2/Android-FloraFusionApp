package com.example.florafusionapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        //------------------------
        ListView listView = findViewById(R.id.optionsListView);
        String[] options = {"Anatomy", "Quiz", "Game", "About FloraFusion"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);


        //------------------------


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = options[position];
                if (selectedItem.equals("Anatomy")) {
                    Intent intent = new Intent(MenuActivity.this, AnatomyActivity.class);
                    startActivity(intent);
                }
                if (selectedItem.equals("Quiz")) {
                    Intent intent = new Intent(MenuActivity.this, QuizActivity.class);
                    startActivity(intent);
                }
                if (selectedItem.equals("About FloraFusion")) {
                    Intent intent = new Intent(MenuActivity.this, AboutFloraActivity.class);
                    startActivity(intent);
                }
                if (selectedItem.equals("Game")) {
                    Intent intent = new Intent(MenuActivity.this, GameActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    //===============================================================
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
