//Taller N°2 | Brandool Cortez (3-742-294) | 1SF141
package com.example.taller_n2_suma_de_dos_numeros_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private RadioButton rb1, rb2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        tv = (TextView) findViewById(R.id.tv);
    }

    public void Calcular (View view){
        Float n1, n2, resta, suma;
        String res;
        n1 = Float.parseFloat(et1.getText().toString());
        n2 = Float.parseFloat(et2.getText().toString());

        if (rb1.isChecked()==true){
            suma = n1 + n2;
            res = "La suma de "+ n1 +"+"+ n2 +" = "+ suma;
            tv.setText(res);
        } else if (rb2.isChecked()==true){
            resta = n1 - n2;
            res = "La resta de "+ n1 +"-"+ n2 +" = "+ resta;
            tv.setText(res);
        }
    }

    public void Borrar (View view){
        et1.setText("");
        et2.setText("");
        rb1.setChecked(false);
        rb2.setChecked(false);
        tv.setText("");
    }
}