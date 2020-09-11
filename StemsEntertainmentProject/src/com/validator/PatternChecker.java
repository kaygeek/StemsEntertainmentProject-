package com.validator;

import javax.swing.JTextField;

/**
 * @author Kgaugelo
 */
public class PatternChecker
{
    public static String getInputValue(JTextField text) {
        int size = text.getText().length();
        return size > 0 ? text.getText().trim() : "";
    }
}