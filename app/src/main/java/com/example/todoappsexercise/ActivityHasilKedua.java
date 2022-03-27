package com.example.todoappsexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityHasilKedua extends AppCompatActivity {
    TextView txTask,txJenis, txTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_kedua);

        txTask=findViewById(R.id.tvtask);
        txJenis=findViewById(R.id.tvjenis);
        txTime=findViewById(R.id.tvtime);

        Bundle bundle =getIntent().getExtras();

        String task = bundle.getString("a");
        String jenis = bundle.getString("b");
        String time = bundle.getString("c");

        txTask.setText(task);
        txJenis.setText(jenis);
        txTime.setText(time);
    }
}