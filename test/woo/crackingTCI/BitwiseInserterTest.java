package woo.crackingTCI;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Łukasz on 2017-02-02.
 */
public class BitwiseInserterTest {

    private BitwiseInserter bi;

    @Before
    public void setUp() throws Exception {
        bi = new BitwiseInserter();
    }

    @Test
    public void insertInto_whenNoNeedToClearN() throws Exception {
        assertEquals(0b101110, bi.insertInto(0b100000, 0b111, 1, 4));
    }

    @Test
    public void insertInto_whenNeedToClearN() throws Exception {
        assertEquals(0b101000, bi.insertInto(0b101110, 0b100, 1, 4));
    }

    @Test
    public void insertInto_NBitsEqualsMBits() throws Exception {
        assertEquals((int) Math.pow(2, 21) - 1, bi.insertInto(0b101010101010101010101, 0b111111111111111111111, 0, 20));
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertInto_whenNFewerBitsThanM_shouldThrowException() throws Exception {
        bi.insertInto(1L, 2L, 0, 1);
    }

    @Test
    public void insertInto_whenNSameBitsButLessThanM_shouldSucceed() throws Exception {
        bi.insertInto(2L, 3L, 0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertInto_whenINegative_shouldThrowException() throws Exception {
        bi.insertInto(1L, 2L, -1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertInto_whenJNegative_shouldThrowException() throws Exception {
        bi.insertInto(1L, 2L, 1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertInto_whenINegativeAndJNegative_shouldThrowException() throws Exception {
        bi.insertInto(1L, 2L, -1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertInto_whenJLessThanI_shouldThrowException() throws Exception {
        bi.insertInto(1L, 2L, 1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertInto_whenMMoreBitsThanJMinusIPlusOne_shouldThrowException() throws Exception {
        bi.insertInto(1L, 2L, 1, 1);
    }
}