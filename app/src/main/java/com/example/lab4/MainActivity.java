package com.example.lab4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // public MyListAdapter myAdapter;
    ArrayAdapter<ListItem> arrayAdapter;

    public ArrayList<ListItem> toDoList;
    public ListView listView;
    public Button button;
    public Switch urgent;
    public EditText inputText;
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
       public View getView(int position, View old, ViewGroup parent){
            View newView = old;
            TextView listText = findViewById(R.id.ListText);
            Switch urgent = findViewById(R.id.Urgent);
            LayoutInflater inflater = getLayoutInflater();

            if(urgent.isChecked()){
                newView.setBackgroundColor(Color.RED);
            }
            LayoutInflater inflater = getLayoutInflater();

            if(newView == null){
                newView = inflater.inflate(R.layout.row_layout, parent, false);
            }

            TextView listText = newView.findViewById(R.id.ListText);
            listText.setText( getItem(position).toString());
           return newView;
        }
    }*/

    public class ListItem{

        String label;
        boolean isUrgent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        toDoList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, R.layout.row_layout,toDoList);

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

        listItem.label = (inputText.getText().toString());

        toDoList.add();
        if(urgent.isChecked()){
            listItem.isUrgent = true;
            listText.setBackgroundColor(Color.RED);
        }
        else{}
        arrayAdapter.notifyDataSetChanged();
        inputText.setText("");
    }

}
// Add listItem to Array
// extend ArrayAdapter to add background