//TALLER N°12 | Brandool Cortez [3-742-294] | 1SF141
package com.example.taller12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int cont, res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cont = 0;
        res = new Random().nextInt(5);
    }

    public void huevo(View view){
        cont++;
        if(cont > 2){
            ((ImageView)findViewById(R.id.huevo)).setImageResource(R.drawable.huevo2);
        }
        if (cont >4){
            ((ImageView)findViewById(R.id.huevo)).setImageResource(R.drawable.huevo3);
        }
        if (cont >6){
            ((ImageView)findViewById(R.id.huevo)).setImageResource(R.drawable.huevo4);
        }

        if (cont >8){
            if(res == 0){
                ((ImageView)findViewById(R.id.huevo)).setImageResource(R.drawable.bruja);
            }
            if(res == 1){
                ((ImageView)findViewById(R.id.huevo)).setImageResource(R.drawable.hombre);
            }
            if(res == 2){
                ((ImageView)findViewById(R.id.huevo)).setImageResource(R.drawable.iguana);
            }
            if(res == 3){
                ((ImageView)findViewById(R.id.huevo)).setImageResource(R.drawable.nina);
            }
            if(res == 4){
                ((ImageView)findViewById(R.id.huevo)).setImageResource(R.drawable.nino);
            }
        }
    }
}
