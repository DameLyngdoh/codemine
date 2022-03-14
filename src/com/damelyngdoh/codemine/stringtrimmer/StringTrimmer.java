package com.damelyngdoh.codemine.stringtrimmer;

import java.util.Scanner;

/**
 * @author Dame Lyngdoh
 */
public class StringTrimmer {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		
        String str = in.nextLine();
        int k = in.nextInt();
        
		in.close();
        
        System.out.println(trimString(str, k));
    }

    /**
     * Trims a string to at most a specific length witouth trimming the last word.
     * 
     * @param str Input string.
     * @param k Maximum number of characters in the trimmed string.
     * @return Trimmed string.
     */
    public static String trimString(String str, int k) {
        if(k == 0) {
            return "";
        }
        if(str.length() <= k) {
            return str;
        }

        // If (k - 1)th character is space
        // Return the substring from 0 to k - 1
        if(str.charAt(k - 1) == ' ') {
            return str.substring(0, k - 1);
        }
        
        if(str.charAt(k) == ' ') {
            return str.substring(0, k);
        }

        // Find the space immediately before k
        for(k--; k >= 0 && str.charAt(k) != ' '; k--);
        return k >= 0 ? str.substring(0, k) : "";
    }
}
