package woo.gl;

import org.junit.Before;
import org.junit.Test;
import woo.gl.NoOverlappingRangesFinder.Pair;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Łukasz on 2017-03-15.
 */
public class NoOverlappingRangesFinderTest {

    private NoOverlappingRangesFinder norf;

    private void assertNoOverlapping(Pair[] input, Pair[] output) {
        assertThat(norf.getRanges(input), is(output));
    }

    private Pair[] pairs(Pair... pairs) {
        return pairs;
    }

    @Before
    public void setUp() throws Exception {
        norf = new NoOverlappingRangesFinder();
    }

    @Test
    public void testInvalid() throws Exception {
        assertNoOverlapping(null, new Pair[0]);
        assertNoOverlapping(new Pair[0], new Pair[0]);
    }

    @Test
    public void testValid() throws Exception {
        Pair p01_10 = new Pair(1, 10);
        Pair p11_20 = new Pair(11, 20);
        Pair p05_15 = new Pair(5, 15);
        Pair p00_99 = new Pair(0, 99);

        assertNoOverlapping(pairs(p01_10), pairs(p01_10));
        assertNoOverlapping(pairs(p01_10, p11_20), pairs(p01_10, p11_20));
        assertNoOverlapping(pairs(p01_10, p11_20, p05_15), pairs(p01_10, p11_20));
        assertNoOverlapping(pairs(p00_99, p01_10, p11_20), pairs(p00_99));
    }
}