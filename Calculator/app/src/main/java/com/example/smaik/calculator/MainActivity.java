package com.example.smaik.calculator;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et1;
    EditText et2;
    TextView resTv;
    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;
    char operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.etResultFirst);
        et2 = findViewById(R.id.etResultSecond);
        btnAdd = findViewById(R.id.plusBtn);
        btnSub = findViewById(R.id.minusBtn);
        btnMult = findViewById(R.id.compBtn);
        btnDiv = findViewById(R.id.divBtn);
        resTv = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        float num1 = 0;
        float num2 = 0;
        float res = 0;

        if(TextUtils.isEmpty(et1.getText().toString()) || TextUtils.isEmpty(et2.getText().toString()))
            return;

        num1 = Float.parseFloat(et1.getText().toString());
        num2 = Float.parseFloat(et2.getText().toString());

        switch (view.getId())
        {
            case R.id.plusBtn:
                operation = '+';
                res = num1+num2;
                break;
            case R.id.minusBtn:
                operation = '-';
                res = num1-num2;
                break;
            case R.id.compBtn:
                operation = '*';
                res = num1*num2;
                break;
            case R.id.divBtn:
                operation = '/';
                res = num1/num2;
                break;
                default:
                    break;
        }
        resTv.setText(num1 + " " + operation + " " + num2 + " = " + new DecimalFormat(("#.####")).format(res));
    }
}
