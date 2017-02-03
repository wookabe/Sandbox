package woo.general;

import java.util.Arrays;

/**
 * Created by Łukasz on 2016-10-11.
 */
public class OddOccurencesInArray {
    public int solution(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            count = (i & 1) == 0 ? count + A[i] : count - A[i];
        }
        return count;
    }

    public int solution2(int[] A) {
        Arrays.sort(A);
        int result = A[0];
        for (int i = 0, j = 1; i < A.length; i += 2, j += 2) {
            if (j == A.length) {
                result = A[i];
            } else if (A[i] != A[j]) {
                result = A[i];
                break;
            }
        }
        return result;
    }
}
