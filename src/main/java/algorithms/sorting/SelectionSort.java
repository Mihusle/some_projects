package algorithms.sorting;

/**
 * Created by MHSL on 15.03.2017.
 *
 * This is a realization of the selection sorting.
 */
public class SelectionSort {
    
    public static void main(String[] args) {
        int[] numbers = Utils.inputNumbersArray();
        Utils.printNumbersArray(selectionSort(numbers));
    }
    
    public static int[] selectionSort(int[] array) {
        int min;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        return array;
    }
}
