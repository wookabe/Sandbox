package woo.crackingTCI;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static woo.crackingTCI.KthToLastElementFinder.*;

/**
 * Created by Łukasz on 2017-03-13.
 */
public class KthToLastElementFinderTest {

    private KthToLastElementFinder ktlef;

    private void assertFound(Node linkedList, int k, Node found) {
        assertThat(ktlef.findKthToLast(linkedList, k), is(found));
    }

    @Before
    public void setUp() throws Exception {
        ktlef = new KthToLastElementFinder();
    }

    @Test
    public void testInvalid() throws Exception {
        assertFound(null, 0, null);
        assertFound(new Node(), -1, null);
        assertFound(new Node(), 123, null);
    }

    @Test
    public void testValid() throws Exception {
        Node n3 = new Node();
        Node n2 = new Node();
        Node n1 = new Node();
        n3.next = n2;
        n2.next = n1;

        // n1 -> null
        assertFound(n1, 0, n1);
        assertFound(n1, 1, null);
        // n2 -> n1 -> null
        assertFound(n2, 0, n1);
        assertFound(n2, 1, n2);
        assertFound(n2, 2, null);
        // n3 -> n2 -> n1 -> null
        assertFound(n3, 0, n1);
        assertFound(n3, 1, n2);
        assertFound(n3, 2, n3);
        assertFound(n3, 3, null);
    }
}