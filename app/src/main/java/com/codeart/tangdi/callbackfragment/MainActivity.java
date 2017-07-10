package com.codeart.tangdi.callbackfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by tangdi on 7/10/17.
 */

public class MainActivity  extends AppCompatActivity implements RightFragment.RightCallBack, LeftFragment.LeftCallBack{

    private LeftFragment leftFragment;

    private RightFragment rightFragment;

    private FragmentManager fragmentManager;

    private ArrayList<String> src;

    @Override
    public void onCreate(Bundle saveInstance){
        super.onCreate(saveInstance);
        setContentView(R.layout.main_activity);
        leftFragment = new LeftFragment();
        rightFragment = new RightFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.left_fragme, leftFragment)
                .add(R.id.rigth_frame, rightFragment)
                .commit();
    }

    @Override
    public void CallBackStr(String val, int postion) {
        src.remove(postion);
        src.add(postion, val);
        leftFragment.notifyListView();
    }


    @Override
    public void LeftCallBack(ArrayList<String> src, int postion) {
        this.src = src;
        rightFragment.setListViewString(src, postion);
    }
}
