package com.oceanize.animationapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Item> {
    private final Context context;
List<Item>items;

    public ListAdapter(Context context, List<Item>items) {
        super(context, -1, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.Name);

        textView.setText(items.get(position).Name);
        // change the icon for Windows and iPhone


        return rowView;
    }
}