package woo.crackingTCI.musthave;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Łukasz on 2017-02-06.
 */
// recursively sort left and right halves of the array
// merge after sorting
// using tmp buffer of size n

public class MergeSort<T extends Comparable<T>> {

    public void sort(T[] array) {
        if (array == null || array.length < 2)
            return;

        List<T> buffer = new ArrayList<>(array.length);
        mergeSort(array, buffer, 0, array.length - 1);
    }

    private void mergeSort(T[] array, List<T> buffer, int left, int right) {
        if (left >= right)
            return;

        int mid = (left + right) / 2;
        mergeSort(array, buffer, left, mid);
        mergeSort(array, buffer, mid + 1, right);
        merge(array, buffer, left, right, mid);
    }

    private void merge(T[] array, List<T> buffer, int start, int end, int mid) {
        int index = start;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (array[left].compareTo(array[right]) <= 0) {
                buffer.add(index, array[left]);
                left++;
            } else {
                buffer.add(index, array[right]);
                right++;
            }
            index++;
        }

        while (left <= mid) {
            buffer.add(index, array[left]);
            left++;
            index++;
        }

        while (right <= end) {
            buffer.add(index, array[right]);
            right++;
            index++;
        }

        for(int i = start; i <= end; i++) {
            array[i] = buffer.get(i);
        }
    }
}
