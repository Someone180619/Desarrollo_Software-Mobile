//TALLER N°16 | BRANDOOL CORTEZ [3-742-294] | 1SF141
package com.example.taller_n16_activity_a_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv2;
    private int n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("MainActivity_2");

        Intent intent = getIntent();
        n1 = intent.getIntExtra("n1",0);
        n2 = intent.getIntExtra("n2",0);

        TextView tv2 = findViewById(R.id.tv2);
        tv2.setText("Numeros Ingresados : \n"+"n1" + "=" +n1 + ", "+ "n2" + " = "+ n2);

        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int resu = n1+n2;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("Resultado", resu);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int resu = n1 - n2;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("Resultado",resu);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}