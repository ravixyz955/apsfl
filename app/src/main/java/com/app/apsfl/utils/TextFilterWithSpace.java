package com.app.apsfl.utils;

import android.text.InputFilter;
import android.text.Spanned;

public class TextFilterWithSpace implements InputFilter {

    private static final String REGEX = "^[a-zA-Z]+$";

    @Override
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dStart, int dEnd) {
        if (source.equals("")) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = start; i < end; i++) {
            Character character = source.charAt(i);
            if (character.toString().matches(REGEX) || Character.isSpaceChar(character)) {
                builder.append(character);
            }
        }
        return builder.toString();
    }
}