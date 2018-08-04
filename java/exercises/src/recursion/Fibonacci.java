package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        System.out.println(fibonacci(n));

        System.out.println(fibonacci2(n));

        System.out.println(fibonacci3(n));
    }

    // Obtains the nth Fibonacci number
    // Without the memoization technique the runtime would be O(2^n)
    // With the memoization technique the runtime is O(n)
    public static int fibonacci(int n) {
        return fibonacci(n,new int[n]);
    }

    public static int fibonacci(int n, int[] memo) {
        if (n == 0) {
            return 0;
        }

        if(n == 1) {
            return 1;
        }

        if (memo[n - 1] == 0) {
            memo[n - 1] = fibonacci(n - 1,memo);
            memo[n - 2] = fibonacci(n - 2,memo);
        }

        return memo[n - 1] + memo[n - 2];
    }

    // Non recursive version O(n)
    public static int fibonacci2(int n) {
        if (n == 0) {
            return 0;
        }

        int[] memo = new int[n];

        memo[0] = 0;
        memo[1] = 1;

        for(int j = 2; j < n; j++) {
            memo[j] = memo[j - 1] + memo[j - 2];
        }

        return memo[n - 1] + memo[n -2];
    }

    // Non recursive version O(n)
    public static int fibonacci3(int n) {
        if (n == 0) {
            return 0;
        }

        // n - 2
        int value2 = 0;
        // n - 1
        int value1 = 1;

        for (int i = 2; i < n; i++) {
            int nextValue = value1 + value2;
            value2 = value1;
            value1 = nextValue;
        }

        return value1 + value2;
    }
}
