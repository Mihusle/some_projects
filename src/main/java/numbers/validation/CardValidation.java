package numbers.validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MHSL on 19.01.2017.
 */
public class CardValidation {
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("This program validates card number.");
        System.out.print("Input card number of 16 digits: ");
        try {
            String number = reader.readLine();
            int controlSum = 0;
            for (int i = 0; i < number.length(); i++) {
                int digit = Integer.valueOf(String.valueOf(number.charAt(i)));
                if (i % 2 == 0) {
                    digit *= 2;
                    if (digit > 9) {
                        digit -= 9;
                    }
                }
                controlSum += digit;
            }
            if (controlSum % 10 == 0) {
                System.out.println("This is the valid card number");
            } else {
                System.out.println("This is the invalid card number");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
