package array;

import java.util.HashSet;

/* Checks whether a swap of two elements of the array causes that the sum of both is the same */
public class ArraySum {
    public static void main(String[] args) {
        int[] elements = new int[]{4,5,8,22,12};
        int[] elements2 = new int[]{4,5,8,22,6};

        System.out.println(isSwapEqualSum_O_n2(elements, elements2));
        System.out.println(isSwapEqualSum_O_n(elements, elements2,1000));
    }

    // The time complexity of this algorith is O(n2)
    // Sums are only calculated at the beginning, otherwise time complexity would raise to O(n3)
    public static boolean isSwapEqualSum_O_n2(int[] a1,int[] a2) {
        int sum = sum(a1);
        int sum2 = sum(a2);

        for(int i = 0; i < a1.length; i++) {
            for(int j = 0; j < a2.length; j++) {
                int difference = a2[j] - a1[i];

                sum += difference;
                sum2 -= difference;

                if (sum == sum2) {
                    System.out.println(a2[j] + "," + a1[i]);
                    return true;
                }

                // Cancel out the addition
                sum -= difference;
                sum2 += difference;
            }
        }

        return false;
    }

    // The time complexity of this algorith is O(n)
    public static boolean isSwapEqualSum_O_n(int[] a1,int[] a2,int m) {
        int sum = sum(a1);
        int sum2 = sum(a2);

        int d = sum - sum2;

        if (d % 2 == 1) {
            return false;
        }

        d = d / 2;

        HashSet<Integer> ocurrence = occurs(a1);

        for(int j = 0; j < a2.length; j++) {
            if (a2[j] - d >= 0 &&  a2[j] - d <= m && ocurrence.contains(a2[j] - d)) {
                return true;
            }
        }

        return false;
    }

    // Sums the elements of the array
    public static int sum(int[] arr) {
        int sum = 0;

        for(int e:arr) {
            sum += e;
        }

        return sum;
    }

    // Marks the occurrence of an Array element to be later checked
    public static HashSet<Integer> occurs(int[] arr) {
        HashSet<Integer> hash = new HashSet<>();

        for(int e:arr) {
            hash.add(e);
        }

        return hash;
    }
}
