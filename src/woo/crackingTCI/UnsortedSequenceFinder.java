package woo.crackingTCI;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

/**
 * Created by Łukasz on 2017-03-09.
 * <p>
 * 17.6 Given an array of integers, write a method to find indices m and n such that if you sorted elements m through
 * n, the entire array would be sorted. Minimize n - m (that is, find the smallest such sequence).
 * EXAMPLE
 * Input: 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
 * Output: (3, 9)
 */
// brute force - go one element at the time
// from left - check if you find an element less than element - if so than this element is the m
// if there’s no m than the input is sorted
// from right - check if you find an element greater than element - if so than this element is the n

public class UnsortedSequenceFinder {

    boolean brute = false;

    public Pair find(int[] a) {
        if (!isValid(a))
            return new Pair(-1, -1);
        int m = findLeft(a);
        int n = m == -1 ? -1 : findRight(a);
        return new Pair(m, n);
    }

    private boolean isValid(int[] a) {
        return a != null && a.length > 1;
    }

    private int findLeft(int[] a) {
        return brute ? findLeftBrute(a) : findLeftOptimized(a);
    }

    private int findLeftBrute(int[] a) {
        for (int m = 0; m < a.length; m++)
            for (int i = m + 1; i < a.length; i++)
                if (a[i] < a[m])
                    return m;
        return -1;
    }

//    TODO: zrobic dwa kursory

    private int findLeftOptimized(int[] a) {
        Optional<Integer> temp = empty();
        for (int i = 0; i < a.length - 1; i++)
            if (a[i + 1] < a[i])
                temp = of(Math.min(temp.orElse(Integer.MAX_VALUE), a[i + 1]));
        if (temp.isPresent()) {
            int m;
            for (m = 0; a[m] <= temp.get(); m++) ;
            return m;
        } else
            return -1;
    }

    private int findRight(int[] a) {
        return brute ? findRightBrute(a) : findRightOptimized(a);
    }

    private int findRightBrute(int[] a) {
        for (int n = a.length - 1; n >= 0; n--)
            for (int i = n - 1; i >= 0; i--)
                if (a[i] > a[n])
                    return n;
        return -1;
    }

    private int findRightOptimized(int[] a) {
        Optional<Integer> temp = empty();
        for (int i = a.length - 1; i > 0; i--)
            if (a[i - 1] > a[i])
                temp = of(Math.max(temp.orElse(Integer.MIN_VALUE), a[i - 1]));
        if (temp.isPresent()) {
            int m;
            for (m = a.length - 1; a[m] >= temp.get(); m--) ;
            return m;
        } else
            return -1;
    }

    public static class Pair {
        int m, n;

        public Pair(int m, int n) {
            this.m = m;
            this.n = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (m != pair.m) return false;
            return n == pair.n;

        }

        @Override
        public String toString() {
            return "{" +
                    "m=" + m +
                    ", n=" + n +
                    '}';
        }

        @Override
        public int hashCode() {
            int result = m;
            result = 31 * result + n;
            return result;
        }
    }
}
