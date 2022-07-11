package com.damelyngdoh.codemine.recursivefibonacci;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecursiveFibonacci {
    
    /**
     * Set memory to cache the Fibonacci elements generated intermediately.
     * In Java, Set operation 'contains' is generally accepted to have a complexity O(1).
     */
    public static Set<Integer> memory = new HashSet<>();

    static {
        memory.add(1);
    }
    public static void main(String[] args) {
        int n;
        int[] numbers;

        try(Scanner scan = new Scanner(System.in)) {
            n = scan.nextInt();
            numbers = new int[n];
            for(int i = 0; i < n; i++) {
                numbers[i] = scan.nextInt();
            }

            // Finding the largest number from the array
            int max = numbers[0];
            for(int i = 1; i < numbers.length; i++) {
                max = numbers[i] <= max ? max : numbers[i];
            }

            // Populating memory with all Fibonacci sequence terms 
            // less than or equal to the maximum/largest element
            // This ensures that the memory is populated with all 
            // possible Fibonacci terms that are required to test all 
            // the elements in the array.
            isFibonacciTerm(max, 1, 1);

            // Iterating over the array to determine if each element 
            // is a term of the Fibonacci series or not
            for(int i = 0; i < numbers.length; i++) {
                System.out.println(numbers[i] + " -> " + isFibonacciTerm(numbers[i], 1, 1));
            }
        }
    }

    /**
     * Recursive method to determine if a number is a term in the Fibonacci Series or not.
     * @param n The number to determine if it forms a part of the Fibonacci Series or not.
     * @param currentTerm The current term in the recursion process.
     * @param previousTerm The previous term.
     * @return true if the number is part of the Fibonacci Series, false otherwise.
     */
    public static boolean isFibonacciTerm(int n, int currentTerm, int previousTerm) {
        if(memory.contains(n)) {
            return true;
        }
        if(n > currentTerm + previousTerm) {
            memory.add(currentTerm + previousTerm);
            return isFibonacciTerm(n, currentTerm + previousTerm, currentTerm);
        }
        if(n == currentTerm + previousTerm) {
            memory.add(n);
            return true;
        }
        return false;
    }
}
