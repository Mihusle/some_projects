package numbers.names;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created by MHSL on 21.01.2017.
 *
 * Number Names - Show how to spell out a number in English. You can use a preexisting implementation or roll your own,
 * but you should support inputs up to at least one million
 */
public class NumberNames {
    
    public static final String[] NUMBERS = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    public static final String[] TENSES = {
        "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    public static final String HUNDRED = " hundred ";
    public static final String THOUSAND = " thousand ";
    public static final String MILLION = " million ";
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            long number = Long.parseLong(reader.readLine());
            System.out.println(convert(number));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String convertLessThanThousand(int n) {
        String result = "";
        if (n % 100 < 20) {
            result += NUMBERS[n % 100];
            n /= 100;
        } else {
            result += NUMBERS[n % 10];
            n /= 10;
            result = TENSES[n % 10] + " " + result;
            n /= 10;
        }
        
        if (n != 0) {
            return NUMBERS[n] + HUNDRED + result;
        } else {
            return result;
        }
    }
    
    public static String convert(long number) {
        DecimalFormat decimalFormat = new DecimalFormat("0000000");
        String stringNumber = decimalFormat.format(number);
        
        int millions = Integer.parseInt(stringNumber.substring(0, 1));
        int thousands = Integer.parseInt(stringNumber.substring(1, 4));
        int units = Integer.parseInt(stringNumber.substring(4, 7));
        String result = "";
        
        switch (millions) {
            case 0:
                break;
            default:
                result += NUMBERS[millions] + MILLION;
        }
        
        switch (thousands) {
            case 0:
                break;
            case 1:
                result += "one " + THOUSAND;
                break;
            default:
                result += convertLessThanThousand(thousands) + THOUSAND;
        }
        
        result += convertLessThanThousand(units);
        return result;
    }
}
