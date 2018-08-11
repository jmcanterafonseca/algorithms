package bitmask;


// Calculates the longest zero string in a number
public class ZeroString {
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);

        System.out.println(calculateMaxZeroString(number));
    }

    private static int calculateMaxZeroString(int number) {
        int mask = 1;

        int maxZeroLength = 0;
        int currentZeroLength = 0;
        int numOnes = 0;

        while(mask != 0) {
            int resultTest = number & mask;

            if (resultTest == 0) {
                if (numOnes == 1) {
                    currentZeroLength++;
                }
            }
            else {
                numOnes++;
                if (numOnes == 2 && currentZeroLength > maxZeroLength) {
                    maxZeroLength = currentZeroLength;
                }
                numOnes = 1;
                currentZeroLength = 0;
            }
            // In  Java there is no logical (unsigned) left shift
            // There are no unsigned numbers in Java
            mask <<= 1;
        }

        return maxZeroLength;
    }
}
