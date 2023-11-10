package com.example.smartalarm;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MyGridAdapter extends ArrayAdapter {


    List<Date> dates;
    Calendar currentDate;
    List<Events>events;
    LayoutInflater inflater;
    public MyGridAdapter(@NonNull Context context, List<Date> dates, Calendar currentDate, List<Events>events) {
        super(context, R.layout.single_cell_layout);
        this.dates = dates;
        this.currentDate = currentDate;
        this.events = events;
        inflater = LayoutInflater.from(context);

    }

    public View getView(int position, View convertView, ViewGroup parent){

        Date monthDate = dates.get(position);
        Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.setTime(monthDate);
        int DayNo = dateCalendar.get(Calendar.DAY_OF_MONTH);
        int displayMonth = dateCalendar.get(Calendar.MONTH)+1;
        int displayYear = dateCalendar.get(Calendar.YEAR);
        int currentMonth = currentDate.get(Calendar.MONTH)+1;
        int currentYear = currentDate.get(Calendar.YEAR);



        View view = convertView;
        if(view == null){
            view = inflater.inflate(R.layout.single_cell_layout,parent,false);
        }
        if(displayMonth == currentMonth && displayYear == currentYear){
            view.setBackgroundColor(getContext().getResources().getColor(R.color.lightblue));
        }
        else {
            view.setBackgroundColor(Color.parseColor("#000000"));
        }

        TextView Day_Number = view.findViewById(R.id.calendar_day);

        TextView EventNumber = view.findViewById(R.id.events_id);
        Day_Number.setText(String.valueOf(DayNo));


        return view;
    }




    public  int getCount(){
        return dates.size();
    }
    public int getPosition(Object item){
        return dates.indexOf(item);
    }
    public Object getItem(int position){
        return dates.get(position);
    }
}