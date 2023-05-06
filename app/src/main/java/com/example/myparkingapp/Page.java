package com.example.myparkingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Page extends AppCompatActivity {
    private AppCompatButton skipButton;
    private AppCompatButton nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        initView();
        initListener();
    }
    public void initView(){
        skipButton = findViewById(R.id.skip);
        nextButton = findViewById(R.id.button);

    }
    public void initListener(){
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Page.this,Dash.class);
                startActivity(intent);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Page.this,Dash.class);
                startActivity(intent);
            }
        });
    }
}