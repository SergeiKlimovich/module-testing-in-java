package com.epam.moduletesting.util;

import java.util.HashMap;
import java.util.Map;

import com.epam.moduletesting.Client;
import com.epam.moduletesting.template.Template;

public class DataParser {

    public <T> T parseData(Class<T> clazz, String data) {
        return (T) (clazz.equals(Template.class)
                ? parseTemplate(data)
                : parseClient(data));
    }

    private Object parseClient(String data) {
        return new Client(data.split("\n")[2]);
    }

    private Object parseTemplate(String data) {
        Map<String, String> values = new HashMap<>();
        String[] splitData = data.split("\n");
        for (String pair : splitData[1].split(",")) {
            String[] dataPair = pair.split("=");
            values.put(dataPair[0], dataPair[1]);
        }
        return new Template(splitData[0], values);
    }
}
