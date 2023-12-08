package com.example.lab4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // public MyListAdapter myAdapter;
    ArrayAdapter<ListItem> arrayAdapter;

    public ArrayList<ListItem> toDoList;
    public ListView listView;
    public Button button;
    public Switch urgent;
    public EditText inputText;
    public TextView listText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        toDoList = new ArrayList<>();
        arrayAdapter = new MyListAdapter(this, R.layout.row_layout,toDoList);

       // myAdapter = new MyListAdapter();
        listView = findViewById(R.id.list);
        button = findViewById(R.id.add);
        inputText = findViewById(R.id.inputText);
        urgent = findViewById(R.id.urgent);
        listText = findViewById(R.layout.row_layout);


        listView.setAdapter(arrayAdapter);
        String listText = inputText.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });

        listView.setOnItemLongClickListener ( (parent, view, position, id) -> {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Delete:");

            alert.setMessage("Do you want to delete this?");

            alert.setPositiveButton("Yes", (click, arg)->{
                toDoList.remove(position);
                arrayAdapter.notifyDataSetChanged();
            });

            alert.setNegativeButton("No", (click, arg) -> {});

            alert.setView(getLayoutInflater().inflate(R.layout.row_layout, null));

            alert.create().show();
            return true;
        });
    }

    public void addItem(View view){
        ListItem listItem = new ListItem();
        listItem.label = null;
        listItem.isUrgent = false;

        listItem.label = inputText.getText().toString();
        toDoList.add(listItem);
        if(urgent.isChecked()){
            listItem.isUrgent = true;
        }
        else{}
        arrayAdapter.notifyDataSetChanged();
        inputText.setText("");
    }
}