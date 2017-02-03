package woo.general;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import woo.general.Temp;

import static org.junit.Assert.*;

/**
 * Created by Łukasz on 2017-01-07.
 */
public class TempTest {
    private Temp temp;

    @Before
    public void setUp() throws Exception {
        System.out.println("Biforek");
        temp = new Temp();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Afterek");
        temp = null;
    }

    @Test
    public void concatenate() throws Exception {
        System.out.println("tescik");
        //given
        int i = 123;
        char c = 'd';

        //when
        String result = temp.concatenate(i, c);
        String resultNullNotNull = temp.concatenate(null, c);
        String resultNotNullNull = temp.concatenate(i, null);
        String resultNullNull = temp.concatenate(null, null);

        //then
        assertNotNull(result);
        assertEquals(i + "" + c, result);
        assertEquals(c + "", resultNullNotNull);
        assertEquals(i + "", resultNotNullNull);
        assertEquals("", resultNullNull);
    }

}