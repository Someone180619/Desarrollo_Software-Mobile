/**
 *     Integrantes         Cédula
 *     Brandool Cortez     (3-742-294)
 *     Gabriel García      (8-955-58)
 *     Gloria Jimenez      (8-961-700)
 *     Oriel Delgado       (8-970-187)
 *     Yulissa Restrepo    (8-961-1900)
 */

package com.example.parcial_n2_recycleview_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Warframe> warframes;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = findViewById(R.id.laybac);
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.warframesound);
        mediaPlayer.start();

        warframes = new ArrayList<>();
        warframes.add(new Warframe("Excalibur", "Normal", "Este es Excalibur, maestro de la espada y el arma. Tu estilo no importa, Tenno, el Warframe Excalibur es una elección formidable.", R.drawable.excalibur));
        warframes.add(new Warframe("Wukong", "Normal", "Todo el mundo tiene algo que ocultar, Tenno. Excepto Wukong. Un guerrero primitivo con el corazón de un tramposo.", R.drawable.wukong));
        warframes.add(new Warframe("Harrow", "Prime", "El eterno inquisidor se levanta, consagrado por el Vacío, predicando un evangelio de hierro y llamas. Harrow Prime es la variante Prime de Harrow, poseyendo un aumento de escudos, y capacidad de energía", R.drawable.harrowp));
        warframes.add(new Warframe("Excalibur", "Prime", "Excalibur Prime es el epítome de la movilidad y la ofensiva, y presenta las mismas habilidades que Excalibur, pero tiene polaridades de mod únicas instaladas que permiten una mayor personalización.", R.drawable.excaliburp));
        warframes.add(new Warframe("Wisp", "Normal", "Invisible en el aire y veloz en el suelo, se mueve como el viento. Esta es Wisp. Invocadora de lo etéreo. Su elegancia sólo es equiparable a su destrucción. No te pierdas en su estela, Tenno.", R.drawable.wisp));
        warframes.add(new Warframe("Octavia", "Prime", "Cuando los simios golpeaban pedernal con pedernal, algunos observaban las chispas. Otros simplemente bailaron. Nuestras encantadas creaciones necesitarán redobles para acallar el latido de la sangre de Helminto. Toca una sinfonía de destrucción con Octavia, la maestra de música, en su forma más grandiosa y espectacular. Cuenta con polaridades de mod alteradas para una mayor personalización.", R.drawable.octaviap));
        warframes.add(new Warframe("Hildryn", "Normal", "Haciendo uso de sus escudos como si fueran una batería, su uso tanto defensivo como ofensivo no tienen igual. Esta es Hildryn, la domina del armamento. En el cielo o en tierra, Hildryn llena completamente de pavor a sus víctimas.", R.drawable.hildryn));
        warframes.add(new Warframe("Octavia", "Normal", "Esta es Octavia, la melódica, la maestra. Si la música es el alimento de la muerte... sigue, Tenno. Compone su canción y luego dirige el poderoso mandacordio, convirtiendo los bajos, ritmos y melodías en un himno de devastación.", R.drawable.octavia));
        warframes.add(new Warframe("Harrow", "Normal", "Este es Harrow, el monástico, el ritualista. Siempre dispuesto a sacrificar. Este warframe monástico usa la energía del Vacío para reforzar las defensas de sus aliados y amplificar su letalidad.", R.drawable.harrow));
        warframes.add(new Warframe("Wukong", "Prime", "El guerrero tramposo asciende a su encarnación definitiva. Wukong Prime es la variante Prime de Wukong, poseyendo un aumento de escudos, armadura, capacidad de energía y velocidad de carrera con respeto a su versión original.", R.drawable.wukongp));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, warframes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
}