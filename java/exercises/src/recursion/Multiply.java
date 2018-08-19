package recursion;

// Multiplies two numbers using a recursive function
public class Multiply {
    public static class Result {
        public int value = 0;
    }

    public static void main(String[] args) {
        Integer a = Integer.parseInt(args[0]);
        Integer b = Integer.parseInt(args[1]);

        Result result = new Result();

        multiply(a,b,result);

        System.out.println(result.value);

        System.out.println(multiply2(a,b));
    }

    // Naive solution. O(b). It should check what is the smaller number so that
    // the number of recursive calls is minimized
    public static void multiply(int a, int b,Result r) {
        if (b == 0) {
            return;
        }

        r.value += a;
        multiply(a,b - 1, r);
    }

    public static int multiply2(int a, int b) {
        int bigger = a > b ? a : b;
        int smaller = a < b ? a : b;

        return minProductHelper2(smaller, bigger);
    }

    // Less optimized version it duplicates some of the calculations
    public static int minProductHelper(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        }

        if (smaller == 1) {
            return bigger;
        }

        // Divide by two
        int s = smaller >> 1;
        int side1 = minProductHelper(s, bigger);

        int side2 = side1;
        // Odd numbers
        if (smaller % 2 == 1) {
            side2 = minProductHelper(smaller - s,bigger);
        }

        return side1 + side2;
    }

    // This solution runs in O(log s) being s the smaller number
    public static int minProductHelper2(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        }

        if (smaller == 1) {
            return bigger;
        }

        // Divide by two
        int s = smaller >> 1;
        int side1 = minProductHelper(s, bigger);

        int side2 = side1;
        // If the number is odd then rest part to be summed is the bigger number
        if (smaller % 2 == 1) {
            side2 += bigger;
        }

        return side1 + side2;
    }
}
