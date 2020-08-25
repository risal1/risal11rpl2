package com.example.risal11rpl2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Username,Password;
    Button LOGIN;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username=findViewById(R.id.Username);
        Password=findViewById(R.id.Password);
        LOGIN=findViewById(R.id.btnlogin);

        preferences=getSharedPreferences("login", Context.MODE_PRIVATE);

        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Username.getText().toString().trim().isEmpty() && !Password.getText().toString().trim().isEmpty()){
                    editor=preferences.edit();
                    editor.putString("nama",Username.getText().toString().trim());
                    editor.apply();
                    Intent i = new Intent(MainActivity.this,MENU.class);
                    startActivity(i);
                    finish();
                }else {
                    Toast.makeText(MainActivity.this, "Tidak Boleh Kosong !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}