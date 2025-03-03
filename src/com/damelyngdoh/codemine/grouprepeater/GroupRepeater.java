package com.damelyngdoh.codemine.grouprepeater;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GroupRepeater {

    public static void main(String[] args) {
        String input = "2[a2[er]2[t]w]";

        System.out.println(groupRepeater(input));
    }

    /**
     * Process the input string.
     *
     * @param s the input parameter
     * @return the processed string
     */
    public static String groupRepeater(String s) {

        if(Objects.isNull(s) || s.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int start;
        for(int i = 0 ; i < s.length();) {
            // If alphabet encountered then process to get the string
            if(Character.isAlphabetic(s.charAt(i))) {
                for(start = i; i < s.length() && Character.isAlphabetic(s.charAt(i)); i++);
                result.append(s, start, i);
            }

            // If digit is encountered then process to get the count.
            // Count could be more than one digit
            else if(Character.isDigit(s.charAt(i))) {
                int count = 0;
                for(start = i; i < s.length() && Character.isDigit(s.charAt(i)); i++);
                count = Integer.parseInt(s.substring(start,i));

                // Since open bracket is encountered,
                // Find corresponding closing bracket
                int bracketCounter = 0;
                for(bracketCounter = 1, start = ++i; i < s.length() && bracketCounter > 0; i++) {
                    if(s.charAt(i) == '[') {
                        bracketCounter++;
                    }
                    else if(s.charAt(i) == ']') {
                        bracketCounter--;
                    }
                }

                // Process inner pattern and repeat it count times
                result.repeat(groupRepeater(s.substring(start, i - 1)), count);
            }
        }
        return result.toString();
    }
}
