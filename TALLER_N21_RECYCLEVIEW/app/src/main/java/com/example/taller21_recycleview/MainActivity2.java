package com.example.taller21_recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    ImageView imageView1;
    TextView tv1, tv2;
    String data1, data2;
    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView1 = findViewById(R.id.imageView1);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        setData();
        getData();
    }

    private void setData(){
        tv1.setText(data1);
        tv2.setText(data2);
        imageView1.setImageResource(images);
    }

    private void getData(){
        if (getIntent().hasExtra("images")&& getIntent().hasExtra("data1")&& getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            images = getIntent().getIntExtra("images", 1);
        }
        else {
            Toast.makeText(this, "No hay datos", Toast.LENGTH_LONG).show();
        }
    }


}