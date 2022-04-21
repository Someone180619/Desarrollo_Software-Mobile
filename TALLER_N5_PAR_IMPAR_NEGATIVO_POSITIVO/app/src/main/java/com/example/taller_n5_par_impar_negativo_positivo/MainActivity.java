//Taller N°5 | Cortez, Brandool (3-742-294) | 1SF141
package com.example.taller_n5_par_impar_negativo_positivo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);
        et.requestFocus();
    }

    public void Calcular(View view){
        int num;
        num = Integer.parseInt(et.getText().toString());
        if (num  % 2 == 0){
            if (num  >= 0){
                tv.setText("El numero " + num + " Es par y positivo");
            }else{
                tv.setText("El numero " + num + " Es par y negativo");
            }
        }else if (num  >= 0){
                tv.setText("El numero " + num + " Es impar y positivo");
            }else{
                tv.setText("El numero " + num + " Es impar y negativo");
            }
    }

    public void Borrar (View view){
        et.setText("");
        tv.setText("");
        et.requestFocus();
    }
}