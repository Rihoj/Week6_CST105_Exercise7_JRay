/**
 * Program: Week6ProgrammingExercise7
 * File: PalindromicPrimeNumbers.java
 * Summary: Finds all palindromic prime numbers within the first 100,000 positive integers.
 * Author: James Ray
 * Date: Nov 26, 2017
 */
import java.util.ArrayList;

public class PalindromicPrimeNumbers {

    //Constant for how many integers to check.
    private static final int END_OF_LOOP = 100000;
    //Array List of palindromic prime numbers.
    private static final ArrayList<Integer> PALINDROMIC_PRIMES = new ArrayList<>();

    /**
     * Loop through all integers and check to see if the number is a palindromic prime.
     * Print out the values in the array list as a table.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Palindromic Primes");
        for (int i = 2; i <= END_OF_LOOP; i++) {
            if (isPrime(i) && isPalindromic(i)) {
                PALINDROMIC_PRIMES.add(i);
            }
        }
        for (int i = 0; i < PALINDROMIC_PRIMES.size(); i += 4) {
            if (i + 3 < PALINDROMIC_PRIMES.size()) {
                System.out.format("%7d%7d%7d%7d\n", PALINDROMIC_PRIMES.get(i), PALINDROMIC_PRIMES.get(i + 1), PALINDROMIC_PRIMES.get(i + 2), PALINDROMIC_PRIMES.get(i + 3));
            } else if (i + 2 < PALINDROMIC_PRIMES.size()) {
                System.out.format("%7d%7d%7d\n", PALINDROMIC_PRIMES.get(i), PALINDROMIC_PRIMES.get(i + 1), PALINDROMIC_PRIMES.get(i + 2));
            } else if (i + 1 < PALINDROMIC_PRIMES.size()) {
                System.out.format("%7d%7d\n", PALINDROMIC_PRIMES.get(i), PALINDROMIC_PRIMES.get(i + 1));
            } else {
                System.out.format("%7d\n", PALINDROMIC_PRIMES.get(i));
            }
        }
    }

    /**
     * Check if the number is prime
     * @param int number
     * @return boolean
     */
    private static boolean isPrime(int number) {
        //Prime numbers start above +1
        if (number < 2) {
            return false;
        }
        //2 is a valid prime but is still divisible by 2.
        if (number == 2) {
            return true;
        }
        //return false for all even numbers.
        if (number % 2 == 0) {
            return false;
        }
        //Set square root of the number. As this covers all available divisors.
        double sqrt = Math.sqrt(number);
        //Loop through odd numbers too check to see if the remainder is 0.
        for (int i = 3; i <= sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Reverse the given value and compare values for equivalency.
     * @param int number
     * @return boolean
     */
    private static boolean isPalindromic(int number) {
        String reverse = new StringBuilder(String.valueOf(number)).reverse().toString();
        return number == Integer.valueOf(reverse);
    }

}
