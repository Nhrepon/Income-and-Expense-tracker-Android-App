package com.nhrepon.incomeexpensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    TextView balance, addExpense, showExpense, totalExpense, totalIncome, addIncome, showIncome;

    DatabaseHelper dbHelper;
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

        dbHelper = new DatabaseHelper(this);

        addExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputData.expense=true;
                startActivity(new Intent(Home.this, InputData.class));
            }
        });

        addIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputData.expense=false;
                startActivity(new Intent(Home.this, InputData.class));
            }
        });





        updateUi();

    }
    /////////////////////////////////////////////////////////////////
public void updateUi(){
    totalExpense.setText("BDT: " + dbHelper.calculateTotalExpense());
    totalIncome.setText("BDT: " + dbHelper.calculateTotalIncome());
    double calculateBalance=dbHelper.calculateTotalIncome() - dbHelper.calculateTotalExpense();
    balance.setText("BDT: " + calculateBalance );
}
////////////////////////////////////////////////////////////////////


    @Override
    protected void onPostResume() {
        super.onPostResume();
        updateUi();
    }

    ///////////////////////////////////////////////////////////////////


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}


