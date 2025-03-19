
package LinearandBinarySearch.StringBuilder;


// Write a program that uses StringBuilder to reverse a given string. For example, if the input is "hello", the output should be "olleh".
// Approach:
// Create a new StringBuilder object.
// Append the string to the StringBuilder.
// Use the reverse() method of StringBuilder to reverse the string.
// Convert the StringBuilder back to a string and return it.



public class Reverse {

    public static String reverseString(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(reverseString(str));
    }
}
