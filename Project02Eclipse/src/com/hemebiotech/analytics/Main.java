package com.hemebiotech.analytics;

import com.hemebiotech.analytics.count.CountSymptoms;
import com.hemebiotech.analytics.count.ICountSymptoms;
import com.hemebiotech.analytics.read.ISymptomReader;
import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.sort.ISortSymptomsByName;
import com.hemebiotech.analytics.sort.SortSymptomsByName;
import com.hemebiotech.analytics.write.IWriteSymptomsDataToFile;
import com.hemebiotech.analytics.write.WriteSymptomsDataToFile;

public class Main {

    public static void main(String[] args) throws Exception {
        ICountSymptoms counter = new CountSymptoms();
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        IWriteSymptomsDataToFile writer = new WriteSymptomsDataToFile("result.out");
        ISortSymptomsByName sorter = new SortSymptomsByName();
        AnalyticsCounter analytics = new AnalyticsCounter(reader, counter, sorter, writer);
        analytics.execute();


    }


}
