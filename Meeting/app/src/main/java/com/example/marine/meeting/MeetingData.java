package com.example.marine.meeting;

/**
 * Created by root on 17/6/17.
 */

public class MeetingData {
    private String name;
    private String venue;
    private String date;
    private String url;

    public MeetingData(){
        this.name=null;
        this.venue=null;
        this.url=null;
        this.date=null;
    }
    public String getName()
    {
        return this.name;

    }
    public String getVenue()
    {
        return venue;
    }
    public String getUrl()
    {
        return url;
    }
    public String getDate()
    {
        return date;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setVenue(String venue)
    {
        this.venue=venue;
    }
    public void setUrl(String url)
    {
        this.url=url;
    }
    public void setDate(String datea)
    {
        this.date=datea;
    }
}

