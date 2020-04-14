package com.hemebiotech.analytics;

import com.hemebiotech.analytics.count.CountSymptoms;
import com.hemebiotech.analytics.count.ICountSymptoms;
import com.hemebiotech.analytics.read.ISymptomReader;
import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.sort.ISortSymptomsByName;
import com.hemebiotech.analytics.sort.SortSymptomsByName;
import com.hemebiotech.analytics.write.IWriteSymptomsDataToFile;
import com.hemebiotech.analytics.write.WriteSymptomsDataToFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {
    private final IWriteSymptomsDataToFile writer;
    private final ISortSymptomsByName sorter;
    private final ISymptomReader reader;
    private final ICountSymptoms counter;


    public AnalyticsCounter(ISymptomReader reader, ICountSymptoms counter, ISortSymptomsByName sorter, IWriteSymptomsDataToFile writer) {
        this.reader = reader;
        this.counter = counter;
        this.writer = writer;
        this.sorter = sorter;
    }

    public void execute() throws Exception {

        //2eme étape: On lit le fichier symptoms.txt
        List<String> allSymptoms = reader.GetSymptoms();


        //3eme étape: On parcours le fichier en comptant les symptoms avec la map.
        Map<String, Integer> symptomsCounter = counter.count(allSymptoms);

        //4eme étape: On range dans l'ordre alphabétique les symtoms.
        List<String> symptoms = sorter.sort(symptomsCounter.keySet());

        //5eme étape: On écrit le fichier result.out
        writer.write(symptoms, symptomsCounter);
    }
}