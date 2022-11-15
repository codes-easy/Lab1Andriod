package com.example.lab1andriod;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class calculate {

    ArrayList<String> sm = new ArrayList<String>();
    ArrayList<String> fn = new ArrayList<String>();

    List<String> sym= Arrays.asList("*","-","+","/","=");


    int result=0;
    public int calculatefn(String value){
        boolean contains = sym.contains(value);

        if ( !value.equals("=")) {
            if (contains) {
                fn.add(value);
            } else {
                sm.add(value);
            }
        }
         if (value.equals("=")){
             int r=getResult();
             fn.clear();
             sm.clear();
            return r;

         }
         return 0;
    }
 private int getResult(){

        int LastJ =0;
     for (int i=0 ; i < fn.size();i++)
     {
         for (int j=LastJ ; j < sm.size();j++){

             switch (fn.get(i)) {
                 case "+":
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
             LastJ=j+1;
             break;
         }
     }
//        for (int i=0 ; i < sm.size();i++)
//        {
//            boolean contains = sym.contains(sm.get(i));
//
//            switch (sm.get(i)){
//
//                case "+":
//                   // result = result + Integer.parseInt(sm.get(i)+1);
//                    result = Integer.parseInt(sm.get(i-1)) +Integer.parseInt(sm.get(i+1));
//                default:
//                    result = result + Integer.parseInt(sm.get(i));
//            }
//
//        }
 return  result;
 }
    
}
