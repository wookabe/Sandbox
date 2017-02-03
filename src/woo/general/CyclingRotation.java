package woo.general;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Łukasz on 2016-10-11.
 */
public class CyclingRotation {
    public int[] solution(int[] A, int K) {
        if (K > 0 && A != null && A.length > 1) { 
            int last, temp, lastIndex;
            boolean loopTrap = A.length % K == 0;
            if (loopTrap) {
                for (int i = 0; i < K; i++) {
                    lastIndex = i;
                    last = A[lastIndex];
                    for (int j = K; j < A.length + K; j += K) {
                        int targetIndex = (lastIndex + K) % A.length;
                        temp = A[targetIndex];
                        A[targetIndex] = last;
                        last = temp;
                        lastIndex = targetIndex;
                    }
                }
            } else {
                lastIndex = 0;
                last = A[lastIndex];
                for (int i = 0; i < A.length; i++) {
                    int targetIndex = (lastIndex + K) % A.length;
                    temp = A[targetIndex];
                    A[targetIndex] = last;
                    last = temp;
                    lastIndex = targetIndex;
                }
            }
        }
        return A;
    }

    public int[] solution2(int[] A, int K) {
        if (K > 0 && A.length > 1) {
            int last, temp, lastIndex;
            boolean loop = A.length % K == 0;

            lastIndex = 0;
            last = A[lastIndex];
            for (int i = 0; i < A.length; i++) {
                int targetIndex = (lastIndex + K) % A.length;
                temp = A[targetIndex];
                A[targetIndex] = last;
                last = temp;
                if (targetIndex < lastIndex && loop) {
                    lastIndex = targetIndex + 1;
                    last = A[lastIndex];
                } else {
                    lastIndex = targetIndex;
                }
            }
        }
        return A;
    }

    public int[] solution3(int[] A, int K) {
        if (K > 0 && A.length > 1) {
            int[] result = new int [A.length];
            for (int i = 0; i < A.length; i++) {
                result[(i + K) % A.length] = A[i];
            }
            System.arraycopy(result, 0, A, 0, A.length);
        }
        return A;
    }

    public int[] solution4(int[] A, int K) {
        if (K > 0 && A.length > 1) {
            int step = K % A.length;
            int rest = A.length - step;
            int[] buffer = Arrays.copyOfRange(A, rest, A.length);
            System.arraycopy(A, 0, A, step, rest);
            System.arraycopy(buffer, 0, A, 0, step);
        }
        return A;
    }

    public int[] solution5(int[] A, int K) {
        if (K > 0 && A.length > 1) {
            List<Integer> listA = Arrays.stream(A).boxed().collect(Collectors.toList());
            Collections.rotate(listA, K % A.length);
            int [] arrayA = listA.stream().mapToInt(Integer::intValue).toArray();
            System.arraycopy(arrayA, 0, A, 0, A.length);
        }
        return A;
    }
}
