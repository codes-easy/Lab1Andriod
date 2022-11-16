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

    TextView show_num;
    TextView HistoryView;
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
    Button AdvanceHistory;
    calculate calc = new calculate();
    String dataToCalculate = "";
    boolean flag = true;
    String regex = "[0-9]+";
    //ArrayList<String> AdvHistoryView = new ArrayList<String>();
    String resultfinal;
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
        AdvanceHistory = findViewById(R.id.AdvanceHistoryBut);
        HistoryView=findViewById(R.id.HistoryView);

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
        AdvanceHistory.setOnClickListener(this);

        HistoryStd.setVisibility(View.GONE);
        HistoryView.setVisibility(View.GONE);
    }
    boolean isNewOperator = true;
    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        //String dataToCalculate = show_num.getText().toString();
        // show_num.setText(buttonText);

        if (isNewOperator)
            show_num.setText("");
        isNewOperator = false;


        if (buttonText.equals("Advance History")){
            //HistoryView.setText(View.GONE);
            AdvanceHistory.setVisibility(View.GONE);
            HistoryStd.setVisibility(View.VISIBLE);
            HistoryView.setText("Pinal");
        }
        else if (buttonText.equals("standar_no_history")) {

           // HistoryView.setVisibility(View.VISIBLE);
            AdvanceHistory.setVisibility(View.VISIBLE);
            HistoryStd.setVisibility(View.GONE);
        }
        if (buttonText.equals("C")) {
            flag = true;
            show_num.setText("");
            dataToCalculate = "";
            //also this is used
//            calc.fn.clear();
//            calc.sm.clear();
//            calc.result = 0;

            return;
        } else if (buttonText.equals("=")) {
            //show_num.setText(show_num.getText().toString()+"=");
            resultfinal = dataToCalculate + " = " + String.valueOf(calc.calculatefn(buttonText));
            show_num.setText(resultfinal);
          //  AdvHistoryView.add(resultfinal);
            HistoryView.append(resultfinal + "\n");

        } else if (buttonText.matches(regex) )//validating numbers (0-9) using regex function
            {
                if (flag) {
                    dataToCalculate = dataToCalculate + buttonText;
                    show_num.setText(dataToCalculate);
                    calc.calculatefn(buttonText);
                    flag = false;
                } else {
                    Toast.makeText(MainActivity.this, "ADD OPERATOR", Toast.LENGTH_SHORT).show();
                }
            } else  if (!flag && calc.sym.contains(buttonText)) //check 4 function, taking values from sym array from claclulator class. {

                //if (buttonText.equals("+") || buttonText.equals("*") || buttonText.equals("/")|| buttonText.equals("-")) {

                {
                    dataToCalculate = dataToCalculate + buttonText;
                    show_num.setText(dataToCalculate);
                    calc.calculatefn(buttonText);
                    flag = true;
                } else {
                    Toast.makeText(MainActivity.this, "ADD number", Toast.LENGTH_SHORT).show();
                }
// AdvanceHistory = findViewById(R.id.AdvanceHistory);


    }





                    }







