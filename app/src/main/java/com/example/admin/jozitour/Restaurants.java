package com.example.admin.jozitour;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class Restaurants extends AppCompatActivity {

    Firebase firebaseDatabase;
    ArrayAdapter<String> adapter;
    ListView listView;
    ArrayList<String> list = new ArrayList<>();
    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        listView = (ListView) findViewById(R.id.rest);
        Firebase.setAndroidContext(this);
         cl =(ConstraintLayout)findViewById(R.id.layout);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Restaurants.this,MapsActivity.class);
                startActivity(intent);
            }
        });


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        firebaseDatabase = new Firebase("https://jozitour.firebaseio.com/Restaurant");
        firebaseDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                list.add(value);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Glide.with(Restaurants.this).load("https://firebasestorage.googleapis.com/v0/b/jozitour.appspot.com/o/marbleres.jpg?alt=media&token=157d1b5b-b5ab-4a06-9fed-961626ecef72").asBitmap().into(new SimpleTarget<Bitmap>(400, 400) {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable drawable = new BitmapDrawable(resource);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    cl.setBackground(drawable);
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0) {
                    Glide.with(Restaurants.this).load("https://firebasestorage.googleapis.com/v0/b/jozitour.appspot.com/o/marbleres.jpg?alt=media&token=157d1b5b-b5ab-4a06-9fed-961626ecef72").asBitmap().into(new SimpleTarget<Bitmap>(400, 400) {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            Drawable drawable = new BitmapDrawable(resource);
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                cl.setBackground(drawable);
                            }
                        }
                    });
                }else if(i==1)
                {
                    Glide.with(Restaurants.this).load("https://firebasestorage.googleapis.com/v0/b/jozitour.appspot.com/o/thegrillhuis.jpg?alt=media&token=b8138e98-3b87-4f62-b2b1-5134687b420e").asBitmap().into(new SimpleTarget<Bitmap>(400, 400) {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            Drawable drawable = new BitmapDrawable(resource);
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                cl.setBackground(drawable);
                            }
                        }
                    });
                }
            }
        });

    }
}
