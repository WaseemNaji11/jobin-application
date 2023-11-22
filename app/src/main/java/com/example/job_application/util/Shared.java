package com.example.job_application.util;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.job_application.models.CountryDetailedInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Shared {
    public static List<CountryDetailedInfo> countryInfo = new ArrayList<>();


    public static boolean isPasswordLongEnough(String password) {
        return password.length() > 8;
    }

    public static boolean isValidEmail(String email) {
        // Implement email validation logic here using a regular expression or other methods.
        // Return true if the email is valid; otherwise, return false.
        String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        // Return true if the email matches the pattern, otherwise return false
        return email.matches(emailPattern);
    }
//
//    public static boolean validField(@NonNull List<TextView> input) {
//
//        List<TextView> passwords = new ArrayList<>();
//        for (TextView textView : input) {
//            if (textView.getText().toString().isEmpty()) {
//                return showTextError(textView, Constants.EMPTY_FIELD_MESSAGE);
//            }
//
//            if (textView.getInputType() == 33) {
//                Pattern pat = Pattern.compile(Constants.REGEX);
//                if (!pat.matcher(textView.getText().toString()).matches()) {
//                    return showTextError(textView, Constants.INVALID_EMAIL_PATTERN_MESSAGE);
//                }
//            }
//
//
//
//            if (textView.getInputType() == 129) {
//                if (textView.getText().toString().length() < 6) {
//                    return showTextError(textView, Constants.INVALID_PASSWORD_LENGTH_MESSAGE);
//                }
//
//                char ch = textView.getText().toString().charAt(0);
//                if(Character.isUpperCase(ch)){
//                    return showTextError(textView, Constants.INVALID_EMAIL_PATTERN_MESSAGE);
//                }
//
//                passwords.add(textView);
//            }
//        }
//        for (int i = 0; i < passwords.size(); i++) {
//            if (!passwords.get(0).getText().toString().equals(passwords.get(i).getText().toString())) {
//                return showTextError(passwords.get(i), Constants.PASSWORD_DOES_NOT_MATCH_MESSAGE);
//
//            }
//        }
//
//        return true;
//    }


    public static boolean showTextError(TextView textView, String message) {
        textView.setError(message);
        textView.requestFocus();
        return false;
    }

   public static boolean containsUpperAndLowerCase(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            }
            if (hasUpperCase && hasLowerCase) {
                return true;
            }
        }
        return false;
    }


    public static  boolean containsNumbers(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

}
