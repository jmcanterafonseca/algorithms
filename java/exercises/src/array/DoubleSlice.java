package array;

public class DoubleSlice {
    public static void main(String[] args) {
        int[] A = new int[]{-1,3,-4,5,1,-6,2,1};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int[] sumsUntilElement = new int[A.length];
        int[] sumsFromElement = new int[A.length];

        int sum = A[0];
        for(int j = 1; j < A.length - 1; j++) {
            sumsUntilElement[j] = Math.max(A[j] + sumsUntilElement[j - 1],0);
        }

        sum = A[A.length - 1];
        for(int k = A.length - 2; k>= 1; k--) {
            sumsFromElement[k] = Math.max(A[k] + sumsFromElement[k + 1],0);
        }

        int maxDoubleSlice = Integer.MIN_VALUE;
        for(int j = 2; j < A.length - 1; j++) {
            int sliceSum = sumsUntilElement[j - 1] + sumsFromElement[j + 1];
            if (sliceSum > maxDoubleSlice) {
                maxDoubleSlice = sliceSum;
            }
        }

        return maxDoubleSlice;
    }
}
