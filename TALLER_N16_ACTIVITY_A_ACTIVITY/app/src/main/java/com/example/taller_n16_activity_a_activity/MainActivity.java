//TALLER N°16 | BRANDOOL CORTEZ [3-742-294] | 1SF141
package com.example.taller_n16_activity_a_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("MainActivity_1");

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv1 = (TextView) findViewById(R.id.tv1);
        et1.requestFocus(0);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((et1.getText().toString().equals(""))|| (et2.getText().toString().equals(""))){
                    Toast.makeText(MainActivity.this,"Ingrese los numeros",Toast.LENGTH_LONG).show();
                }
                else {
                    int n1 = Integer.parseInt(et1.getText().toString());
                    int n2 = Integer.parseInt(et2.getText().toString());

                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    intent.putExtra("n1",n1);
                    intent.putExtra("n2",n2);
                    startActivityForResult(intent, 1);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText("");
                et2.setText("");
                tv1.setText("");
                et1.requestFocus(0);
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            int resu = data.getIntExtra("Resultado", 0);
            tv1.setText("El resultado es"+ resu);
        }

        if(resultCode == RESULT_CANCELED){
            tv1.setText("No selecciono bien");
        }
    }
}