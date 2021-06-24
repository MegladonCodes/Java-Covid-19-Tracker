package com.Scrape;

import javax.swing.*;

public class CoronaMain{
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        //Add icon

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame myFrame = new JFrame();

                myFrame.setLocationRelativeTo(null);
                myFrame.setTitle("Covid-19 Tracker");
                myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                ImageIcon img = new ImageIcon("C:\\Users\\hasgo\\Desktop\\JAVA PROJECTS\\WebScraper\\CoronavirusWebScraper\\covid.jpg");
                myFrame.setIconImage(img.getImage());
                DataPanel dp = new DataPanel();
                myFrame.add(dp);
                myFrame.setVisible(true);
                myFrame.pack();
                myFrame.setResizable(false);
            }
        });

    }
}
