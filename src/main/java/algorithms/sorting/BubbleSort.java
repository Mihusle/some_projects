package algorithms.sorting;

/**
 * Created by MHSL on 25.01.2017.
 *
 * This is a realization of the bubble sorting.
 */
public class BubbleSort {
    
    public static void main(String[] args) {
        int[] numbers = Utils.inputNumbersArray();
        Utils.printNumbersArray(bubbleSort(numbers));
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
