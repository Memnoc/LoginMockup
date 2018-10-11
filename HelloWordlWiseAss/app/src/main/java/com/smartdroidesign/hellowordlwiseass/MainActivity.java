package com.smartdroidesign.hellowordlwiseass;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView content;
    private FloatingActionButton fabulous;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = findViewById(R.id.txt_main_activity);
        fabulous = findViewById(R.id.fab_main_activity);

        fabulous.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        counter++;
        content.setText("Number of click " + Integer.toString(counter));
    }
}
