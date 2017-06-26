package com.example.marine.meet;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by marinex on 26/6/17.
 */

public class HomeHolder extends RecyclerView.ViewHolder {
    TextView name,date,reminder;
    public HomeHolder(View itemView) {
        super(itemView);
        name=(TextView)itemView.findViewById(R.id.name);
        date=(TextView)itemView.findViewById(R.id.date);
        reminder=(TextView)itemView.findViewById(R.id.reminder);
    }
}
