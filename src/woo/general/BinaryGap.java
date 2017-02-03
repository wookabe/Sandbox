package woo.general;

import java.util.Arrays;

/**
 * Created by Łukasz on 2016-10-09.
 */
class BinaryGap {
    public int solution6(int N) {
        int count = 0;
        int max = 0;
        boolean sequenceStarted = false;
        boolean zero;

        while (N > 0) {
            zero = (N & 1) == 0;
            if (sequenceStarted) {
                if (zero)
                    count++;
                else {
                    max = Integer.max(max, count);
                    count = 0;
                }
            } else if (!zero) sequenceStarted = true;
            N >>= 1;
        }

        return max;
    }

    public int solution5(int N) {
        int count = 0;
        int max = 0;
        boolean started = false;
        boolean one;

        while (N > 0) {
            one = (N & 1) == 1;
            if (one && !started) started = true;
            else if (!one && started) count++;
            else if (one && count > 0 && started) {
                max = Integer.max(max, count);
                count = 0;
            }
            N /= 2;
        }

        return max;
    }

    public int solution4(int N) {
        int count = 0;
        int max = 0;
        boolean started = false;
        boolean one;

        while (N > 0) {
            one = (N & 1) == 1;
            if (one && !started) started = true;
            else if (!one && started) count++;
            else if (one && started) {
                max = Integer.max(max, count);
                count = 0;
            }
            N /= 2;
        }

        return max;
    }

//        public int solution3(int N) {
//            int count = 0;
//            int max = 0;
//            boolean one;
//
//            while (N > 0) {
//                one = N % 2 == 1;
//                if (!one && max > 0) count++;
//                else if (one && count > 0) {
//                    max = Integer.max(max, count);
//                    count = 0;
//                }
//                N /= 2;
//            }
//
//            return max;
//        }

    public int solution2(int N) {
        int count = 0;
        int max = 0;
        boolean started = false;
        boolean one = false;

        while (N > 0) {
            one = N % 2 == 1;
            if (one && !started) started = true;
            else if (!one && started) count++;
            else if (one && started) {
                max = Integer.max(max, count);
                count = 0;
            }
            N /= 2;
        }

        return max;
    }

    public int solution(int N) {
        String paramBinaryString = Integer.toBinaryString(N);

        char[] chars = paramBinaryString.toCharArray();

        int count = 0;
        int max = 0;
        boolean started = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1' && !started)
                started = true;
            if (chars[i] == '0' && started) {
                count++;
            }
            if (chars[i] == '1' && started) {
                max = Integer.max(max, count);
                count = 0;
            }
        }

        return max;
//            0 0 / 2 = 0 1 1 / 2 = 0
//            2 10 / 2 = 1
//            3 11 / 2 = 1
//            4 100 / 2 = 2
//            5 101 / 2 = 2
//            6 110 / 2 = 3
//            7 111 / 2 = 3
//            8 1000 / 2 = 4
//            9 1001 / 2 = 4
//            17  10001
//            2^x + 1, przy czym x > 1


    }
}
