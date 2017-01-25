package algorithms.collatz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MHSL on 24.01.2017.
 *
 * Collatz Conjecture - Start with a number n > 1. Find the number of steps it takes to reach one using the following process:
 * If n is even, divide it by 2. If n is odd, multiply it by 3 and add 1.
 */
public class CollatzConjecture {
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write integer number: ");
        try {
            int number = Integer.parseInt(reader.readLine());
            int moves = 0;
            while (number != 1) {
                if (number % 2 == 0) {
                    number /= 2;
                } else {
                    number = number * 3 + 1;
                }
                moves++;
            }
            System.out.println("Moves: " + moves);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
