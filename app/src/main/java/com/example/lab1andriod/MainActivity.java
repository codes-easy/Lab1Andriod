package com.example.lab1andriod;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    //define all buttons, text views

    TextView show_num;
    TextView HistView;
    Button Number1;
    Button Number2;
    Button Number3;
    Button Number4;
    Button Number5;
    Button Number6;
    Button Number7;
    Button Number8;
    Button Number9;
    Button Number0;
    Button addbut;
    Button subbut;
    Button timesbut;
    Button divbut;
    Button clearbut;
    Button equalbut;
    Button HistoryStd;
    Button AdvanceHistoryBut;


    calculate calc = new calculate();
    String dataToCalculate = "";
    boolean flag = true;
    String regex = "[0-9]+";
    //ArrayList<String> AdvHistoryView = new ArrayList<String>();
    String resultfinal;
    boolean isAdvance = false;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show_num = findViewById(R.id.shownumbers);
        Number1 = findViewById(R.id.Number1);
        Number2 = findViewById(R.id.Number2);
        Number3 = findViewById(R.id.Number3);
        Number4 = findViewById(R.id.Number4);
        Number5 = findViewById(R.id.Number5);
        Number6 = findViewById(R.id.Number6);
        Number7 = findViewById(R.id.Number7);
        Number8 = findViewById(R.id.Number8);
        Number9 = findViewById(R.id.Number9);
        Number0 = findViewById(R.id.Number0);
        addbut = findViewById(R.id.addbutton);
        subbut = findViewById(R.id.subbutton);
        divbut = findViewById(R.id.divisionbutton);
        timesbut = findViewById(R.id.timesbutton);
        clearbut = findViewById(R.id.clearbutton);
        equalbut = findViewById(R.id.equalbutton);
        HistoryStd = findViewById(R.id.StdNoHistory);
        AdvanceHistoryBut = findViewById(R.id.AdvanceHistoryBut);
        HistView = findViewById(R.id.HistoryView);

        Number1.setOnClickListener(this);
        Number2.setOnClickListener(this);
        Number3.setOnClickListener(this);
        Number4.setOnClickListener(this);
        Number5.setOnClickListener(this);
        Number6.setOnClickListener(this);
        Number7.setOnClickListener(this);
        Number8.setOnClickListener(this);
        Number9.setOnClickListener(this);
        Number0.setOnClickListener(this);
        addbut.setOnClickListener(this);
        subbut.setOnClickListener(this);
        timesbut.setOnClickListener(this);
        divbut.setOnClickListener(this);
        equalbut.setOnClickListener(this);
        clearbut.setOnClickListener(this);
        HistoryStd.setOnClickListener(this);
        show_num.setOnClickListener(this);
        AdvanceHistoryBut.setOnClickListener(this);

        HistoryStd.setVisibility(View.GONE);
        HistView.setVisibility(View.GONE);


    }

    boolean isNewOperator = true;

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        //String dataToCalculate = show_num.getText().toString();
        // show_num.setText(buttonText);
        if (isNewOperator) // this operator brings single digit number each time
            show_num.setText("");
        isNewOperator = false;
        // When user click on Advance History;
        //1) "Std NO history" button should be visible in green colour
        //2) "AdvanceHistoryBut" button should be invisible
        //3) History view should visible
              if (buttonText.equals("Advance History")) {
            resultfinal = "";
            HistView.setVisibility(View.VISIBLE);
            HistView.setText("");
            HistView.append(resultfinal + "\n");
            HistoryStd.setBackgroundColor(getResources().getColor(R.color.green));
            AdvanceHistoryBut.setVisibility(View.GONE);
            HistoryStd.setVisibility(View.VISIBLE);
            //  When user click on Standard History Button;
            //      1) "Std NO history" button should be invisible
            //      2) "AdvanceHistoryBut" button should be visible in Navy colour
            //      3) History view should be invisible
        } else if (buttonText.equals("Standard - No History")) {
            HistView.setVisibility(View.GONE);
            AdvanceHistoryBut.setVisibility(View.VISIBLE);
            HistoryStd.setVisibility(View.GONE);
            AdvanceHistoryBut.setBackgroundColor(getResources().getColor(R.color.navy));
        }
        if (buttonText.equals("C")) {  // Button "C" will clear text and also clear array
            flag = true;
            show_num.setText("");
            dataToCalculate = "";

        } else if (buttonText.equals("=")) { //Button "=" will show all calculation that user input,sing '=' , result.
            resultfinal = dataToCalculate + " = " + String.valueOf(calc.calculatefn(buttonText));
            show_num.setText(resultfinal);
            HistView.append(resultfinal + "\n");
        //If user inputs two numbers togather, it will show message to add operator
        } else if (buttonText.matches(regex)) { //validating numbers (0-9) using regex function
            if (flag) {
                dataToCalculate = dataToCalculate + buttonText;
                show_num.setText(dataToCalculate);
                calc.calculatefn(buttonText);
                flag = false;
            } else {
                Toast.makeText(MainActivity.this, "PLEASE ADD OPERATOR", Toast.LENGTH_SHORT).show();
                //If user inputs two operators togather, it will show message to add operator
            }
        } else if (!flag && calc.sym.contains(buttonText)) //check 4 function, taking values from sym array from calculator class. {
               {
            dataToCalculate = dataToCalculate + buttonText;
            show_num.setText(dataToCalculate);
            calc.calculatefn(buttonText);
            flag = true;
        } else if(buttonText.equals(regex)) { //also validating condition for number 0-9.
            Toast.makeText(MainActivity.this, "PLEASE ADD NUMBER", Toast.LENGTH_SHORT).show();
        }

    }


}







