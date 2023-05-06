package com.example.myparkingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myparkingapp.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    private EditText driverNameEditText,numberPlateEditText,driverNumberEditText,vehicleTypeEditText,amountEditText;
    private Button park;


    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       initView();
       initListener();

    }
    public void initView(){
        driverNameEditText = findViewById(R.id.driver_name);
        numberPlateEditText = findViewById(R.id.number_plate);
        driverNumberEditText = findViewById(R.id.driver_number);
        vehicleTypeEditText = findViewById(R.id.vehicle_Type);
        amountEditText = findViewById(R.id.amount);


    }
    public void initListener(){
        binding.parkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),ParkCarActivity.class));
            }
        });
    }

}