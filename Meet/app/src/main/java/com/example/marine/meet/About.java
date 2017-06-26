package com.example.marine.meet;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by marinex on 26/6/17.
 */

public class About extends Fragment {

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle bundle){
    View v=inflater.inflate(R.layout.about,group,false);
    return v;
}
}
