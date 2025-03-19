package LinearandBinarySearch.StringBuilder;

import java.util.HashSet;

// Problem:
// Write a program that uses StringBuilder to remove all duplicate characters from a given string while maintaining the original order.
// Approach:
// Initialize an empty StringBuilder and a HashSet to keep track of characters.
// Iterate over each character in the string:
// If the character is not in the HashSet, append it to the StringBuilder and add it to the HashSet.
// Return the StringBuilder as a string without duplicates.



public class Duplicate {

    public static String removeDuplicates(String str){
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for(char c: str.toCharArray()){
            if(!set.contains(c)){
                sb.append(c);
                set.add(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String str = "hello";
        System.out.println(removeDuplicates(str));

    }
}
