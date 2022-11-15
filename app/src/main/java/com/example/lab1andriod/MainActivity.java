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
    Button HistoryAdv;
    calculate calc = new calculate();
    String dataToCalculate = "";
    boolean flag = true;


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

        if (buttonText.equals("C")) {
            flag = true;
            show_num.setText("");
            dataToCalculate = "";

            //also this is used
            calc.fn.clear();
            calc.sm.clear();
            calc.result = 0;

            return;
        } else if (buttonText.equals("=")) {
            //show_num.setText(show_num.getText().toString()+"=");

            show_num.setText(dataToCalculate + "=" + String.valueOf(calc.calculatefn(buttonText)));
        } else {
            if (buttonText.equals("1") || buttonText.equals("2") || buttonText.equals("3") ||
                    buttonText.equals("4") || buttonText.equals("5") || buttonText.equals("6") ||
                    buttonText.equals("7") || buttonText.equals("8") || buttonText.equals("9") ||
                    buttonText.equals("0") ) {
                if (flag) {
                    dataToCalculate = dataToCalculate + buttonText;
                    show_num.setText(dataToCalculate);
                    calc.calculatefn(buttonText);
                    flag = false;
                } else {
                    Toast.makeText(MainActivity.this, "ADD OPERATOR", Toast.LENGTH_SHORT).show();
                }
            } else if (buttonText.equals("+") || buttonText.equals("*") || buttonText.equals("/")|| buttonText.equals("-")) {
                if (!flag) {
                    dataToCalculate = dataToCalculate + buttonText;
                    show_num.setText(dataToCalculate);
                    calc.calculatefn(buttonText);
                    flag = true;
                } else {
                    Toast.makeText(MainActivity.this, "ADD number", Toast.LENGTH_SHORT).show();
                }
            }




         /*   dataToCalculate = dataToCalculate + buttonText;
            show_num.setText(dataToCalculate);
            calc.calculatefn(buttonText);*/
        }


//      switch (view.getId()){
//          case R.id.Number0:
//              show_num.setText("0");
//              break;
//              case R.id.Number1:
//                  show_num.setText("1");
//                  break;
//          case R.id.Number2:
//              show_num.setText("2");
//              break;
//          case R.id.Number3:
//              show_num.setText("3");
//              break;
//          case R.id.Number4:
//              show_num.setText("4");
//              break;
//          case R.id.Number5:
//              show_num.setText("5");
//              break;
//          case R.id.Number6:
//              show_num.setText("6");
//              break;
//          case R.id.Number7:
//              show_num.setText("7");
//              break;
//          case R.id.Number8:
//              show_num.setText("8");
//              break;
//          case R.id.Number9:
//              show_num.setText("9");
//              break;
//          case R.id.addbutton:
//              show_num.setText("+");
//              break;
//          case R.id.subbutton:
//              show_num.setText("-");
//              break;
//          case R.id.timesbutton:button:
//              show_num.setText("*");
//              break;
//          case R.id.divisionbutton:
//              show_num.setText("/");
//              break;
//          case R.id.clearbutton:
//              show_num.setText("c");
//              break;
//          case R.id.equalbutton:
//              show_num.setText("=");
//              break;


    }

}
