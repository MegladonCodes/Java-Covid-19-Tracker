package com.Scrape;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SouthAfricaCornavirusTracker{

   public String Stats [] = new String[5];
   String att [] = {"Total Tests", "Positive Cases", "Recoveries", "Deaths"};

    public void fetchStats() {
        {
            try {
                //fetch html doc
                Document doc = Jsoup.connect("https://sacoronavirus.co.za/").get(); //Connect to sacoronavirus website
                Elements temp = doc.select("span[data-value]"); //select data elements to parse

                int i = 0;
                for (Element covid19Stats : temp) {
                  //  System.out.println(covid19Stats.attr("data-value"));
                    Stats[i] = covid19Stats.attr("data-value"); //Save values in array
                    i++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void printStats(){
        for(int j = 0; j < 4; j++){
            System.out.println(att[j] + " " + Stats[j]);
        }
    }


}
