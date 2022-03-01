package com.example.databasesql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    Button button;
    EditText editText,editText2;
   DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseHelper=new DatabaseHelper(this);
        button=findViewById(R.id.btn1);
        editText=findViewById(R.id.edt4);
        editText2=findViewById(R.id.edt5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=editText.getText().toString();
                String password=editText2.getText().toString();
                Boolean checklogin=databaseHelper.checklogin(username,password);
                if (checklogin==true){
                    Intent intent=new Intent(login.this,welcome.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(login.this, "Invalid username Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}