package woo.general;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by Łukasz on 2016-10-14.
 */
public class PermMissingElem {
    public int solution(int A[]) {
        Arrays.sort(A);
        int expected = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == expected) expected++;
            else return expected;
        }
        return expected;
    }

    public int solution2(int A[]) {
        long expectedSum = (long) ((1 + A.length + 1) / 2.0 * (A.length + 1));
        for (int i : A) {
            expectedSum -= i;
        }
        return (int) expectedSum;
    }

    public int solution3(int A[]) {
        BigDecimal expectedSum = BigDecimal.valueOf(A.length + 1);
        expectedSum = expectedSum.multiply(BigDecimal.valueOf(1 + A.length + 1));
        expectedSum = expectedSum.divide(BigDecimal.valueOf(2), 2);
        for (int i : A) {
            expectedSum = expectedSum.subtract(BigDecimal.valueOf(i));
        }
        return expectedSum.intValue();
    }

    public int solution4(int A[]) {
        BigInteger expectedSum = BigInteger.valueOf(A.length + 1);
        expectedSum = expectedSum.multiply(BigInteger.valueOf(1 + A.length + 1));
        expectedSum = expectedSum.divide(BigInteger.valueOf(2));
        for (int i : A) {
            expectedSum = expectedSum.subtract(BigInteger.valueOf(i));
        }
        return expectedSum.intValue();
    }
}
