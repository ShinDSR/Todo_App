package com.example.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Home extends AppCompatActivity {

    TextView tvnama;
    EditText ettask, etjenist, ettimet;
    FloatingActionButton btn;
    String task, jenis, time;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menupilih, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if (item.getItemId() == R.id.submiit){
            Bundle bndl = new Bundle();
            bndl.putString("task", ettask.getText().toString().trim());
            bndl.putString("jenis", etjenist.getText().toString().trim());
            bndl.putString("time", ettimet.getText().toString().trim());

            Intent i = new Intent(getApplicationContext(),Hasil.class);
            i.putExtras(bndl);
            startActivity(i);
        }
        else if (item.getItemId() == R.id.logout){
            Intent i = new Intent(getApplicationContext(),MainActivity.class);;
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvnama = findViewById(R.id.tvidentitas);

        Bundle bndl = getIntent().getExtras();
        String nama = bndl.getString("nama");
        tvnama.setText(nama);

        ettask=findViewById(R.id.ethtask);
        etjenist=findViewById(R.id.ethjenist);
        ettimet=findViewById(R.id.ethtimet);

        btn=findViewById(R.id.btnsave);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task=ettask.getText().toString();
                jenis=etjenist.getText().toString();
                time=ettimet.getText().toString();

                if (task.isEmpty()&&jenis.isEmpty()&&time.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Isi semua data!!",Toast.LENGTH_LONG).show();
                }
                else if (task.isEmpty()){
                    ettask.setError("Task Wajib diisi!");
                }
                else if (jenis.isEmpty()){
                    etjenist.setError("Jenis Task!");
                }
                else if (time.isEmpty()){
                    ettimet.setError("Lama Task!");
                }
                else {
                    Toast.makeText(getApplicationContext(),"Berhasil",Toast.LENGTH_LONG).show();

                    Bundle bndl = new Bundle();
                    bndl.putString("task", task.trim());
                    bndl.putString("jenis", jenis.trim());
                    bndl.putString("time", time.trim());

                    Intent i = new Intent(getApplicationContext(), Hasil.class);
                    i.putExtras(bndl);
                    startActivity(i);
                }
            }
        });
    }
}