package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Hasil extends AppCompatActivity {

    TextView tvtask, tvjenis, tvtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        tvtask=findViewById(R.id.ethtask);
        tvjenis=findViewById(R.id.ethjenist);
        tvtime=findViewById(R.id.ethtimet);

        Bundle b = getIntent().getExtras();
        String task = b.getString("task");
        tvtask.setText(task);
        String jenis = b.getString("jenis");
        tvjenis.setText(jenis);
        String time = b.getString("time");
        tvtime.setText(time);
    }
}