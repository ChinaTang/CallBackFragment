package com.codeart.tangdi.callbackfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tangdi on 7/10/17.
 */

public class LeftFragment extends Fragment{

    private ListView listView;

    private ArrayList<String> arrayList;

    private TextAdapter adapter;

    private LeftCallBack leftCallBack;

    @Override
    public void onCreate(Bundle saveInstance){
        super.onCreate(saveInstance);
        arrayList = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            arrayList.add("arryList" + i);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle saveInstanceBundel){
        View view = inflater.inflate(R.layout.left_fragment, viewGroup, false);
        listView = (ListView)view.findViewById(R.id.listView);
        adapter = new TextAdapter(arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                leftCallBack.LeftCallBack(arrayList, position);
            }
        });
        return view;
    }



    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        leftCallBack = (LeftCallBack)context;
    }

    public interface LeftCallBack{
        void LeftCallBack(ArrayList<String> src, int postion);
    }

    public void notifyListView(){
        adapter.notifyDataSetChanged();
    }

}
