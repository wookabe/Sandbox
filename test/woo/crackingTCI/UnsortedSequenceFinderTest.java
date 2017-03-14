package woo.crackingTCI;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import woo.crackingTCI.UnsortedSequenceFinder.Pair;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Łukasz on 2017-03-09.
 */
public class UnsortedSequenceFinderTest {

    private UnsortedSequenceFinder usf;
    private Pair notFoundPair;

    private void assertSequence(int[] input, Pair output) {
        assertThat(usf.find(input), is(output));
    }

    private void assertSorted(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; a[i] = i, i++) ;

        assertSequence(a, notFoundPair);
    }

    private int[] arrayOf(int... ints) {
        return ints;
    }

    private Pair pairOf(int m, int n) {
        return new Pair(m, n);
    }

    @Before
    public void setUp() throws Exception {
        usf = new UnsortedSequenceFinder();
        notFoundPair = pairOf(-1, -1);
    }

    @Test
    public void testInvalid() throws Exception {
        assertSequence(null, notFoundPair);
        assertSequence(arrayOf(0), notFoundPair);
        assertSequence(arrayOf(1), notFoundPair);
    }

    @Test
    public void testValid() throws Exception {
        assertSequence(arrayOf(1, 2), notFoundPair);
        assertSequence(arrayOf(1, 2, 10, 100), notFoundPair);
        assertSequence(arrayOf(2, 1), pairOf(0, 1));
        assertSequence(arrayOf(2, 1, 100, 10), pairOf(0, 3));
        assertSequence(arrayOf(1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19), pairOf(3, 9));
    }

    @Test
    public void testPerformanceSortedBrute() throws Exception {
        testPerformanceSorted(true);
    }

    @Test
    public void testPerformanceSortedOptimized() throws Exception {
        testPerformanceSorted(false);
    }

    private void testPerformanceSorted(boolean brute) {
        usf.brute = brute;
        long time = System.nanoTime();
        assertSorted(100 * 1000);
        System.out.println(String.format((brute ? "brute" : "optimized") + ": \t%.3fs",
                (System.nanoTime() - time) / 1000000000.0));
    }
}