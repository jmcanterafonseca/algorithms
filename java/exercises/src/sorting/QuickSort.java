package sorting;

public class QuickSort {
    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }

        int[] array = new int[args.length];

        for(int i = 0; i < args.length; i++) {
            array[i] = Integer.parseInt(args[i]);
        }

        quickSort(array,0,array.length - 1);

        System.out.println("Quick Sort: ");
        for (int v:array) {
            System.out.println(v);
        }

        bubbleSort(array);

        System.out.println("Bubble Sort: ");
        for (int v:array) {
            System.out.println(v);
        }
    }

    // O(n logn) but worst case could be O(n^2)
    public static void quickSort(int[] array,int left,int right) {
        int index = partition(array,left,right);

        if (left < index - 1) {
            quickSort(array,left,index - 1);
        }
        if (index < right) {
            quickSort(array,index,right);
        }
    }

    private static int partition(int[] array,int left,int right) {
        int pivot = array[(left + right)/2];
        while(left <= right) {
            while (array[left] < pivot) left++;

            while (array[right] > pivot) right--;

            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }

        return left;
    }

    // O(n^2)
    public static void bubbleSort(int[] array) {
        for(int j = 0; j < array.length; j++) {
            for(int i = j; i < array.length; i++) {
                if (array[j] > array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
}
