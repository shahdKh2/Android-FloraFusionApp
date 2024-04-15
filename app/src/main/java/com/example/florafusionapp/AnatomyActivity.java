package com.example.florafusionapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AnatomyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anatomy);

        TextView inflorescenceTextView = findViewById(R.id.InflorescenceTextView);
        FrameLayout cardLayout = findViewById(R.id.cardLayout);
        ImageButton closeButton = findViewById(R.id.closeButton);


        TextView leavesTextView = findViewById(R.id.LeavesTextView);
        FrameLayout leavesCardLayout = findViewById(R.id.LeavesCardLayout);
        ImageButton leavesCloseButton = findViewById(R.id.LeavesCloseButton);


        TextView pollenTextView = findViewById(R.id.pollenTextView);
        FrameLayout pollenCardLayout = findViewById(R.id.pollenCardLayoutt);
        ImageButton pollenCloseButton = findViewById(R.id.pollenCloseButton);

        TextView stemTextView = findViewById(R.id.StemTextView);
        FrameLayout stemCardLayout = findViewById(R.id.stemCardLayout);
        ImageButton stemCloseButton = findViewById(R.id.stemCloseButton);

        TextView rootTextView = findViewById(R.id.RootsTextView);
        FrameLayout rootCardLayout = findViewById(R.id.rootCardLayout);
        ImageButton rootCloseButton = findViewById(R.id.rootCloseButton);

        TextView diskTextView = findViewById(R.id.DiskFloreTextView);
        FrameLayout diskCardLayout = findViewById(R.id.diskCardLayout);
        ImageButton diskCloseButton = findViewById(R.id.diskCloseButton);

        inflorescenceTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardLayout.setVisibility(View.VISIBLE);
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardLayout.setVisibility(View.GONE);
            }
        });
//------------------------------------------------------------------------
        //leaves
        leavesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leavesCardLayout.getVisibility() == View.GONE) {
                    leavesCardLayout.setVisibility(View.VISIBLE);
                } else {
                    leavesCardLayout.setVisibility(View.GONE);
                }
            }
        });
        leavesCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leavesCardLayout.setVisibility(View.GONE);
            }
        });
        //------------------------------------------------------------------------
        //pollen
        pollenTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pollenCardLayout.getVisibility() == View.GONE) {
                    pollenCardLayout.setVisibility(View.VISIBLE);
                } else {
                    pollenCardLayout.setVisibility(View.GONE);
                }
            }
        });
        pollenCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pollenCardLayout.setVisibility(View.GONE);
            }
        });
        //------------------------------------------------------------------------
        //stem
        stemTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stemCardLayout.getVisibility() == View.GONE) {
                    stemCardLayout.setVisibility(View.VISIBLE);
                } else {
                    stemCardLayout.setVisibility(View.GONE);
                }
            }
        });
        stemCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stemCardLayout.setVisibility(View.GONE);
            }
        });
        //------------------------------------------------------------------------
        //roots
        rootTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rootCardLayout.getVisibility() == View.GONE) {
                    rootCardLayout.setVisibility(View.VISIBLE);
                } else {
                    rootCardLayout.setVisibility(View.GONE);
                }
            }
        });
        rootCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootCardLayout.setVisibility(View.GONE);
            }
        });
        //------------------------------------------------------------------------
        //disk
        diskTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (diskCardLayout.getVisibility() == View.GONE) {
                    diskCardLayout.setVisibility(View.VISIBLE);
                } else {
                    diskCardLayout.setVisibility(View.GONE);
                }
            }
        });
        diskCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diskCardLayout.setVisibility(View.GONE);
            }
        });
//------------------------------------------------------------------------


    }

    public void goBackToList(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
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
