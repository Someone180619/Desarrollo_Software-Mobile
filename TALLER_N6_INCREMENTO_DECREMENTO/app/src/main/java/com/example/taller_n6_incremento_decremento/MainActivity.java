//Taller N°6 | Brandool Cortez [3-742-294] | 1SF141
package com.example.taller_n6_incremento_decremento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Button btn1, btn2, btn3;
    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        tv.setText(Integer.toString(cont));

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
                cont++;
                tv.setText(Integer.toString(cont));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cont--;
                tv.setText(Integer.toString(cont));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cont = 0;
                tv.setText(Integer.toString(cont));
            }
        });
    }
}