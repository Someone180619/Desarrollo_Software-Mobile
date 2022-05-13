//TALLER N°15 | BRANDOOL CORTEZ [3-742-294] | 1SF141
package com.example.taller_n15_activity_a_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("MainActivity_1");

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        siguiente = findViewById(R.id.btn1);
        et1.requestFocus();

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, MainActivity2.class);
                intent.putExtra("Nombre",et1.getText().toString());
                intent.putExtra("Telefono",et2.getText().toString());
                startActivity(intent);
            }
        });
    }
}