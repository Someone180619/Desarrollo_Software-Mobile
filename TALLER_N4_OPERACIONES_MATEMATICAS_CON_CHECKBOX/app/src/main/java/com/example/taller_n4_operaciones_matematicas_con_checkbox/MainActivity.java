//Cortez, Brandool | 3-742-294 | 1SF141
package com.example.taller_n4_operaciones_matematicas_con_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private CheckBox chb1, chb2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        chb1 = (CheckBox) findViewById(R.id.chb1);
        chb2 = (CheckBox) findViewById(R.id.chb2);
        tv = (TextView) findViewById(R.id.tv);
        et1.requestFocus();
    }

    public void Calcular (View view){
        int n1, n2, resta, suma;
        String res = "";

        n1 = Integer.parseInt(et1.getText().toString());
        n2 = Integer.parseInt(et2.getText().toString());

        if(chb1.isChecked() == true){
            suma = n1 + n2;
            res = "La suma de "+ n1 +"+"+ n2 +" = "+ suma;
        } else if (chb2.isChecked() == true){
            resta = n1 - n2;
            res = "La resta de "+ n1 +"-"+ n2 +" = "+resta;
        }

        tv.setText(res);
    }

    public void Borrar (View view){
        et1.setText("");
        et2.setText("");
        chb1.setChecked(false);
        chb2.setChecked(false);
        tv.setText("");
        et1.requestFocus();
    }
}