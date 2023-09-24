package com.example.job_application.util;

import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Global {


    public static boolean validField(@NonNull List<TextView> input) {

        List<TextView> passwords = new ArrayList<>();
        for (TextView textView : input) {
            if (textView.getText().toString().isEmpty()) {
                return showTextError(textView, Constants.EMPTY_FIELD_MESSAGE);
            }

            if (textView.getInputType() == 33) {
                Pattern pat = Pattern.compile(Constants.REGEX);
                if (!pat.matcher(textView.getText().toString()).matches()) {
                    return showTextError(textView, Constants.INVALID_EMAIL_PATTERN_MESSAGE);
                }
            }



            if (textView.getInputType() == 129) {
                if (textView.getText().toString().length() < 6) {
                    return showTextError(textView, Constants.INVALID_PASSWORD_LENGTH_MESSAGE);
                }

                char ch = textView.getText().toString().charAt(0);
                if(Character.isUpperCase(ch)){
                    return showTextError(textView, Constants.INVALID_EMAIL_PATTERN_MESSAGE);
                }

                passwords.add(textView);
            }
        }
        for (int i = 0; i < passwords.size(); i++) {
            if (!passwords.get(0).getText().toString().equals(passwords.get(i).getText().toString())) {
                return showTextError(passwords.get(i), Constants.PASSWORD_DOES_NOT_MATCH_MESSAGE);

            }
        }

        return true;
    }


    public static boolean showTextError(TextView textView, String message) {
        textView.setError(message);
        textView.requestFocus();
        return false;
    }


}