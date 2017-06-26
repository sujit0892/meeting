package com.example.marine.meet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Constant{
    String url="https://raw.githubusercontent.com/sujit0892/meeting/master/meeting-xml/index.xml";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new XMLparser(this,url).execute();
    }
}
