package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etnama, etpass;
    Button btnsignin;
    String nama, pass;
    TextView tvregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnama=findViewById(R.id.etnama);
        etpass=findViewById(R.id.etrpass);
        btnsignin=findViewById(R.id.btnsignin);
        tvregister=findViewById(R.id.toregister);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama=etnama.getText().toString();
                pass=etpass.getText().toString();
                
                String name="Shin";
                String password="Entropy";

                if (nama.equals(name) && pass.equals(password)){
                    Toast.makeText(getApplicationContext(),
                            "Login Barhasil",Toast.LENGTH_LONG).show();

                    Bundle bndl = new Bundle();

                    bndl.putString("nama", nama.trim());

                    Intent i = new Intent(getApplicationContext(), Home.class);

                    i.putExtras(bndl);
                    startActivity(i);
                }
                else if (nama.equals(name) && pass!=password){
                    Toast.makeText(getApplicationContext(),
                            "Password salah!!",Toast.LENGTH_LONG).show();
                }
                else if (nama!=name && pass.equals(password)){
                    Toast.makeText(getApplicationContext(),
                            "Nama salah!!",Toast.LENGTH_LONG).show();
                }
                else {
                    if (nama.isEmpty()){
                        etnama.setError("Masukkan Nama!");
                    }
                    else {
                        Toast.makeText(getApplicationContext(),
                                "Nama dan Password salah!!",Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        tvregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Regiter.class);
                startActivity(i);
            }
        });
    }
}