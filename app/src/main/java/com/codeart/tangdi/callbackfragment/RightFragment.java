package com.codeart.tangdi.callbackfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by tangdi on 7/10/17.
 */

public class RightFragment extends Fragment{

    private RightCallBack rightCallBack;

    private EditText editText;

    private int postion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle saveInstanceBundel){

        View view = inflater.inflate(R.layout.second_fragment, viewGroup, false);
        editText = (EditText) view.findViewById(R.id.tv);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                rightCallBack.CallBackStr(s.toString(), postion);
            }
        });
        return view;
    }




    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        rightCallBack = (RightCallBack) context;
    }

    public interface RightCallBack{
        void CallBackStr(String val, int postion);
    }

    public void setListViewString(ArrayList<String> arrayList, int postion){
        this.postion = postion;
        editText.setText(arrayList.get(postion));
    }
}
