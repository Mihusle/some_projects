package numbers.fast.exponantiation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MHSL on 24.01.2017.
 *
 * Fast Exponentiation - Ask the user to enter 2 integers a and b and output a^b (i.e. pow(a,b)) in O(lg n) time complexity.
 */
public class FastExponantiation {
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write two integer numbers. First - base, second - power: ");
        try {
            int base = Integer.parseInt(reader.readLine());
            int power = Integer.parseInt(reader.readLine());
            int result;
            if (power == 0) {
                result = 1;
            } else if (base < 0) {
                result = (int) -Math.exp(power * Math.log(base));
            } else if (base > 0) {
                result = (int) Math.exp(power * Math.log(base));
            } else {
                result = 0;
            }
            System.out.println("Result: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
