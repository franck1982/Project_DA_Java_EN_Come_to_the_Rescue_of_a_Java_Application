package com.hemebiotech.analytics.count;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSymptoms implements ICountSymptoms {
    private HashMap<Object, Object> Counter;

    @Override
    public Map<String , Integer> count(List<String> symptoms){

        Map<String, Integer> symptomsCounter =new HashMap<>();
        for  (String symptom : symptoms) {
            if (symptomsCounter.containsKey(symptom)) {
                symptomsCounter.put(symptom,symptomsCounter.get(symptom)+1);
            } else {
                symptomsCounter.put(symptom,1);
            }
        }
        return symptomsCounter;
    }
}
