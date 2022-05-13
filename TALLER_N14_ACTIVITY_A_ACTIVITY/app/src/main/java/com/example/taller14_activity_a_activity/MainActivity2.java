//TALLER N°14 | BRANDOOL CORTEZ [3-742-294] | 1SF141
package com.example.taller14_activity_a_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    private Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        regresar = (Button) findViewById(R.id.btn2);

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(regresar);
            }
        });
    }
}