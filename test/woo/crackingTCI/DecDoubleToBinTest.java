package woo.crackingTCI;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Łukasz on 2017-03-12.
 */
public class DecDoubleToBinTest {

    private DecDoubleToBin ddtb;

    private void assertTransformed(double doubleInput, String binOutput) {
        assertEquals(binOutput, ddtb.toBin(doubleInput));
    }

    @Before
    public void setUp() throws Exception {
        ddtb = new DecDoubleToBin();
    }

    @Test
    public void toBin() throws Exception {
        assertTransformed(0.0, "0.0");
        assertTransformed(0.0625, "0.0001");
        assertTransformed(0.125, "0.001");
        assertTransformed(0.25, "0.01");
        assertTransformed(0.375, "0.011");
        assertTransformed(0.5, "0.1");
        assertTransformed(0.625, "0.101");
        assertTransformed(0.75, "0.11");
        assertTransformed(0.875, "0.111");
        assertTransformed(0.9375, "0.1111");
        assertTransformed(0.1, "ERROR");
    }

}