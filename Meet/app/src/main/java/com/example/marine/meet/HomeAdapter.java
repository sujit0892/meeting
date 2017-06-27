package com.example.marine.meet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marinex on 26/6/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeHolder> {
    List<MeetingData> data=new ArrayList<MeetingData>();
    Context context;
    List<MeetingData> data1;

    public HomeAdapter(Context context, List<MeetingData> data){
        this.data= data;
        this.context=context;

    }
    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=(LayoutInflater.from(parent.getContext())).inflate(R.layout.home_holder,parent,false);
        return new HomeHolder(v);
    }

    @Override
    public void onBindViewHolder(HomeHolder holder, final int position) {
     holder.name.setText(data.get(position).getName());
        holder.date.setText(data.get(position).getDate());
        holder.reminder.setText("reminder");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url=data.get(position).getUrl();
              //XMLparser x= new XMLparser(context,url);
                //data1= (List<MeetingData>) x.execute();
                //Toast.makeText(context, data1.get(0).getName(), Toast.LENGTH_SHORT).show();
                Intent i=new Intent(context,Meetinfo.class);
                i.putExtra("url",url);
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
