/**
 *
 *   Taken directly from "Cracking the coding interview"
 *
 *   (Gayle Laakmann)
 *
 *   Idea is to divide the array to be sorted in two halves, sort each one and then merge
 *
 *   There is an intermediate array helper that holds partial results and the final ordered array is the original one
 *
 *   by comparing each half and swapping the elements
 *
 *   There is a final step which consists of copying remaining elements on the left.
 *
 *   For the right part is not necessary because it is already there
 *
 *
 *
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{22, 10, 67, 55, 5, 47, 99, 4, 1,-8};
        mergesort(array);

        for(int j = 0; j < array.length; j++) {
            System.out.print(array[j] + ",");
        }

        mergesort(new int[]{});
    }

    public static void mergesort(int[] array) {
        // Need helper to perform sort
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }

    public static void mergesort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergesort(array, helper, low, middle);
            mergesort(array, helper, middle + 1, high);
            merge(array, helper, low, middle, high);
        }
    }

    public static void merge(int[] array, int[] helper, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = middle - helperLeft;
        System.out.println(remaining);

        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }
}
