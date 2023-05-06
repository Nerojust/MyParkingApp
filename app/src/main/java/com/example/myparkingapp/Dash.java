package com.example.myparkingapp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Dash extends AppCompatActivity {


    private EditText driverNameEditText;
    private EditText numberPlateEditText;
    private EditText driverNumberEditText;
    private  EditText vehicleTypeEditText;
    private TextView amountTextView;
    private TextView decrementTextView;
    private TextView incrementTextView;
    private AppCompatButton orderButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        initView();
        initListener();
    }
    public void initView(){
        driverNameEditText = findViewById(R.id.driver_name);
        numberPlateEditText = findViewById(R.id.number_plate);
        driverNumberEditText = findViewById(R.id.driver_number);
        vehicleTypeEditText = findViewById(R.id.vehicle_Type);
        amountTextView = findViewById(R.id.tv_amount);
        decrementTextView = findViewById(R.id.tv_decrement);
        incrementTextView = findViewById(R.id.tv_increment);
        orderButton = findViewById(R.id.order);
    }
    public void initListener(){

    }
}
