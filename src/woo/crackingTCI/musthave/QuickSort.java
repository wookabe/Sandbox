package woo.crackingTCI.musthave;

/**
 * Created by Łukasz on 2017-02-05.
 */
public class QuickSort<T extends Comparable<T>> {

    public void sort(T[] array) {
        if (array == null || array.length < 2)
            return;

        sort(array, 0, array.length - 1);
    }

    private void sort(T[] array, int start, int end) {
        if (start >= end)
            return;

        int pivotIndex = partition(array, start, end);
        sort(array, start, pivotIndex - 1);
        sort(array, pivotIndex, end);
    }

    private int partition(T[] array, int left, int right) {
        T pivot = array[(left + right) / 2];
        while (left <= right) {
            while (array[left].compareTo(pivot) < 0) {
                left++;
            }
            while (array[right].compareTo(pivot) > 0) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(T[] array, int left, int right) {
        T tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
