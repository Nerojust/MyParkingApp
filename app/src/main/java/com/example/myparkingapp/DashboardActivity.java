package com.example.myparkingapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class DashboardActivity extends AppCompatActivity {


    private EditText driverNameEditText;
    private EditText numberPlateEditText;
    private EditText driverNumberEditText;
    private EditText vehicleTypeEditText;
    private TextView amountTextView, quantityTextView;
    private Button decrementButton, incrementButton;
    private AppCompatButton payButton;

    private int defaultAmountToCharge = 500;
    private int amountCount = 0;
    private int quantityCount = 0;
    private String driversNameValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        initView();
        initListener();
    }

    public void initView() {
        //input fields
        driverNameEditText = findViewById(R.id.driver_name);
        numberPlateEditText = findViewById(R.id.number_plate);
        driverNumberEditText = findViewById(R.id.driver_number);
        vehicleTypeEditText = findViewById(R.id.vehicle_Type);

        //textviews
        amountTextView = findViewById(R.id.tv_amount);
        quantityTextView = findViewById(R.id.quantityCounter);

        //Buttons
        decrementButton = findViewById(R.id.btn_decrement);
        incrementButton = findViewById(R.id.btn_increment);

        //submit order button
        payButton = findViewById(R.id.orderButton);
    }

    public void initListener() {
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amountCount = amountCount + defaultAmountToCharge;
                quantityCount = quantityCount + 1;
                quantityTextView.setText(quantityCount + "");

                amountTextView.setText(getString(R.string.naira_sign) + amountCount);
            }
        });
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (amountCount != 0) {
                    amountCount = amountCount - defaultAmountToCharge;
                    amountTextView.setText(getString(R.string.naira_sign) + amountCount);

                    quantityCount = quantityCount - 1;
                    quantityTextView.setText(quantityCount + "");
                }
            }
        });
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValueFromInputFields();
                displayAConfirmPaymentDialog();

            }
        });
    }

    private void getValueFromInputFields() {
        driversNameValue = driverNameEditText.getText().toString().trim();
    }

    private void displayAConfirmPaymentDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.park_team, null, false);

        Button payButton = view.findViewById(R.id.payButton);
        TextView messageTextview = view.findViewById(R.id.message_tv);
        messageTextview.setText(driversNameValue + ", you are about to pay " + amountCount);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAConfirmPaymentDialog2();
            }
        });

        alertDialog.setView(view);

        alertDialog.show();
    }

    private void displayAConfirmPaymentDialog2() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Do you want to make payment?");
        alertDialog.setTitle("Payment");
        alertDialog.setPositiveButton("Pay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DashboardActivity.this, driversNameValue + ", your payment Successful for amount " + amountCount, Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DashboardActivity.this, "Cancel Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();
    }


}
