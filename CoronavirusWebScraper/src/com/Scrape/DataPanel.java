package com.Scrape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataPanel extends JPanel {
    //4 fields for each attribute
    SouthAfricaCornavirusTracker sacvt = new SouthAfricaCornavirusTracker();
    String covidWeb = "https://sacoronavirus.co.za/information-about-the-virus-2/";

    DataPanel(){
        //GET STATS
        sacvt.fetchStats();

        JPanel labelPanel = new JPanel();

        //get date
        DateFormat df = new SimpleDateFormat("dd/MM/yyy");
        Date dateobj = new Date();
        String date = df.format(dateobj);

        labelPanel.setBorder(BorderFactory.createTitledBorder("Covid-19 Statistics for South Africa for " + date ));
        labelPanel.setLayout(new GridLayout(1,5,10,10));

        //create labels
        JLabel testLabel = new JLabel("Tests Conducted: " + sacvt.Stats[0]);
                testLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel posCaseLabel = new JLabel("Positive Cases Identified: "+ sacvt.Stats[1]);
                posCaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel RecLabel = new JLabel("Recoveries: "+ sacvt.Stats[2]);
                RecLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel DeathLabel = new JLabel("Deaths: "+ sacvt.Stats[3]);
                DeathLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //add labels to label panel
        labelPanel.add(testLabel);
        labelPanel.add(posCaseLabel);
        labelPanel.add(RecLabel);
        labelPanel.add(DeathLabel);


        //add panel to main panel
        this.setLayout(new FlowLayout());
        this.add(labelPanel);

        //Add button panel
        JPanel buttonPanel = new JPanel();
        //Button to open S covid 19 website
        JButton getCovidFacts = new JButton("Get information about Covid-19");
        getCovidFacts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(java.net.URI.create(covidWeb));
                }
                catch (java.io.IOException x) {
                    System.out.println(x.getMessage());
                }
            }
        });
        JButton placeholder = new JButton("xyz");

        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(getCovidFacts, BorderLayout.CENTER);
        buttonPanel.add(placeholder,BorderLayout.NORTH);

        labelPanel.add(buttonPanel);




        sacvt.printStats();

    }




}
