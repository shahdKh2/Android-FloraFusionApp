package com.example.florafusionapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LogInActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "FloraFusionPrefs";
    private static final String KEY_USERNAME = "userName";

    private EditText nameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        passwordEditText = findViewById(R.id.passwordEditText);
        nameEditText = findViewById(R.id.nameEditText);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Retrieve the saved username from SharedPreferences and set it in the EditText
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String savedUserName = sharedPreferences.getString(KEY_USERNAME, "");
        nameEditText.setText(savedUserName);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Save the entered username in SharedPreferences
        String userName = nameEditText.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, userName);
        editor.apply();
    }

    // Method to be called when Log In button is clicked
    public void OpenMenuActivity(View view) {
        // Check if the nameEditText OR passwordEditText is empty
        if (nameEditText.getText().toString().isEmpty()|| passwordEditText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
    }
}
