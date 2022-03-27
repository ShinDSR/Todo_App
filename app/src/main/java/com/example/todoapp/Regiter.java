package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

public class Regiter extends AppCompatActivity {

    EditText etnama,etemail,etpass,etrepass;
    String nama,email,pass,repass;
    Button btnregist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiter);

        etnama=findViewById(R.id.etrnama);
        etemail=findViewById(R.id.etemail);
        etpass=findViewById(R.id.etrpass);
        etrepass=findViewById(R.id.etrepass);
        btnregist=findViewById(R.id.btnregister);

        btnregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama=etnama.getText().toString();
                email=etemail.getText().toString();
                pass=etpass.getText().toString();
                repass=etrepass.getText().toString();

                if (nama.isEmpty()&&email.isEmpty()&&pass.isEmpty()&&repass.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Semua data wajib diisi!!",Toast.LENGTH_LONG).show();
                }
                else if (nama.isEmpty()){
                    etnama.setError("Masukkan Nama!");
                }
                else if (email.isEmpty()){
                    etemail.setError("Masukkan Email!");
                }
                else if (pass.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Masukkan Password!",Toast.LENGTH_LONG).show();
                }
                else {
                    if (!repass.equals(pass)){
                        Toast.makeText(getApplicationContext(),"Password Salah!",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Bundle b = new Bundle();
                        b.putString("nama", nama.trim());
                        b.putString("pass", pass.trim());

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        i.putExtras(b);
                        startActivity(i);
                    }
                }
            }
        });

    }
}