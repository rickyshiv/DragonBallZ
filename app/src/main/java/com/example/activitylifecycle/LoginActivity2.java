package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity2 extends AppCompatActivity {
    EditText username,password;
    Button btnLogin;
    TextView reg2,forg2;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        username=(EditText)findViewById(R.id.usernameLogin);
        password=(EditText)findViewById(R.id.passwordLogin);
        btnLogin=(Button) findViewById(R.id.btnlogin);
        reg2=(TextView) findViewById(R.id.reg2);
        forg2=(TextView) findViewById(R.id.forg2);
        reg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        forg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResetActivity.class);
                startActivity(intent);
            }
        });
        myDB=new DBHelper(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(user.equals("")||pass.equals(""))
                {
                    Toast.makeText(LoginActivity2.this,"Please enter the credentials",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Boolean result=myDB.checkusernamePassword(user,pass);
                    if(result==true)
                    {
                                Toast.makeText(LoginActivity2.this,"Welcome to DBZ",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),dash.class);
                                startActivity(intent);
                            }


                    else

                    {
                        Toast.makeText(LoginActivity2.this,"Incorrect Credentials",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}