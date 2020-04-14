package com.hemebiotech.analytics.write;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteSymptomsDataToFile implements IWriteSymptomsDataToFile {

    private String filepath;

    public WriteSymptomsDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void write(List<String> symptoms, Map<String, Integer> symptomsCounter) {
        try{

            FileWriter writer = new FileWriter ("result.out");
            for (String symptom: symptoms){
                writer.write(symptom+"="+symptomsCounter.get(symptom)+"\n");
            }
            writer.close();

        }catch (IOException e){
            System.out.println("erreur d' ecriture pour le fichier:"+filepath);
        }

    }
}
