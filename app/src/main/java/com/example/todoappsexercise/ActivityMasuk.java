package com.example.todoappsexercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ActivityMasuk extends AppCompatActivity {

    EditText edttask, edtjenis, edttime;
    FloatingActionButton fab;
    String task, jenis, time;
    TextView txnama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        edttask=findViewById(R.id.edtask);
        edtjenis=findViewById(R.id.edjenis);
        edttime=findViewById(R.id.edtime);
        txnama=findViewById(R.id.tvnama);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");
        txnama.setText(nama);

        fab =findViewById(R.id.faButton3);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                task = edttask.getText().toString();
                jenis = edtjenis.getText().toString();
                time = edttime.getText().toString();

                if (task.isEmpty() && jenis.isEmpty() && time.isEmpty())
                {
                    Snackbar.make(view, "Isi Semua Data!", Snackbar.LENGTH_LONG).show();
                }
                if (edttask.getText().toString().length() == 0) {
                    edttask.setError("Nama Task");
                }
                if (edtjenis.getText().toString().length() == 0) {
                    edtjenis.setError("Jenis Task");
                }
                if (edttime.getText().toString().length() == 0) {
                    edttime.setError("Waktu Task");
                }
                else
                {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Berhasil", Toast.LENGTH_LONG);
                    t.show();

                    Bundle b = new Bundle();
                    b.putString("a", task.trim());
                    b.putString("b", jenis.trim());
                    b.putString("c", time.trim());

                    Intent i = new Intent(getApplicationContext(), ActivityHasilKedua.class);
                    i.putExtras(b);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnSubmit) {
            task = edttask.getText().toString();
            jenis = edtjenis.getText().toString();
            time = edttime.getText().toString();

            if (task.isEmpty() || jenis.isEmpty() || time.isEmpty()) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Isi Semua Data", Toast.LENGTH_LONG);
                t.show();
            } else {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Berhasil", Toast.LENGTH_LONG);
                t.show();

                Bundle b = new Bundle();
                b.putString("a", task.trim());
                b.putString("b", jenis.trim());
                b.putString("c", time.trim());

                Intent i = new Intent(getApplicationContext(), ActivityHasilKedua.class);
                i.putExtras(b);
                startActivity(i);
            }
        }
        if (item.getItemId() == R.id.mnLogout)
        {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);

    }
}