//Taller N°3 | Brandool Cortez (3-742-294) | 1SF141
package com.example.taller_n3_suma_dos_numeros_spinner;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private Spinner spn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        spn = (Spinner) findViewById(R.id.spn);
        tv = (TextView) findViewById(R.id.tv);
        et1.requestFocus();
    }

    public void Calcular (View view){
        int n1, n2, resta, suma;
        String select, res = "";

        n1 = Integer.parseInt(et1.getText().toString());
        n2 = Integer.parseInt(et2.getText().toString());
        select = spn.getSelectedItem().toString();

        if (select.equals("Sumar")){
            suma = n1 + n2;
            res = "La suma de "+ n1 +"+"+ n2 +" = "+suma;
        } else if (select.equals("Restar")) {
            resta = n1 - n2;
            res = "La resta de "+ n1 +"+"+ n2 +" = "+resta;
        }

        tv.setText(res);
    }

    public void Borrar (View view){
        et1.setText("");
        et2.setText("");
        tv.setText("");
        spn.setSelection(0);
        et1.requestFocus();
    }
}