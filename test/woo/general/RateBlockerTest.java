package woo.general;

import org.junit.Test;
import woo.general.RateBlocker;

/**
 * Created by Łukasz on 2017-01-16.
 */
public class RateBlockerTest {

    @Test
    public void test() throws Exception {
        RateBlocker rb = new RateBlocker(1000, 10);

        for (int i = 0; i < 120; i++) {
            rb.send();
            Thread.sleep(90);
        }

        Thread.sleep(1000);

        rb.send();
        rb.send();
    }
}