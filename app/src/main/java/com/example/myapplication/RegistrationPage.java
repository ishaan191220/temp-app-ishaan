package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RegistrationPage extends AppCompatActivity {
       private EditText eRegname;
       private EditText eRegpassword;
       private Button eRegbtn;
       private EditText eRollno;
       private EditText eEmail;
       private RadioGroup eYear;
       private RadioGroup eBranch;
       private  EditText eBatch;
       private  EditText ePhoneno;
       public String regName="";
       public String regPassword="";

     public static   Credentials credentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        eRegname=findViewById(R.id.sregname);
        eRegpassword=findViewById(R.id.sregpassword);
        eRegbtn = findViewById(R.id.sregbtn);
        eYear=findViewById(R.id.sregyear);
        eRollno=findViewById(R.id.sregrollno);
        eEmail=findViewById(R.id.sregemail);
        eBatch=findViewById(R.id.sregbatch);
        eBranch=findViewById(R.id.sregbranch);
        ePhoneno=findViewById(R.id.sregphone);



        eRegbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regName =eRegname.getText().toString();
                String regPassword =eRegpassword.getText().toString();
                String regEmail=eEmail.getText().toString();
                String regYear= eYear.toString();
                String regRollno =eRollno.getText().toString();
                String regBatch  =eBatch.getText().toString();
                String regBranch =eBranch.toString();
                String regPhone =ePhoneno.getText().toString();



                if (validate(regName,regPassword)){

                  credentials= new Credentials(regName,regPassword);

                    startActivity(new Intent (RegistrationPage.this,MainActivity.class));

                    Toast.makeText(RegistrationPage.this, "Registration was successful", Toast.LENGTH_LONG).show();
                }
                if (TextUtils.isEmpty(regEmail)){



                    Toast.makeText(RegistrationPage.this, "Empty field not allowed!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(RegistrationPage.this, "Proceed..", Toast.LENGTH_SHORT).show();


                }
            }
        });




    }


    private boolean validate (String regName,String regPassword)
    {
      if(regName.isEmpty()||regPassword.length()<8)
      {
          Toast.makeText(this, "Please enter all details, Password should be more than 8 charecters", Toast.LENGTH_LONG).show();
        return false;
      }
        return true;



    }





}