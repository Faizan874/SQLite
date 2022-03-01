package com.example.databasesql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
DatabaseHelper databaseHelper;
EditText edt1,edt2,edt3;
Button btnlogin,btnsign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper=new DatabaseHelper(this);
        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        edt3=findViewById(R.id.edt3);
        btnlogin=findViewById(R.id.btnlogin);
        btnsign=findViewById(R.id.btnsing);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,login.class);
                startActivity(intent);
            }
        });
        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username =edt1.getText().toString();
                String password=edt2.getText().toString();
                String confirm=edt3.getText().toString();
                if (username.equals("")||password.equals("")||confirm.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Fields Requireds", Toast.LENGTH_SHORT).show();

                }
                else {

                    if (password.equals(confirm)){
                        Boolean checkname =databaseHelper.Checkusername(username);
                        if (checkname==true){
                            Boolean insert =databaseHelper.Insert(username,password);
                            if (insert==true){
                                Toast.makeText(MainActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                                edt1.setText("");
                                edt2.setText("");
                                edt3.setText("");
                            }

                        }
                        else {
                            Toast.makeText(MainActivity.this, "Username Already Taken", Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(MainActivity.this, "Password Doesn't Match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}