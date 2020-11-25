package com.example.comp421task3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent a = getIntent();
        TextView todo = (TextView) findViewById(R.id.todo);
        todo.setText(a.getStringExtra("todo"));
        TextView dis = (TextView) findViewById(R.id.todo);
        todo.setText(a.getStringExtra("dis"));
        CheckBox is = (CheckBox) findViewById(R.id.ischeck);
        is.setChecked(a.getBooleanExtra("ischeck",false));
    }
}