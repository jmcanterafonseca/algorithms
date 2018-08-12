package array;

public class Caterpillar {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,12,3,6,6};

        System.out.println(caterpillar(arr,11));
    }

    public static boolean caterpillar(int[] A,int s) {
        int n = A.length;

        int front = 0;
        int total = 0;

        for(int j = 0; j < n; j++) {
            while(front < n && total + A[front] <=s) {
                total += A[front];
                front++;
            }
            if (total == s) {
                return true;
            }
            total -= A[j];
        }

       return false;
    }
}
