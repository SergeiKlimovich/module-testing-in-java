package com.epam.moduletesting.template;

import java.util.Map;

import lombok.AllArgsConstructor;

/**
 * The type Template.
 */
@AllArgsConstructor
public class Template {
    private String template;
    private Map<String, String> values;
}
