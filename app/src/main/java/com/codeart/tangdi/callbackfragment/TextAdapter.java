package com.codeart.tangdi.callbackfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangdi on 7/10/17.
 */

public class TextAdapter extends BaseAdapter{

    private ArrayList<String> strs = new ArrayList<>();

    public TextAdapter(ArrayList<String> list){
        strs = list;
    }

    @Override
    public int getCount() {
        return strs.size();
    }

    @Override
    public Object getItem(int position) {
        return strs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item, parent, false);
        TextView textView = (TextView) view.findViewById(R.id.list_item);
        textView.setText(strs.get(position));
        return view;
    }
}
