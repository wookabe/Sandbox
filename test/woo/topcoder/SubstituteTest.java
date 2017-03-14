package woo.topcoder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Łukasz on 2017-03-01.
 */
public class SubstituteTest {

    private Substitute s;

    @Before
    public void setUp() throws Exception {
        s = new Substitute();
    }

    @Test
    public void whenTRADINGFEWandLGXWEV_return709() throws Exception {
        assertValue("TRADINGFEW", "LGXWEV", 709);
    }

    @Test
    public void whenABCDEFGHIJandXJ_return0() throws Exception {
        assertValue("ABCDEFGHIJ", "XJ", 0);
    }

    @Test
    public void whenCRYSTALBUM_MMA_return6() throws Exception {
        assertValue("CRYSTALBUM", "MMA", 6);
    }

    private void assertValue(String key, String code, int expected) {
        assertEquals(expected, s.getValue(key, code));
    }
}
