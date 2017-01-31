package algorithms.eratosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by MHSL on 30.01.2017.
 *
 * Sieve of Eratosthenes - The sieve of Eratosthenes is one of the most efficient ways to find all of the smaller primes
 * (below 10 million or so).
 */
public class SieveOfEratosthenes {
    
    private static final int START_NUMBER = 2;
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number till what need to find primes: ");
        try {
            int limit = Integer.parseInt(reader.readLine());
            System.out.println(findPrimes(limit).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static ArrayList<Integer> findPrimes(int limit) {
        boolean[] primes = new boolean[++limit];
        for (int i = START_NUMBER; i < primes.length; i++) {
            int multiple = i * i;
            while (multiple < primes.length) {
                primes[multiple] = true;
                multiple += i;
            }
        }
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = START_NUMBER; i < primes.length; i++) {
            if (!primes[i]) {
                numbers.add(i);
            }
        }
        return numbers;
    }
}
