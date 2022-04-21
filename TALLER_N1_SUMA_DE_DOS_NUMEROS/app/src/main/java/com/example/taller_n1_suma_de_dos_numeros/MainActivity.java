//Taller N°1 | Cortez, Brandool | 3-742-294 | 3-742-294 | 1SF141
package com.example.taller_n1_suma_de_dos_numeros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv = (TextView) findViewById(R.id.tv);
    }

    public void Sumar (View view){
        this.view = view;
        int n1, n2, suma;
        String res;
        n1 = Integer.parseInt(et1.getText().toString());
        n2 = Integer.parseInt(et2.getText().toString());

        suma = n1 + n2;

        res = "La sumatoria de "+ n1 +"+"+ n2 +"= "+ suma;
        tv.setText(res);
    }

    public void Borrar (View view){
        et1.setText("");
        et2.setText("");
        tv.setText("");
    }
}