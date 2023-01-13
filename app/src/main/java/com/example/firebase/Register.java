package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private TextView banner,registeruser;
    private EditText editTextNewEmail,editTextNewPassword;




    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();




        editTextNewEmail=(EditText) findViewById(R.id.newemail);
        editTextNewPassword=(EditText) findViewById(R.id.newpassword);


    }




    public void RegisterUser(View V) {

        String email=editTextNewEmail.getText().toString();


        String password=editTextNewPassword.getText().toString();

        if( ( !email.isEmpty()) && (!password.isEmpty()) && (password.length()>=6) ){
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"User is Created",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
        /*
        if (email.isEmpty())
        {
            editTextNewEmail.setError("Email is required");
            editTextNewEmail.requestFocus();
            return;
        }

        if (password.isEmpty())
        {
            editTextNewPassword.setError("Password is required");
            editTextNewPassword.requestFocus();
            return;
        }

        if (password.length()<6)
        {
            editTextNewPassword.setError("Min password length should be 6 characters !");
            editTextNewPassword.requestFocus();
            return;
        }*/
    }
}