package array;

public class EquiPrefixSuffix {
        public static void main(String[] args) {
            int[] A = new int[]{-1,3,-4,5,1,-6,2,1};
            System.out.println(solution(A));

            System.out.println(solution2(A));
        }

        public static int solution(int[] A) {
            if(A == null) {
                return -1;
            }

            int sumLeft = 0;
            int index = -1;

            for (int j = 0; j < A.length; j++) {
                sumLeft+=A[j];
                int sumRight = 0;
                for(int k = j; k < A.length; k++) {
                   sumRight+=A[k];
                }
                if (sumRight == sumLeft) {
                    index = j;
                }
            }

            return index;
        }


    public static int solution2(int[] A) {
        if(A == null) {
            return -1;
        }

        int index = -1;

        int[] solutions = new int[A.length];
        int sumLeft = 0;

        for (int j = 0; j < A.length; j++) {
            sumLeft+=A[j];
            solutions[j] = sumLeft;
        }

        int sumRight = 0;
        for (int k = A.length - 1; k>=1; k--) {
            sumRight += A[k];
            int leftCorrespondant = k;
            if (solutions[leftCorrespondant] == sumRight) {
                index = k;
                System.out.println(index);
            }
        }

        return index;
    }
}
