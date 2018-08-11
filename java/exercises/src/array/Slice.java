package array;

public class Slice {
        public static void main(String[] args) {
            int[] A = new int[]{10,-5,7,2};

            System.out.println(calculateMaxSum(A));
            System.out.println(calculateMaxSum2(A));
        }

        public static int calculateMaxSum(int[] A) {
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < A.length; j++) {
                int sum = A[j];
                if (A[j] > max) {
                    max = A[j];
                }
                for(int k = j + 1; k < A.length; k++) {
                    sum += A[k];
                    if (sum > max) {
                        max = sum;
                    }
                }
            }

            return max;
        }

    public static int calculateMaxSum2(int[] A) {
        int maxSlice = 0;
        int maxEnding = 0;

        for(int j = 0; j < A.length; j++) {
            maxEnding = Math.max(0, maxEnding + A[j]);
            maxSlice = Math.max(maxSlice, maxEnding);
        }

        return maxSlice;
    }
}
