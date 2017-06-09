package woo.crackingTCI;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Łukasz on 2017-05-30.
 */
public class StringRotationCheckerTest {

    private StringRotationChecker rc;

    @Before
    public void setUp() throws Exception {
        rc = new StringRotationChecker();
    }

    @Test
    public void areRotations() throws Exception {
        notRotations(null, null);
        notRotations("string", null);
        notRotations(null, "string");
        notRotations("string", "string ");
        notRotations(" string", "string");

        rotations("a", "a");
        rotations("ab", "ba");
        rotations("aba", "aab");
        rotations("aba", "baa");
        rotations("erbottlewat", "waterbottle");
        rotations("waterbottle", "erbottlewat");
    }

    private void notRotations(String s1, String s2) {
        assertFalse(rc.areRotations(s1, s2));
    }

    private void rotations(String s1, String s2) {
        assertTrue(rc.areRotations(s1, s2));
    }
}