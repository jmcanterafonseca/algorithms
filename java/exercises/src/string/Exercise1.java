package string;// Ask interviewer whether it is an ASCII string or a Unicode string
// if length > 128 and ASCII, then return true
// Use an array of 128 boolean positions

/* Checks whether a String has unique chars or not */

public class Exercise1 {
    public static void main(String[] args)  {
        // O(n2)

        String s = args[0];

        System.out.println(isUniqueChar2(s));

        System.out.println(isUniqueChar(s));
    }

    // This implementation sucks a bit
    public static boolean isUniqueChar2(String s) {
        // Tests: s="abcde" (false) s2="cdabnma" (true) 'a' appears two times)

        boolean result = true;

        for (int j = 0; j < s.length() && !result; j++) {
            char c = s.charAt(j);
            for(int k = j +  1; k < s.length(); k++) {
                if (s.charAt(k) == c) {
                    result = true;
                    break;
                }
                else {
                    result = false;
                }
            }
        }

        return result;
    }

    // O(n)
    public static boolean isUniqueChar(String s) {
        // Boolean is initialized to false
        // Assumption is chars are within the ASCII charset
        boolean[] charSet = new boolean[128];

        for(int j = 0; j < s.length(); j++) {
            if (charSet[s.charAt(j)]) {
                return false;
            }

            charSet[s.charAt(j)] = true;
        }

        return true;
    }

    // Complexity :
}
