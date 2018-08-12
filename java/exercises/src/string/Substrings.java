package string;

import java.util.HashSet;

public class Substrings {
    public static void main(String[] args) {
        String test = "jose";
/*
        System.out.println(test.substring(2,3));
        System.out.println(test.substring(0,test.length() - 1));
*/
        System.out.println("Whole string: " + test.substring(0));
        System.out.println("Empty string: " + test.substring(test.length()));

/*
        System.out.println(test.substring(1,4));  */

        HashSet<Integer> hs = new HashSet<>();
    }
}
