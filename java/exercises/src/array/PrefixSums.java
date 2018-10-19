package array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrefixSums {
    public static void main(String[] args) {
        int[] testArray = new int[]{21,-6,7,12,1};

        System.out.println("Prefix Sums: " + Arrays.toString(prefixSums(testArray)));

        System.out.println("Suffix Sums: " + Arrays.toString(suffixSums(testArray)));

        System.out.println("Slice Sums: " + Arrays.toString(totalSlice(testArray).toArray(new Integer[0])));

        int[] roadSpots = {2,3,7,5,1,3,9};

        System.out.println("Mushrooms: " + mushrooms(roadSpots,4,6));
    }

    // Calculates the sum of the different slices an Array may have
    public static List<Integer> totalSlice(int[] A) {
        List<Integer> out = new ArrayList<>();

        int[] pSums = prefixSums(A);

        for(int left = 0; left < A.length; left++) {
            for(int right = left; right < A.length; right++) {
                out.add(pSums[right + 1] - pSums[left]);
            }
        }

        return out;
    }

    // Calculates the sequence of spots that allows the mushroom collector to maximize
    // the number of mushrooms collected
    public static int mushrooms(int[] roadSpots, int startingSpot, int numSpots) {
        int max = 0;

        // First the prefix sum is calculated
        int[] pSums = prefixSums(roadSpots);

        // First try to go all to the right (no direction changes)
        int last = startingSpot + numSpots;
        if (last < roadSpots.length) {
            int total = pSums[last] - pSums[startingSpot];
            if (total > max) {
                max = total;
            }
        }

        // Then try to go all to the left (no direction changes)
        int last2 = startingSpot - numSpots;
        if (last2 >= 0) {
            int total = pSums[startingSpot] - pSums[last2];
            if (total > max) {
                max = total;
            }
        }

        // Then try one change of direction i.e. first to the right, come back, then to the left
        if (startingSpot + numSpots >= roadSpots.length) {
            int total = pSums[roadSpots.length] - pSums[startingSpot];
            // As it is needed to go back the remaining steps that have to be taken
            // has to be decreased (*2)
            int remaining = numSpots - ((roadSpots.length - startingSpot - 1) * 2);
            if (remaining > 0) {
                total += pSums[startingSpot] - pSums[startingSpot - remaining];
            }
            if (total > max) {
                max = total;
            }
        }

        // Then try the other change of direction i.e. first to the left, come back, then to the right
        if(startingSpot - numSpots <= 0) {
            int total = pSums[startingSpot];
            int remaining = numSpots - (startingSpot * 2);
            if (remaining > 0) {
                total += pSums[startingSpot + remaining] - pSums[startingSpot];
            }
            if (total > max) {
                max = total;
            }
        }
        return max;
    }

    public static int[] prefixSums(int[] A) {
        // Prefix sums have one element more as P[0] = 0
        int[] out = new int[A.length + 1];

        for(int j = 1; j < out.length; j++) {
            out[j] = out[j - 1] + A [j - 1];
        }

        return out;
    }

    public static int[] suffixSums(int[] A) {
        int[] out = new int[A.length + 1];

        for(int j = 1; j < out.length; j++) {
            out[j] = A[A.length - j] + out[j - 1];
        }

        return out;
    }
}
