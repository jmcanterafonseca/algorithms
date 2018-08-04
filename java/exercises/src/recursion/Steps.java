package recursion;

// Cracking the coding interview exercise 8.1
public class Steps {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // System.out.println(countWays(n));

        System.out.println(countWays2(n));
    }

    // n is the number of steps
    public static int countWays(int n) {
        if(n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

       // Recursive calls end up with O(2^n) - too much!
       return countWays(n - 1)  + countWays(n - 2) + countWays(n - 3);
    }

    // Uses the memoization technique so that O(n) is achieved
    public static int countWays2(int n) {
        return countWays(n, new int[n]);
    }

    public static int countWays(int n,int[] memo) {
        if(n < 0) {
            return 0;
        }

        memo[0] = 1;

        for(int j = 1; j < n; j++) {
            int value1 = memo[j - 1];
            int value2 = (j - 2) < 0 ? 0 : memo[j - 2];
            int value3 = (j - 3) < 0 ? 0 : memo[j - 3];
            memo[j] = value1 + value2 + value3;
        }

        return memo[n - 1] + memo[n - 2] + memo[n - 3];
    }
}
