package algorithms.sorting;

/**
 * Created by MHSL on 15.03.2017.
 *
 * This is a realization of the insertion sorting.
 */
public class InsertionSort {
    
    public static void main(String[] args) {
        int[] numbers = Utils.inputNumbersArray();
        Utils.printNumbersArray(insertSort(numbers));
    }
    
    public static int[] insertSort(int[] array) {
        int temp, j;
        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            j = i;
            while (j > 0 && temp < array[j-1]) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
        }
        return array;
    }
}
