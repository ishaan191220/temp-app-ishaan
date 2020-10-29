package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eEmail;
    private EditText ePassword;
    private Button   eLogin;
    private TextView eAttempts;
    private TextView eRegistration;
     String userName="";
     String userPassword="";
    boolean isValid=false;
    private int counter=5;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eEmail = findViewById(R.id.etemail);
        ePassword = findViewById(R.id.etpassword);
        eLogin = findViewById(R.id.btnlogin);
        eAttempts =findViewById(R.id.tvattemps);
        eRegistration=findViewById(R.id.tvRegister);



        eRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             startActivity(new Intent(MainActivity.this,RegistrationPage.class));



            }
        });



        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                userName = eEmail.getText().toString();
                userPassword = ePassword.getText().toString();


                if(userName.isEmpty() || userPassword.isEmpty())
                {

                    Toast.makeText(MainActivity.this, "Please enter name and password!", Toast.LENGTH_LONG).show();

                }else {


                    isValid = validate(userName, userPassword);



                    if (!isValid) {


                        counter--;


                        eAttempts.setText("Attempts Remaining: " + String.valueOf(counter));


                        if (counter == 0) {
                            eLogin.setEnabled(false);
                            Toast.makeText(MainActivity.this, "You have used all your attempts, try again later!", Toast.LENGTH_LONG).show();
                        }

                        else {
                            Toast.makeText(MainActivity.this, "Incorrect credentials, please try again!", Toast.LENGTH_LONG).show();
                        }
                    }

                    else {


                        startActivity(new Intent(MainActivity.this, Navigation.class));
                    }

                }
            }
        });
    }


    private  boolean validate(String userName,String userPassword)

    {
        if( RegistrationPage.credentials !=null) {
            if (userName.equals(RegistrationPage.credentials.inputName) && userPassword.equals(RegistrationPage.credentials.inputPassword)) {
                return true;
            }
        } return false;

    }


}



