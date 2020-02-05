package com.juara.belajarandroidui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3;
    Button btn4,btn5,btn6;
    Button btn7,btn8,btn9;
    Button btn0,btnPlus,btnMin;
    Button btnMul,btnDiv,btnEqual;
    TextView txtDisplay;

    List<String> lstData ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

         lstData = new ArrayList<String>();

        txtDisplay = findViewById(R.id.txtDisplay);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnMin = findViewById(R.id.btnMin);
        btnPlus = findViewById(R.id.btnPlus);
        btnDiv = findViewById(R.id.btnDiv);
        btnMul = findViewById(R.id.btnMultiply);
        btnEqual = findViewById(R.id.btnEqual);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnMin.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {

        if(v == btn0){
            lstData.add("0");
            setValue();
        }else if(v == btn1){
            lstData.add("1");
            setValue();
        }else if(v == btn2){
            lstData.add("2");
            setValue();
        }else if(v == btn3){
            lstData.add("3");
            setValue();
        }else if(v == btn4){
            lstData.add("4");
            setValue();
        }else if(v == btn5){
            lstData.add("5");
            setValue();
        }else if(v == btn6){
            lstData.add("6");
            setValue();
        }else if(v == btn7){
            lstData.add("7");
            setValue();
        }else if(v == btn8){
            lstData.add("8");
            setValue();
        }else if(v == btn9){
            lstData.add("9");
            setValue();
        }else if(v == btnMin){
            lstData.add("-");
            setValue();
        }else if(v == btnPlus){
            lstData.add("+");
            setValue();
        }else if(v == btnDiv){
            lstData.add("/");
            setValue();
        }else if(v == btnMul){
            lstData.add("*");
            setValue();
        }else if(v == btnEqual){

            hitungAngka();
        }



    }


    public void setValue(){
        txtDisplay.setText("");

        String display = "";
        for(int i = 0; i < lstData.size();i++){
            display = display+ lstData.get(i).toString();
        }

        txtDisplay.setText(display);
    }

    public void hitungAngka(){

        String display = "";
        for(int i = 0; i < lstData.size();i++){
            display = display+ lstData.get(i).toString();
        }

        BigDecimal result = null;


        Expression expression = new Expression(display);

        // Lowering the precision.
        expression.setPrecision(0);
        result = expression.eval();

        txtDisplay.setText(String.valueOf(result));
        lstData = new ArrayList<String>();
    }
}
