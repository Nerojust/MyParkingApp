package com.example.myparkingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class ParkCarActivity extends AppCompatActivity {
    private EditText  driverNameEditText,numberPlateEditText,driverNumberEditText,vehicleTypeEditText,amountEditText,passWordEditText;
    private AppCompatButton parkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_car);

        initView();
        initListener();
    }
    public void initView(){
        driverNameEditText = findViewById(R.id.driver_name);
        numberPlateEditText = findViewById(R.id.number_plate);
        driverNumberEditText = findViewById(R.id.driver_number);
        vehicleTypeEditText = findViewById(R.id.vehicle_Type);
        amountEditText = findViewById(R.id.amount);
        passWordEditText = findViewById(R.id.et_password2);
        parkButton = findViewById(R.id.parkBtn);
    }
    public void initListener(){
        parkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String retrievedPasswordTypedByTheUser = passWordEditText.getText().toString();
                if (retrievedPasswordTypedByTheUser.length() >= 6) {
                    Intent intent = new Intent(ParkCarActivity.this, PageActivity.class);

                    intent.putExtra("password", retrievedPasswordTypedByTheUser);
                    startActivity(intent);
                } else {
                    Toast.makeText(ParkCarActivity.this, "password is required", Toast.LENGTH_SHORT).show();
                }
            }

            //now we will toast the retrieved value as the message below
            //Toast.makeText(SignInTwo.this, newStringCombined,Toast.LENGTH_SHORT).show();
            //   Intent victorIntent= new Intent(SignInTwo.this,SignUpTwo.class);
            //   intent.putExtra("username", retrievedValueTypeByTheUser);
            //    intent.putExtra("password", retrievedPasswordTypedByTheUser);
            //  startActivity(victorIntent);


    });


    }
}