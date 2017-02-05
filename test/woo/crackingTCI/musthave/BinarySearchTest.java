package woo.crackingTCI.musthave;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Łukasz on 2017-02-05.
 */
public class BinarySearchTest {

    private BinarySearch<Integer> bs;
    private Integer[] arrayEleven;

    @Before
    public void setUp() throws Exception {
        bs = new BinarySearch<>();
        arrayEleven = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    @Test
    public void search_whenElemNull_returnNegative() throws Exception {
        assertTrue(bs.search(new Integer[0], null) < 0);
    }

    @Test
    public void search_whenArrayNull_returnNegative() throws Exception {
        assertTrue(bs.search(null, 10) < 0);
    }

    @Test
    public void search_whenArrayEmpty_returnNegative() throws Exception {
        assertTrue(bs.search(new Integer[0], 10) < 0);
    }

    @Test
    public void search_whenIsMid_returnMid() throws Exception {
        assertEquals(5, bs.search(arrayEleven, 5));
    }

    @Test
    public void search_whenIsFirst_returnFirst() throws Exception {
        assertEquals(0, bs.search(arrayEleven, 0));
    }

    @Test
    public void search_whenIsLast_returnLast() throws Exception {
        assertEquals(10, bs.search(arrayEleven, 10));
    }

    @Test
    public void search_whenLessThanMin_returnNegative() throws Exception {
        assertTrue(bs.search(arrayEleven, -100) < 0);
    }

    @Test
    public void search_whenArrayUnsortedAndUnlucky_returnNegative() throws Exception {
        assertTrue(bs.search(new Integer[] {3, 2, 1}, 3) < 0);
    }

}