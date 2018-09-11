package com.example.kdh.applepi_memo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends BaseAdapter {
    ArrayList<Data> items;
    public Adapter(ArrayList<Data> items){
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item,parent,false);
        }
        Data item = items.get(position);

        TextView title = convertView.findViewById(R.id.item_title);
        TextView content = convertView.findViewById(R.id.item_content);

        title.setText(item.getTitle());
        content.setText(item.getContent());

        return convertView;
    }
}
