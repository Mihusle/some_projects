package numbers.factorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MHSL on 21.01.2017.
 */
public class Factorial {
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            long n = Long.parseLong(reader.readLine());
            System.out.println(loopFactorial(n));
            System.out.println(recursiveFactorial(n));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static long loopFactorial(long n) {
        long factor = n - 1;
        while (factor > 1) {
            n *= factor;
            factor--;
        }
        return n;
    }
    
    public static long recursiveFactorial(long n) {
        if (n > 2) {
            n *= recursiveFactorial(n - 1);
        }
        return n;
    }
}
