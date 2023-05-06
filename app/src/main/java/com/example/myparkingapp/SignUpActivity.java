package com.example.myparkingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText emailAddressEditText;
    private EditText phoneNumberEditText;
    private EditText userNameEditText;
    private EditText passWordEditText;
    private Button loGin;
    private TextView resetPasswordTextView;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initView();
        initListener();
    }
    public void initView(){
        firstNameEditText = findViewById(R.id.et_first_name);
        lastNameEditText = findViewById(R.id.et_last_name);
        emailAddressEditText = findViewById(R.id.et_email_address);
        phoneNumberEditText = findViewById(R.id.et_phone_number);
        userNameEditText = findViewById(R.id.et_user_name);
        loGin = findViewById(R.id.btn_button);
        passWordEditText = findViewById(R.id.et_pass_word);
        resultTextView = findViewById(R.id.result_textview);
        resetPasswordTextView = findViewById(R.id.tv_Reset_password);


    }
   public void initListener(){
        loGin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String retrievedValueTypeByTheUser = userNameEditText.getText().toString();
                //do the same for other edittexts
                String retrievedPasswordTypedByTheUser = passWordEditText.getText().toString();
                // now i want to join the two string values together
                String newStringCombined = "Hello" + retrievedValueTypeByTheUser + " " + retrievedPasswordTypedByTheUser;
                resultTextView.setText("Hello" + retrievedValueTypeByTheUser);


                // validation to check if he has indeed entered the username and password.
                if (retrievedValueTypeByTheUser.length() >= 6) {//this returns a boole
                    // the user has typed something,do something in this block
                    if (retrievedPasswordTypedByTheUser.length() >= 6) {
                        Intent intent = new Intent(SignUpActivity.this, ResetPasswordActivity.class);
                        intent.putExtra("username", retrievedValueTypeByTheUser);
                        intent.putExtra("password", retrievedPasswordTypedByTheUser);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignUpActivity.this, "password is required", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SignUpActivity.this, "Username is required", Toast.LENGTH_SHORT).show();
                }

                //now we will toast the retrieved value as the message below
                //Toast.makeText(SignInTwo.this, newStringCombined,Toast.LENGTH_SHORT).show();
                //   Intent victorIntent= new Intent(SignInTwo.this,SignUpTwo.class);
                //   intent.putExtra("username", retrievedValueTypeByTheUser);
                //    intent.putExtra("password", retrievedPasswordTypedByTheUser);
                //  startActivity(victorIntent);

            }
        });
        resetPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, ResetPasswordActivity.class);
                startActivity(intent);
            }
        });

   }
}







