package com.example.marine.meet;

/**
 * Created by root on 17/6/17.
 */

public class MeetingData {
    private String name;
    private String venue;
    private String date;
    private String url;
    private String end_date;
    private String description;

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
    public String getEnd_date(){return end_date;}
    public String getDescription(){ return description;}
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
    public void setDate(String date)
    {
        this.date=date;
    }
public void setEnd_date(String end_date){this.end_date=end_date;}
    public void setDescription(String description){this.description=description;}
}

