package com.example.parcial_n2_recycleview_cardview;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Warframe extends AppCompatActivity {

    private TextView tvWarframeName, tvWarframeVersion, tvWarframeDescription;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warframe_info);

        tvWarframeName = (TextView) findViewById(R.id.tvWarframeName);
        img = (ImageView) findViewById(R.id.warframePicture2);
        tvWarframeVersion = (TextView) findViewById(R.id.tvWarframeVersion);
        tvWarframeDescription = (TextView) findViewById(R.id.tvWarframeDescription);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("Name");
        int image = intent.getExtras().getInt("Image");
        String version = intent.getExtras().getString("Version");
        String description = intent.getExtras().getString("Description");

        tvWarframeName.setText(name);
        tvWarframeVersion.setText(version);
        tvWarframeDescription.setText(description);
        img.setImageResource(image);
    }
}