package com.epam.moduletesting.template;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Template.
 */
@AllArgsConstructor
@Data
public class Template {
    private String template;
    private Map<String, String> values;
}
