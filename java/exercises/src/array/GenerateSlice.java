package array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenerateSlice {
    public static void main(String[] args) {
        int[] arr = new int[]{1,-8,9,10,12};

        List<int[]> slices = new ArrayList<>();

        for(int j = 0; j < arr.length; j++) {
            int sliceSize = 1;
            for(int k = j; k < arr.length; k++) {
                int[] slice = new int[sliceSize];
                System.arraycopy(arr,j,slice,0,k - j + 1);

                slices.add(slice);

                sliceSize++;
            }
        }

        printSlices(slices);
    }

    public static void printSlices(List<int[]> slices) {
        Iterator<int[]> it = slices.iterator();
        while(it.hasNext()) {
            int[] element = it.next();

            System.out.print("[");
            for(int i = 0; i < element.length; i++) {
                System.out.print(element[i]);
                if (i + 1 < element.length) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
    }
}
