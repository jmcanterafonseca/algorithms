package sdeonline;

import java.util.Arrays;

public class RemoveAlternateDuplicateChars {
    public static void main(String[] args) {
        String test = "you got beautiful eyes";

        System.out.println(solution(test));
    }

    public static String solution(String s) {
        int[] ocurrences = new int[128];

        char[] chars = s.toCharArray();

        int i = 0;
        for(char c:chars) {
            ocurrences[c]++;
            if(ocurrences[c] % 2 == 0) {
                chars[i] = (char)-1;
            }
            i++;
        }

        i = 0;
        while(i < s.length()) {
            if (chars[i] == -1) {
                int next = i + 1;
                while(chars[next] != -1) {
                    chars[i++] = chars[next];
                    chars[next] = 0;
                }
            }
            else {
                i++;
            }
        }

        return new String(chars);
    }
}
