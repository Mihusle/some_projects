package numbers.happy.numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MHSL on 21.01.2017.
 *
 * Happy Numbers - A happy number is defined by the following process. Starting with any positive integer, replace
 * the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers,
 * while those that do not end in 1 are unhappy numbers.
 */
public class HappyNumbers {
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            while (n != 1) {
                int temp = n;
                n = 0;
                while (temp > 0) {
                    n += Math.pow(temp % 10, 2);
                    temp /= 10;
                }
                System.out.println(n);
            }
            System.out.println("It's the happy number");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
