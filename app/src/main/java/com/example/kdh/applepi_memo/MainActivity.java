package com.example.kdh.applepi_memo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    ListView list;
    ArrayList<Data> items = new ArrayList<>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        list = findViewById(R.id.list);

        adapter = new Adapter(items);
        list.setAdapter(adapter);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, memo_activity.class);
                startActivityForResult(intent,100);



            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode ==  RESULT_OK){
            if (requestCode==100){
                String title = data.getStringExtra("title");
                String content = data.getStringExtra("content");

                items.add(new Data(title,content));
                adapter.notifyDataSetChanged();

            }
        }


    }
}
