package numbers.happy.numbers;

import java.util.ArrayList;

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
        System.out.println("First happy numbers: ");
        int count = 0, start = 100;
        while (count < 8) {
            if (isHappy(start)) {
                System.out.print(start + " ");
                count++;
            }
            start++;
        }
    }
    
    public static boolean isHappy(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (n != 1) {
            list.add(n);
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;
            if (list.contains(n)) {
                return false;
            }
        }
        return true;
    }
}
