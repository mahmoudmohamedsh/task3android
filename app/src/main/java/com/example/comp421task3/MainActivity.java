package com.example.comp421task3;

import androidx.annotation.ContentView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView recview;
    ItemsAdaptor adaptor;
    ArrayList<Item> a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        recview = (RecyclerView) findViewById(R.id.Rview);
        a = new ArrayList<Item>();

        for (int i = 0; i < 10; i++) {
            a.add(new Item(("test"+i) , "dis test", i % 2 == 0 ? true : false));
        }
        adaptor = new ItemsAdaptor(this, a);
        recview.setAdapter(adaptor);
        adaptor.setOnItemClickListener(new ItemsAdaptor.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Item nav = a.get(position);
                openActivity2(nav);

            }
        });
        adaptor.setOnItemLongClickListener(new ItemsAdaptor.onItemLongClickListener() {
            @Override
            public void onItemLongClick( int position) {
                alert( position);
            }
        });
        recview.setLayoutManager(new LinearLayoutManager(this));
    }

    public void openActivity2(Item nav) {
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("todo", nav.todo);
        intent.putExtra("dis", nav.dis);
        intent.putExtra("ischeck", nav.isCheck);
        startActivity(intent);
    }

    public void alert(int p) {
        AlertDialog builder = new AlertDialog.Builder(this).
                setTitle("delete item " + p )
                .setMessage("are you sure to delete this item?")
                .setPositiveButton("ok", null).show();

        Button alertButton = builder.getButton(AlertDialog.BUTTON_POSITIVE);
        alertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a.remove(p);
                adaptor.notifyDataSetChanged();
                builder.dismiss();
            }
        });


    }
}