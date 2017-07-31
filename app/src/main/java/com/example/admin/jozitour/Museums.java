package com.example.admin.jozitour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

/**
 * Created by Admin on 7/26/2017.
 */

public class Museums extends AppCompatActivity {
    Firebase firebaseDatabase;
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.museums);
        Firebase.setAndroidContext(this);
        listView = (ListView) findViewById(R.id.list);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        firebaseDatabase = new Firebase("https://jozitour.firebaseio.com/Museum");
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if (position == 0) {
                    Intent museum = new Intent(Museums.this, Restaurants.class);
                    startActivity(museum);

                } else if (position == 1) {
                    Intent museum = new Intent(Museums.this, Resorts.class);
                    startActivity(museum);

                } else if (position == 2) {
                    Intent museum = new Intent(Museums.this,Theatres.class);
                    startActivity(museum);


                } else if (position == 3) {
                    Intent museum = new Intent(Museums.this,Activities.class);
                    startActivity(museum);


                }

            }


    });
}
}
