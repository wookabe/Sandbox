package woo.gl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Łukasz on 2017-03-15.
 */
//Given a list of ranges  [(a1, b1), (a2, b2), (a3, b3)...] where a < b.
//
//        create a function that will take the list and return another list without any overlapping ranges.
//
//        end points are exclusive, so (1,2) (2,3) are not overlapping.
//
//        for example:
//        a=[(1,4), (3,5)]
//        f(a)
//        [(1,4)]
//        a=[(2, 4), (1, 2), (-1, 3), (4,5), (6, 7), (2, 3), (6, 10)]
//        f(a)
//        [(-1, 3), (4, 5), (6, 10)])

public class NoOverlappingRangesFinder {

    public Pair[] getRanges(Pair[] ranges) {
        // if ranges are null or empty we return empty array, not to propagate null values
        if (!isValid(ranges))
            return new Pair[0];

        List<Pair> result = new ArrayList<>(Arrays.asList(ranges));
        for(int i = 0; i < result.size(); i++) {
            Pair p = result.get(i);
            for(int j = i +1; j < result.size(); j++) {
                Pair p2 = result.get(j);
                if (areOverlapping(p, p2))
                    // result.remove(j) -> this won't work as will be skipping elements
                    result.remove(j--);
            }
        }

        return result.toArray(new Pair[result.size()]);
    }

    private boolean areOverlapping(Pair p1, Pair p2) {
        // 1,2    3,4  -> b1 <= a2 || b2 <= a1 -> not overlapping
        // b1 > a2 && <= b2 || theotherwayaround -> overlapping
        // a1 < a2 && b1 > b2 || owa -> overlapping
        if (p1.b > p2.a && p1.b <= p2.b
                || p2.b > p1.a && p2.b <= p1.b
                || p1.a <= p2.a && p1.b >= p2.b || p2.a <= p1.a && p2.b >= p1.b)
            return true;
        return false;
    }

    private boolean isValid(Pair[] ranges) {
        return ranges != null && ranges.length > 0;
    }

    public static class Pair {
        int a, b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
