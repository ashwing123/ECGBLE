package com.example.android.bluetoothlegatt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    LinearLayout ecgButton;
    LinearLayout medicineButton;
    LinearLayout docButton;
    LinearLayout activButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ecgButton = (LinearLayout) findViewById(R.id.ECGicon);
        medicineButton = (LinearLayout) findViewById(R.id.medButton);
        docButton = (LinearLayout) findViewById(R.id.doctorButton);
        activButton = (LinearLayout) findViewById(R.id.activeButton);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

    ecgButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent openRunnerActivity = new Intent(HomeActivity.this, DeviceScanActivity.class);
            startActivity(openRunnerActivity);
        }
    });

    medicineButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent openNoteActivity = new Intent(HomeActivity.this, RemindersActivity.class);
            startActivity(openNoteActivity);
        }
    });

    docButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent openBlankActivity = new Intent(HomeActivity.this, blank1.class);
            startActivity(openBlankActivity);
        }
    });
    activButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent openBlankActivity = new Intent(HomeActivity.this, blank1.class);
            startActivity(openBlankActivity);
        }
    });

    }
}
