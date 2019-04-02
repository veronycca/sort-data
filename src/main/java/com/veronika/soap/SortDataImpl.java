package com.veronika.soap;

import javax.jws.WebService;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@WebService(endpointInterface = "com.veronika.soap.SortData")
public class SortDataImpl implements SortData {
    @Override
    public String getSortedData(String data) {
        List<String> result = Arrays.asList(data.split("\\s*,\\s*"));
        Collections.sort(result);

        return String.join(", ", result);
    }
}