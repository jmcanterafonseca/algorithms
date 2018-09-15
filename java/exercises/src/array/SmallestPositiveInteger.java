package array;

import java.util.HashSet;

public class SmallestPositiveInteger {

    public static void main(String[] args) {
        int[] testArray = new int[]{1,5,-32,5};

        System.out.println(solution(testArray));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null) {
            return 1;
        }

        if (A.length == 0) {
            return 1;
        }

        int smallest = 1;
        int nextCandidate = 2;

        HashSet<Integer> occurs = new HashSet<>();

        for (int j = 0; j < A.length; j++) {
            if (A[j] > 0) {
                occurs.add(A[j]);

                if (A[j] == smallest) {
                    smallest = nextCandidate;
                    nextCandidate = findNextCandidate(occurs, nextCandidate);
                } else if (A[j] == nextCandidate) {
                    nextCandidate = findNextCandidate(occurs, nextCandidate);
                }
            }
        }

        return smallest;
    }

    public static int findNextCandidate(HashSet<Integer> occurs, int current) {
        int next = current + 1;
        while (occurs.contains(next)) {
            next++;
        }

        return next;
    }
}
