package text.palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MHSL on 03.02.2017.
 *
 * Check if Palindrome - Checks if the string entered by the user is a palindrome.
 * That is that it reads the same forwards as backwards like “racecar”
 */
public class Palindrome {
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String string = reader.readLine().toLowerCase();
            String reversedString = new StringBuilder(string).reverse().toString();
            if (string.equals(reversedString)) {
                System.out.println("It's a palindrome");
            } else {
                System.out.println("It isn't a palindrome");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
