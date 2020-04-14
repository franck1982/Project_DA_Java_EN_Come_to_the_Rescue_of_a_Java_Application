package com.hemebiotech.analytics.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortSymptomsByName implements ISortSymptomsByName {

    @Override
    public List<String> sort(Collection<String> symptoms){
        List<String> copie = new ArrayList<>(symptoms);
        Collections.sort(copie);
        return copie;
    }
}
