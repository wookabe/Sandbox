package woo.crackingTCI.musthave;

/**
 * Created by Łukasz on 2017-02-05.
 */
// array that’s sorted
// compute index of middle element
// if element at mid index is the one searched for, return
// if it’s greater then search in left part
// if it’s lower then search in right part

public class BinarySearch <T extends Comparable<T>> {

    public int search(T[] array, T elem) {
        if (array == null || elem == null)
            return -1;

        return search(array, elem, 0, array.length - 1);
    }

    private int search(T[] array, T elem, int start, int end) {
        if (start > end)
            return -1; // not found

        int mid = start + (end - start) / 2;//(start + end) / 2;
        int compare = array[mid].compareTo(elem);
        return compare < 0 ? search(array, elem, mid + 1, end) :
                compare > 0 ? search(array, elem, 0, mid - 1) :
                        mid;
    }
}
