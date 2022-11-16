package com.example.lab1andriod;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class calculate {

    ArrayList<String> sm = new ArrayList<String>(); // Array for numbers only
    ArrayList<String> fn = new ArrayList<String>(); // Array for functions only.

    List<String> sym= Arrays.asList("*","-","+","/"); // Defining accepted symbols in array
    int result=0;
    public int calculatefn(String value){
        boolean contains = sym.contains(value);
        if ( !value.equals("=")) {//adding values in arrays
            if (contains) {
                fn.add(value);
            } else {
                sm.add(value);
            }
            }
         if (value.equals("=")){
             int r=getResult(); //(result stored in variable r //
             fn.clear(); //so cleared both arrays//
             sm.clear();
             result = 0;
            return r;
         }
         return 0;
        }
 private int getResult(){//calculation function
        int LastJ =0;
     for (int i=0 ; i < fn.size();i++) // taking operator from its array
     {
         for (int j=LastJ ; j < sm.size();j++){//taking number from its array
             switch (fn.get(i)) {
                 case "+": // first time array 0 + array 1 will perform its functionality,
                     // second time onwards result + successive array position will perform functionality
                     result = (result == 0? Integer.parseInt(sm.get(j))  : result ) + Integer.parseInt(sm.get(j+1));
                     break;
                 case "*":
                     result = (result == 0? Integer.parseInt(sm.get(j))  : result ) * Integer.parseInt(sm.get(j+1));
                     break;
                 case "/":
                     result = (result == 0? Integer.parseInt(sm.get(j))  : result ) / Integer.parseInt(sm.get(j+1));
                     break;
                 case "-":
                     result = (result == 0? Integer.parseInt(sm.get(j))  : result ) - Integer.parseInt(sm.get(j+1));
                     break;
             }
             LastJ=j+1; // in number array 0 and 1 is already taken so to take successive array position we have to add 1.
             break;
         }
     }
 return  result;
    }

    }
