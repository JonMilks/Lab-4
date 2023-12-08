package com.example.lab4;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<ListItem> {


    public MyListAdapter(@NonNull Context context, int resource, @NonNull List<ListItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View SGV = super.getView(position, convertView, parent);
        if(getItem(position).isUrgent) {
            SGV.setBackgroundColor(Color.RED);
        }
        else{
            SGV.setBackgroundColor(Color.WHITE);
        }
        return SGV;
    }
}
