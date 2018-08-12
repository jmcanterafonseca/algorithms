package array;

import java.util.*;


class Solution {
    public int solution(int M, int[] A) {
        return solution_O_N(M,A);
    }

    public int solution2(int M, int[] A) {
        return solution_O_N_2(M,A);
    }

    // This solution has a time complexity O(N^2)
    public int solution_O_N_2(int M, int[] A) {
        // write your code in Java SE 8
        int numSlices = 0;
        for(int j = 0; j < A.length; j++) {
            HashSet<Integer> set = new HashSet<>();

            for(int k = j; k < A.length; k++) {
                if(!set.contains(A[k])) {
                    numSlices++;
                    set.add(A[k]);
                }
                else {
                    break;
                }
            }
        }

        return numSlices;
    }

    // Use the caterpillar method to obtain O(n) time complexity
    public int solution_O_N(int M, int[] A) {
        int numSlices = 0;

        HashSet<Integer> set = new HashSet<>();
        int front = 0;
        int back = 0;
        int N = A.length;

        while (front < N && back < N) {
            while (front < N && !set.contains(A[front])) {
                numSlices += (front - back) + 1;
                set.add(A[front]);
                front++;
            }

            while (back < N && front < N && A[front] != A[back]) {
                set.remove(A[back]);
                back++;
            }

            set.remove(A[back]);
            back++;
        }

        return numSlices;
    }
}

public class CountDistinctSlides {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = new int[]{1,-8,9,10,12,1,-8};

        int result = s.solution(22,arr);
        int result2 = s.solution2(22,arr);

        System.out.println(result2);

        System.out.println(result);
    }
}
