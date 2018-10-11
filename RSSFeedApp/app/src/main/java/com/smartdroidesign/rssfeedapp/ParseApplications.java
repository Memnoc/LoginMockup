package com.smartdroidesign.rssfeedapp;

import java.util.ArrayList;

public class ParseApplications {
    private static final String TAG = "ParseApplications";
    private ArrayList<FeedEntry> applications;

    public ParseApplications() {
        this.applications = new ArrayList<>();
    }

    public ArrayList<FeedEntry> getApplications() {
        return applications;
    }

//    public boolean parseStringXMLData(String xmlData) {
//        boolean status =true;
//        FeedEntry currentRecord;
//        boolean inEntry = false;
//        String textValue = "";
//    }

    // Suspended here: minute 2:12 of XML Parsing Factory Classes
}
