package com.damelyngdoh.codemine.wordprecedence;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordPrecedence {
    
    public static void main(String[] args) {
        int n = 0;
        String arr[];
        try(Scanner scan = new Scanner(System.in)) {
            n = scan.nextInt();
            arr = new String[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scan.nextLine();
            }
        }

        System.out.println(findWord(arr));
    }

    public static String findWord(String[] arr) {
        Map<String,String> map = new HashMap<>(arr.length);
        for(String s : arr) {
            String[] tokens = s.split(">");
            map.put(tokens[0], tokens[1]);
        }

        // Finding the first letter
        String first = "";
        for(String s : map.keySet()) {
            if(!map.values().contains(s)) {
                first = s;
                break;
            }
        }

        // Building the string by traversing the map
        StringBuilder str = new StringBuilder(map.size() + 1);
        str.append(first);
        while(map.containsKey(first)) {
            first = map.get(first);
            str.append(first);
        }

        return str.toString();
    }
}
