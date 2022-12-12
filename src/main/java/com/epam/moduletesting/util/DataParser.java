package com.epam.moduletesting.util;

import com.epam.moduletesting.template.Template;

public class DataParser {

    public <T> T parseData(Class<T> clazz, String data) {
        return (T) (clazz.equals(Template.class)
                ? parseTemplate(data)
                : parseClient(data));
    }

    private Object parseClient(String data) {
        return null;
    }

    private Object parseTemplate(String data) {
        return null;
    }
}
