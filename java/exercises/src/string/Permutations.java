package string;

import java.util.ArrayList;
import java.util.List;

// String character permutations (no dup characters)
public class Permutations {
    public static void main(String[] args) {
        String input = args[0];

        List<String> perms = getPermutations(input);
        List<String> perms2 = getPermutations2(input);

        for(String str:perms) {
            System.out.println(str);
        }

        for(String str:perms2) {
            System.out.println(str);
        }
    }

    public static List<String> getPermutations(String in) {
        if(in == null) {
            return null;
        }

        List<String> out = new ArrayList<>();

        if(in.length() == 0) {
            out.add("");
            return out;
        }

        char first = in.charAt(0);
        String remainder = in.substring(1);

        List<String> permutations = getPermutations(remainder);

        // Substring function works with indexes from 0 to string lenght
        for(String permutation:permutations) {
            for(int c = 0; c <= permutation.length(); c++) {
                String completePerm = permutation.substring(0,c) + first +
                            permutation.substring(c);
                out.add(completePerm);
            }
        }

        return out;
    }

    public static List<String> getPermutations2(String in) {
        if(in == null) {
            return null;
        }

        List<String> out = new ArrayList<>();

        if(in.length() == 0) {
            out.add("");
            return out;
        }
        for(int j = 0; j < in.length(); j++) {
            String before = in.substring(0,j);
            String after = in.substring(j+1,in.length());

            char ch = in.charAt(j);

            List<String> perms = getPermutations(before + after);

            for(String perm:perms) {
                out.add(ch + perm);
            }
        }

        return out;
    }
}
