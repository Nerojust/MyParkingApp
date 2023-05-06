package com.example.myparkingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPassword extends AppCompatActivity {
    private EditText resetPasswordEditText;
    private EditText passWordEditText;
    private ImageView arrowBack;
    private Button loGin;
    private TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        initView();
        initListener();
    }
    public void initView(){
        resetPasswordEditText = findViewById(R.id.et_reset_password);
        passWordEditText = findViewById(R.id.et_password);
        arrowBack = findViewById(R.id.back_image);
        loGin = findViewById(R.id.btn_login);
        resultTextView = findViewById(R.id.result_textview);
    }
    public void initListener(){
        loGin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String retrievedValueTypeByTheUser = resetPasswordEditText.getText().toString();
                //do the same for other edittexts
                String retrievedPasswordTypedByTheUser = passWordEditText.getText().toString();
                // now i want to join the two string values together
                String newStringCombined = "Hello" + retrievedValueTypeByTheUser + " " + retrievedPasswordTypedByTheUser;
                resultTextView.setText("Welcome" + retrievedValueTypeByTheUser);


                // validation to check if he has indeed entered the username and password.
                if (retrievedValueTypeByTheUser.length() >= 6) {//this returns a boole
                    // the user has typed something,do something in this block
                    if (retrievedPasswordTypedByTheUser.length() >= 6) {
                        Intent intent = new Intent(ResetPassword.this, MainActivity.class);
                        intent.putExtra("resetpassword", retrievedValueTypeByTheUser);
                        intent.putExtra("password", retrievedPasswordTypedByTheUser);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ResetPassword.this, "Reset password is required", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ResetPassword.this, "Username is required", Toast.LENGTH_SHORT).show();
                }

                //now we will toast the retrieved value as the message below
                //Toast.makeText(SignInTwo.this, newStringCombined,Toast.LENGTH_SHORT).show();
                //   Intent victorIntent= new Intent(SignInTwo.this,SignUpTwo.class);
                //   intent.putExtra("username", retrievedValueTypeByTheUser);
                //    intent.putExtra("password", retrievedPasswordTypedByTheUser);
                //  startActivity(victorIntent);


            }
        });

    }
}


