package primes;

public class Primes {
    public static void main(String[] args) {
        int candidate = Integer.parseInt(args[0]);

        System.out.println(isPrime(candidate));
    }

    public static boolean isPrime(int candidate) {
        if (candidate < 2) {
            return false;
        }

        int maximum = (int)Math.sqrt(candidate);

        for(int divisor = 2; divisor <= maximum; divisor++) {
            if (candidate % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}
