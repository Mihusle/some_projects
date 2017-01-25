package algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MHSL on 25.01.2017.
 */
public class BubbleSort {
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Write numbers separated by space: ");
        try {
            String[] characters = reader.readLine().split(" ");
            int[] numbers = new int[characters.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(characters[i]);
            }
            for (int n : bubbleSort(numbers)) {
                System.out.print(n + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    
    public static int[] bubbleSort(int[] array) {
        int bubble;
        for (int j = array.length - 1; j > 1; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    bubble = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = bubble;
                }
            }
        }
        return array;
    }
}
