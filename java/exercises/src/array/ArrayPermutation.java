package array;

public class ArrayPermutation {

    public static void main(String[] args) {
        int A[]= {4,3,500,2};

        System.out.println(solution(A));
    }

    // This solution in certain cases does not work
    // Check codility (antiSum test cases). It only achieves 75% score
    public static int solution1(int[] A) {
        // write your code in Java SE 8
        if (A == null) {
            return 0;
        }

        if (A.length == 0) {
            return 1;
        }

        int targetSum = 0;
        int arraySum = 0;
        for (int j = 0; j < A.length; j++) {
            targetSum += j + 1;
            arraySum += A[j];
        }

        if (targetSum == arraySum) {
            return 1;
        }

        return 0;
    }

    // This solution achieves 100% score in Codility
    public static int solution(int[] A) {
        int[] hash = new int[A.length + 1];

        for (int j = 0; j < A.length; j++) {
            if (A[j] > 0 && A[j] < hash.length) {
                hash[A[j]] += 1;
            }
        }

        for (int j = 1; j < hash.length; j++) {
            if (hash[j] != 1) {
                return 0;
            }
        }

        return 1;
    }
}
