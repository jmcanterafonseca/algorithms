package sdeonline;

// Given an array,find the maximum j – i such that arr[j] > arr[i]
public class MaxDistanceArray {
    public static void main(String[] args) {
        int[] array = {12, 22, 8, 14, -5};

        System.out.println(solution2(array));
    }

    // This solution is obvious but O(n^2)
    public static int solution(int[] A) {
        int maxDistance = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] > A[i]) {
                    int distance = j - i;
                    maxDistance = Math.max(maxDistance, distance);
                }
            }
        }

        return maxDistance;
    }

    public static int solution2(int[] A) {
        int n = A.length;

        int[] RMax = new int[n];
        int[] LMin = new int[n];

        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = A[0];
        for (int i = 1; i < n; ++i) {
            LMin[i] = Math.min(A[i], LMin[i - 1]);
        }

        /* Construct RMax[] such that RMax[j] stores the maximum value
        from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = A[n - 1];
        for (int j = n - 2; j >= 0; --j) {
            RMax[j] = Math.max(A[j], RMax[j + 1]);
        }

        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        int i = 0, j = 0;
        int maxDiff = -1;
        while (j < n && i < n) {
            if (LMin[i] < RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDiff;
    }
}

