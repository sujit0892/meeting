package com.example.marine.meet;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Meetinfo extends AppCompatActivity  {
   TextView description,start,venue,end;
    List<MeetingData> data;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_meetinfo);
          Intent i = getIntent();
          String url = i.getStringExtra("url");


          try {
              data = new XMLparser(this, url).execute().get();
          } catch (InterruptedException e) {
              e.printStackTrace();
          } catch (ExecutionException e) {
              e.printStackTrace();
          }
          setTitle(data.get(0).getName());
          description= (TextView) findViewById(R.id.Description);
          venue= (TextView) findViewById(R.id.venue);
          start= (TextView) findViewById(R.id.start);
          end= (TextView) findViewById(R.id.end);
          description.setText(data.get(0).getDescription());
          venue.setText(data.get(0).getVenue());
          start.setText("start date"+data.get(0).getDate());
          end.setText("end date"+data.get(0).getEnd_date());



      }
}
