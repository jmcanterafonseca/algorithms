package string;// Analyse
// Ask the interviewer about extra details
// dog,god == true
// dog,gos == false
// Another way of doing it is sorting the strings and then compare

/* Check whether a String is a permutation of another string */
public class Exercise2 {
    public static void main(String[] args)  {
        String s1 = args[0];
        String s2 = args[1];

        System.out.println(permutation3(s1,s2));

        System.out.println(permutation(s1,s2));

        System.out.println(permutation2(s1,s2));
    }

    // This implementation sucks a bit
    public static boolean permutation3(String s1,String s2) {
        boolean result = true;

        if(s1.length() == s2.length()) {
            for(int j = 0; j < s1.length(); j++) {
                boolean found = false;
                for(int k = 0; k < s2.length(); k++) {
                    if(s2.charAt(k) == s1.charAt(j)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    public static boolean permutation(String sa,String sb) {
        if (sa.length() != sb.length()) {
            return false;
        }

        return sort(sa).equals(sort(sb));
    }

    public static String sort(String s) {
        char[] content = s.toCharArray();

        java.util.Arrays.sort(content);

        return new String(content);
    }

    public static boolean permutation2(String sa,String sb) {
        if (sa.length() != sb.length()) {
            return false;
        }

        // Initialized to 0
        int[] count = new int[128];

        for(int j = 0; j < sa.length(); j++) {
            count[sa.charAt(j)]++;
        }

        for(int k = 0; k < sb.length(); k++) {
            count[sb.charAt(k)]--;
            if (sb.charAt(k) < 0) {
                return false;
            }
        }

        return true;
    }
}
