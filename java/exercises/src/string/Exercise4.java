package string;/* Check whether a string is a palyndrome or not */
/* Even number of chars and only one with an odd number */

public class Exercise4 {
    public static void main(String[] args) {
        String s = args[0];

        System.out.println(isPalyndrome(s));

        System.out.println(isPalyndrome2(s));
    }

    public static boolean isPalyndrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();

        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int totalChars = z - a + 1;
        int[] charCount = new int[totalChars];

        int totalOdd = 0;

        for(char c : chars) {
            int cNum = Character.getNumericValue(c);
            if(cNum <= a || cNum >= z) {
                continue;
            }
            int cIndex = cNum - a;
            charCount[cIndex]++;
            if (charCount[cIndex] % 2 == 0) {
                totalOdd--;
            }
            else {
                totalOdd++;
            }
        }

        if(totalOdd == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    // Solution based on bit masks
    public static boolean isPalyndrome2(String s) {
       char[] chars = s.toLowerCase().toCharArray();
       int bitResult = 0;


        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

       for(char c : chars) {
           int cNum = Character.getNumericValue(c);
           if(cNum <= a || cNum >= z) {
               continue;
           }
           int cIndex = cNum - a;
           bitResult = toggle(bitResult,cIndex);
       }

       return checkExactlyOneBitSet(bitResult);
    }

    public static int toggle(int bitResult,int cIndex) {
        int mask = (1 << cIndex);

        if((bitResult & mask) == 0) {
            bitResult |= mask;
        }
        else {
            bitResult &= ~mask;
        }

        return bitResult;
    }

    public static boolean checkExactlyOneBitSet(int bitResult) {
        return (bitResult & (bitResult - 1)) == 0;
    }
}
