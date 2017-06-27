package com.example.marine.meet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements Constant{
  List<MeetingData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            data= new XMLparser(this,INDEX_URL).execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        RecyclerView meetList=(RecyclerView)findViewById(R.id.meetList);
        meetList.setLayoutManager(new LinearLayoutManager(this));
        HomeAdapter adapter=new HomeAdapter(this,data);
        meetList.setAdapter(adapter);


    }
}
