package com.example.marine.meet;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by marinex on 25/6/17.
 */

public class XMLparser extends AsyncTask<List<MeetingData>,Void,List<MeetingData>> implements Constant{

    String url;
    Context context;
    ProgressDialog pdialog;
    XmlPullParserFactory xmlPullParserFactory;

    public XMLparser(Context context,String url)
    {
        this.context=context;
        this.url=url;
    }

    @Override
    protected void onPreExecute(){
        pdialog=new ProgressDialog(context);
        pdialog.setTitle("please wait");
        pdialog.show();
    }

    @Override
    protected List doInBackground(List... lists) {
        try {
           URL url=new URL(this.url);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            InputStream stream=connection.getInputStream();
            List<MeetingData> meetingdata=new ArrayList<MeetingData>();

           xmlPullParserFactory=XmlPullParserFactory.newInstance();
            XmlPullParser parser=xmlPullParserFactory.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            parser.setInput(stream,null);



            meetingdata=parse(parser);

            stream.close();

            return meetingdata;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (XmlPullParserException e) {
            e.printStackTrace();
            return null;
        }

    }

    private List<MeetingData> parse(XmlPullParser parser) throws XmlPullParserException, IOException {
        int event;
        String result = null,text=null;
        List<MeetingData> data=new ArrayList<MeetingData>();
        event=parser.getEventType();
        MeetingData meeting=null;
        while (event!=XmlPullParser.END_DOCUMENT){
            String name=parser.getName();
            switch (event)
            {
                case XmlPullParser.START_TAG:
                    if(name.equalsIgnoreCase(MEETING_TAG))
                        meeting=new MeetingData();

                    break;
                case XmlPullParser.TEXT: text=parser.getText();
                    break;
                case XmlPullParser.END_TAG:
                    if (name.equals(MEETING_TAG))
                    {
                        data.add(meeting);

                    }
                    if (name.equals(NAME_TAG))
                    {
                        meeting.setName(text);

                    }
                    if(name.equals(VENUE_TAG))
                    {
                        meeting.setVenue(text);
                    }
                    if(name.equals(START_DATE))
                    {
                        meeting.setDate(text);
                    }
                    if (name.equals(XML_URL))
                    {
                        meeting.setUrl(text);
                    }

                    break;
            }
            event=parser.next();
        }

        return data;
    }

    @Override
    protected void onPostExecute(List<MeetingData> meetingData)
    {    pdialog.dismiss();

       
    }


}

