package woo.crackingTCI;

/**
 * Created by Łukasz on 2017-02-02.
 * <p>
 * 5.1 You are given two 32-bit numbers, N and M, and two bit positions, land j. Write
 * a method to insert M into N such that M starts at bit j and ends at bit i. You can
 * assume that the bits j through i have enough space to fit all of M. That is, i
 * M = 10011, you can assume that there are at least 5 bits between j and i. Yo
 * would not, for example, have j = 3 and i = 2, because M could not fully fit
 * between bit 3 and bit 2.
 * EXAMPLE
 * Input: N = 10000000000, M = 10011, i = 2, j = 6
 * Output: N = 10001001100
 */
// using long because int can hold max 31 bits unsigned
// but try with int also, maybe the value doesn’t matter
// or - perhaps but first clear i to j from N
// simple case > j - i == length of M
// clear bits in N from j to i
// create 2^(j - i + 1) - 1 number (all 1s)
// shift it by i bits left to a proper place in N
// negate to get mask with 0s that will clear appopriate bits in N
// return N & mask
// shift M i bits left
// return N | M

public class BitwiseInserter {

    public long insertInto(long n, long m, int i, int j) {
        validateInput(n, m, i, j);
        n = clearBits(n, i, j);
        m = shiftLeft(m, i);
        return n | m;
    }

    private long clearBits(long n, int i, int j) {
        long mask = (1 << (j - i)) - 1;
        mask = shiftLeft(mask, i);
        mask = ~mask;
        return n & mask;
    }

    private long shiftLeft(long m, int i) {
        return m << i;
    }

    private void validateInput(long n, long m, int i, int j) {
        String nBin = Long.toBinaryString(n);
        String mBin = Long.toBinaryString(m);
        if (nBin.length() < mBin.length()) {
            throw new IllegalArgumentException("n (=" + nBin + ")" +
                    " cannot have less bits than m (=" + mBin + ")");
        }
        if (i < 0)
            throw new IllegalArgumentException("i (=" + i + ")" +
                    " cannot be negative");
        if (j < 0) {
            throw new IllegalArgumentException("j (=" + j + ")" +
                    " cannot be negative");
        }
        if (j < i)
            throw new IllegalArgumentException("j (=" + j + ")" +
                    " cannot be less than i (=" + i + ")");
        if (j - i + 1 < mBin.length())
            throw new IllegalArgumentException("m (=" + mBin + ")" +
                    " length cannot be greater than j (=" + j + ") - i (=" + i + ") + 1");
    }
}

// without validation
//public class BitwiseInserter {
//
//    public long insertInto(long n, long m, int i, int j) {
//        validateInput(n, m, i, j);
//        n = clearBits(n, i, j);
//        m = shiftLeft(m, i);
//        return n | m;
//    }
//
//    private long clearBits(long n, int i, int j) {
//        long mask = (1 << (j - i)) - 1;
//        mask = shiftLeft(mask, i);
//        mask = ~mask;
//        return n & mask;
//    }
//
//    private long shiftLeft(long m, int i) {
//        return m << i;
//    }
//
//    private void validateInput(long n, long m, int i, int j) {
//        //TODO
//    }
//}
