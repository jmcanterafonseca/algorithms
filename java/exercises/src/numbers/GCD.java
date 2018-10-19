package numbers;

public class GCD {
    public static void main(String[] args) {
        int[] arr = {12,56,4,8};

        System.out.println(generalizedGCD(arr));
    }

    // GCD (a,b,c) = GCD(a,GCD(b,c))
    public static int generalizedGCD(int[] arr) {
        int result = arr[0];

        for(int j = 1; j < arr.length; j++) {
            result = GCD(arr[j], result);
        }

        return result;
    }

    // Uses the Euclidean algorithm (recursively) to find the GCD of (a,b)
    public static int GCD(int a, int b) {
        if (a == 0) {
            return b;
        }

        return GCD(b % a, a);
    }
}
