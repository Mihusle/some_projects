package algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MHSL on 15.03.2017.
 *
 * This is class where all methods were gathered for simple input/output and etc.
 */
public class Utils {
    
    public static int[] inputNumbersArray() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter numbers separated by space");
        int[] numbers = null;
        try {
            String line = reader.readLine();
            String[] strings = line.split(" ");
            numbers = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                numbers[i] = Integer.parseInt(strings[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }
    
    public static void printNumbersArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
