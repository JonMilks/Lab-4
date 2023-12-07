package com.example.lab4;

import static android.graphics.Color.RED;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // public MyListAdapter myAdapter;
    ArrayAdapter<String> arrayAdapter;

    public ArrayList<String> toDoList;
    public ListView listView;
    public Button button;
    public Switch urgent;
    public EditText editText;
    public TextView listText;

    /*public class MyListAdapter extends BaseAdapter{
        public ArrayList<String> toDoList = new ArrayList<>();


        @Override
        public int getCount() {
            return toDoList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View old, ViewGroup parent) {
            View newView = old;
            LayoutInflater inflater = getLayoutInflater();

            if(newView == null){
                newView = inflater.inflate(R.layout.row_layout, parent, false);
            }

            TextView listText = newView.findViewById(R.id.ListText);
            listText.setText( getItem(position).toString());
           return newView;
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        toDoList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, R.layout.row_layout,toDoList);

       // myAdapter = new MyListAdapter();
        listView = findViewById(R.id.list);
        button = findViewById(R.id.add);
        EditText input = findViewById(R.id.inputText);
        urgent = findViewById(R.id.urgent);


        listView.setAdapter(arrayAdapter);
        String listText = input.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });



    }

    public void addItem(View view){
        toDoList.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        editText.setText("");
    }

}
