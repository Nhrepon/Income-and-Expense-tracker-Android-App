package com.nhrepon.incomeexpensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    TextView balance, addExpense, showExpense, totalExpense, totalIncome, addIncome, showIncome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);


        balance=findViewById(R.id.balance);
        addExpense=findViewById(R.id.addExpense);
        showExpense=findViewById(R.id.showExpense);
        totalExpense=findViewById(R.id.totalExpense);
        totalIncome=findViewById(R.id.totalIncome);
        addIncome=findViewById(R.id.addIncome);
        showIncome=findViewById(R.id.showIncome);


        addExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, InputData.class));
            }
        });






    }
}