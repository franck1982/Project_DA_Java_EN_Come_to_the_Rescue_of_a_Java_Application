package com.hemebiotech.analytics;

import com.hemebiotech.analytics.count.CountSymptoms;
import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.sort.SortSymptomsByName;
import com.hemebiotech.analytics.write.WriteSymptomsDataToFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {
	//1ere étape: On déclare une HashMap clé/valeur <> symptoms/occurences
	static Map<String, Integer>  symptomsCounter = new HashMap<>();


	public static void main(String args[]) throws Exception {
		//2eme étape: On lit le fichier symptoms.txt
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> allSymptoms = reader.GetSymptoms();


		//3eme étape: On parcours le fichier en comptant les symptoms avec la map.
        CountSymptoms counter = new CountSymptoms();
        Map<String, Integer> symptomsCounter = counter.count(allSymptoms);

		//4eme étape: On range dans l'ordre alphabétique les symtoms.
		SortSymptomsByName sorter = new SortSymptomsByName();
		List<String> symptoms  = sorter.sort(symptomsCounter.keySet());

		//5eme étape: On écrit le fichier result.out
		WriteSymptomsDataToFile writer = new WriteSymptomsDataToFile("result.out");
		writer.write(symptoms,symptomsCounter);
	}
}