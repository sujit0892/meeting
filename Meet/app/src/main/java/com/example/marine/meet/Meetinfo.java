package com.example.marine.meet;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Meetinfo extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    ViewPager pager;
    TabLayout tabLayout;
    List<MeetingData> data;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetinfo);
       Intent i=getIntent();
        String url=i.getStringExtra("url");
        Toast.makeText(this,url, Toast.LENGTH_SHORT).show();

        try {
            data= new XMLparser(this,url).execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
       Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("About"));
        tabLayout.addTab(tabLayout.newTab().setText("Venue"));
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);
        pager= (ViewPager) findViewById(R.id.pager);
        tabAdapter adapter=new tabAdapter(data,getSupportFragmentManager(),tabLayout.getTabCount());
        pager.setAdapter(adapter);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

}
