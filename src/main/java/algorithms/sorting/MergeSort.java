package algorithms.sorting;

import java.util.Arrays;

/**
 * Created by MHSL on 24.01.2017.
 *
 * This is a realization of the merge sorting.
 */
public class MergeSort {
    
    public static void main(String[] args) {
        int[] numbers = Utils.inputNumbersArray();
        Utils.printNumbersArray(mergeSort(numbers));
    }
    
    public static int[] mergeSort(int[] array) {
        if (array.length > 2) {
            int[] rightPart;
            int[] leftPart;
            int[] result = new int[array.length];
            int rightIndex = 0;
            int leftIndex = 0;
            rightPart = mergeSort(Arrays.copyOfRange(array, 0, array.length / 2));
            leftPart = mergeSort(Arrays.copyOfRange(array, array.length / 2, array.length));
            for (int i = 0; i < result.length; i++) {
                if (rightIndex < rightPart.length && leftIndex < leftPart.length) {
                    if (rightPart[rightIndex] < leftPart[leftIndex]) {
                        result[i] = rightPart[rightIndex];
                        rightIndex++;
                    } else {
                        result[i] = leftPart[leftIndex];
                        leftIndex++;
                    }
                } else if (rightIndex < rightPart.length && leftIndex == leftPart.length) {
                    result[i] = rightPart[rightIndex];
                    rightIndex++;
                } else if (rightIndex == rightPart.length && leftIndex < leftPart.length) {
                    result[i] = leftPart[leftIndex];
                    leftIndex++;
                }
            }
            return result;
        } else if (array.length == 2) {
            if (array[0] > array[1]) {
                int temp;
                temp = array[1];
                array[1] = array[0];
                array[0] = temp;
            }
        }
        return array;
    }
}
