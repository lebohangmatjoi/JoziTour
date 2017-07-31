package com.example.admin.jozitour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize ImageView
        ImageView imageView = (ImageView) findViewById(R.id.imagetour);
        RelativeLayout activity_main = (RelativeLayout) findViewById(R.id.activity_main);

        //Loading image from below url into imageView
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/jozitour.appspot.com/o/tourguidejozi.jpg?alt=media&token=7519e477-b35c-48fb-b058-3ab24b0d1c76")
                .override(200, 200)
                .centerCrop()
                .into(imageView);

        TextView tour = (TextView) findViewById(R.id.tour);
        tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent museum = new Intent(MainActivity.this,Museums.class);
                startActivity(museum);


            }
        });
    }}