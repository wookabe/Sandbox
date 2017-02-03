package woo.general;

import java.util.Arrays;

/**
 * Created by Łukasz on 2016-10-11.
 */
public class TapeEquilibrium {
//    A[0] = 3
//    A[1] = 1
//    A[2] = 2
//    A[3] = 4
//    A[4] = 3
//    We can split this tape in four places:
//
//    P = 1, difference = |3 − 10| = 7
//    P = 2, difference = |4 − 9| = 5
//    P = 3, difference = |6 − 7| = 1
//    P = 4, difference = |10 − 3| = 7

    public int solution(int[] A) {
        int[] firstPartSums = new int[A.length - 1];
        int[] secondPartSums = new int[A.length - 1];
        firstPartSums[0] = A[0];
        secondPartSums[secondPartSums.length - 1] = A[A.length - 1];
        for (int i = 1; i < A.length - 1; i++) {
            firstPartSums[i] = firstPartSums[i - 1] + A[i];
        }
        for (int i = A.length - 2; i > 0; i--) {
            secondPartSums[i - 1] = secondPartSums[i] + A[i];
        }
        for (int i = 0; i < firstPartSums.length; i++) {
            firstPartSums[i] = Math.abs(firstPartSums[i] - secondPartSums[i]);
        }
        return Arrays.stream(firstPartSums).min().getAsInt();
    }

    public int solution2(int[] A) {
        int[] sums = new int[A.length];
        sums[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sums[i] = sums[i - 1] + A[i];
        }
        for (int i = 0; i < sums.length - 1; i++) {
            sums[i] = Math.abs(sums[sums.length - 1] - sums[i] * 2);
        }
        return Arrays.stream(sums).min().getAsInt();
    }

    public int solution3(int[] A) {
        int[] sums = new int[A.length];
        sums[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sums[i] = sums[i - 1] + A[i];
        }
        int sumAll = sums[sums.length - 1];
        int min = sumAll;
        for (int i = 0; i < sums.length - 1; i++) {
            min = Math.min(min, Math.abs(sumAll - sums[i] * 2));
        }
        return min;
    }

    public int solution4(int[] A) {
        int[] sums = new int[A.length];
        sums[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sums[i] = sums[i - 1] + A[i];
        }
        return Arrays.stream(sums).
                map(sum -> Math.abs(sums[sums.length - 1] - sum * 2)).
                min().
                getAsInt();
    }
}
