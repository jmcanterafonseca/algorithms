package primes;

import java.util.ArrayList;
import java.util.List;

public class PrimesGenerator {
    public static void main(String[] args) {
        int upperLimit = Integer.parseInt(args[0]);

        List<Integer> primes = primesGenerator(upperLimit);

        List<Integer> primes2 = primesGenerator2(upperLimit);

        for(int j = 0; j < primes.size(); j++) {
            System.out.print(primes.get(j) + " ");
        }

        System.out.println("");

        for(int j = 0; j < primes2.size(); j++) {
            System.out.print(primes.get(j) + " ");
        }
    }

    public static List<Integer> primesGenerator(int upperLimit) {
        int currentCandidate = 2;

        List<Integer> out = new ArrayList<>();

        while(currentCandidate <= upperLimit) {
            if (Primes.isPrime(currentCandidate)) {
                out.add(currentCandidate);
            }
            currentCandidate++;
        }

        return out;
    }

    // Uses the Erastothenes Sieve to generate primes
    // It works by recognizing that non-prime numbers are divisible by a prime number
    public static List<Integer> primesGenerator2(int upperLimit) {
        boolean[] isPrime = new boolean[upperLimit + 1];

        // First initialize the Sieve with true excepting 0 and 1 which we know in advance they
        // are not primes
        // Objective is to sieve until only the numbers which are really prime kept
        isPrime[0] = isPrime[1] = false;
        // Initially we set all numbers to be prime and then the sieve will do the work
        for(int j = 2; j < upperLimit + 1; j++) {
            isPrime[j] = true;
        }

        // Two is a prime
        int prime = 2;

        while(prime <= Math.sqrt(upperLimit)) {
            crossOff(isPrime, prime);

            prime = getNextPrime(isPrime,prime);
        }

        List<Integer> out = new ArrayList<>();
        for(int c = 0; c < upperLimit + 1; c++) {
            if(isPrime[c]) {
                out.add(c);
            }
        }

        return out;
    }

    public static void crossOff(boolean[] isPrime, int prime) {
        for (int i = prime * prime; i < isPrime.length; i += prime) {
            isPrime[i] = false;
        }
    }

    public static int getNextPrime(boolean[] isPrime, int prime) {
        int next = prime + 1;

        while(next < isPrime.length && !isPrime[next]) {
            next++;
        }

        return next;
    }
}
