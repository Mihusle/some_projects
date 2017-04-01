package algorithms.sorting;

/**
 * Created by MHSL on 24.01.2017.
 *
 * This is a realization of the merge sorting.
 */
public class MergeSort {
    
    private int[] numbers;
    
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.setNumbers(Utils.inputNumbersArray());
        mergeSort.mergeSort();
        Utils.printNumbersArray(mergeSort.getNumbers());
    }
    
    void mergeSort() {
        int[] temp = new int[numbers.length];
        mergeSort(temp, 0, numbers.length - 1);
    }
    
    private void mergeSort(int[] temp, int start, int end) {
        if (start == end) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(temp, start, middle);
        mergeSort(temp, middle+1, end);
        merge(temp, start, middle+1, end);
    }
    
    private void merge(int[] temp, int start, int middle, int end) {
        int i = 0;
        int border = middle - 1;
        int copyStart = start;
        int length = end - start + 1;
        while (start <= border && middle <= end) {
            if (numbers[start] < numbers[middle]) {
                temp[i++] = numbers[start++];
            } else {
                temp[i++] = numbers[middle++];
            }
        }
        while (start <= border) {
            temp[i++] = numbers[start++];
        }
        while (middle <= end) {
            temp[i++] = numbers[end++];
        }
        for (i = 0; i < length; i++) {
            numbers[copyStart+i] = temp[i];
        }
    }
    
    public int[] getNumbers() {
        return numbers;
    }
    
    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}
