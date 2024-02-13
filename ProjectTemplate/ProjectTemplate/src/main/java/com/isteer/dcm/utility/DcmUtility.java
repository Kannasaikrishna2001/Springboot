package com.isteer.dcm.utility;

public class DcmUtility {
    public static String getStacktraceSubString(String stackTrace) {
        String[] words = stackTrace.split("\\s+");
        StringBuilder result = new StringBuilder();
        int wordCount = 0;
        for (String word : words) {
            if (wordCount >= 1000) {
                break;
            }
            result.append(word).append(" ");
            wordCount++;
        }
        return result.toString().trim();
    }

}