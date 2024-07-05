package com.nhrepon.incomeexpensetracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class InputData extends AppCompatActivity {

    TextView inputDataTitle;
    EditText inputAmount, inputDescription;
    Button submitAmount;
    DatabaseHelper dbHelper;
    public static boolean expense = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input_data);

        inputDataTitle=findViewById(R.id.inputDataTitle);
        inputAmount=findViewById(R.id.inputAmount);
        inputDescription=findViewById(R.id.inputDescription);
        submitAmount=findViewById(R.id.submitAmount);

        dbHelper = new DatabaseHelper(this);


        if(expense==true){
            inputDataTitle.setText("Input Expense Data");
        }else {
            inputDataTitle.setText("Input Income Data");
        }

        submitAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sAmount = inputAmount.getText().toString();
                String sDescription = inputDescription.getText().toString();
                double amount = Double.parseDouble(sAmount);

                if(expense==true) {
                    dbHelper.addExpense(amount, sDescription);
                    Toast.makeText(getApplicationContext(), "Expense inserted successfully", Toast.LENGTH_LONG).show();
                }else{
                    dbHelper.addIncome(amount, sDescription);
                    Toast.makeText(getApplicationContext(), "Income inserted successfully", Toast.LENGTH_LONG).show();
                }





                onBackPressed();
            }
        });


    }


    ////////////////////////////////////////////////////

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    };




}












