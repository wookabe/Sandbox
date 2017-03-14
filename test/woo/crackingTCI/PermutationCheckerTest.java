package woo.crackingTCI;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Łukasz on 2017-03-13.
 */
public class PermutationCheckerTest {

    private PermutationChecker pc;

    private void assertPermutation(boolean expected, String s1, String s2) {
        assertEquals(expected, pc.arePermutations(s1, s2));
    }

    @Before
    public void setUp() throws Exception {
        pc = new PermutationChecker();
    }

    @Test
    public void arePermutations() throws Exception {
        assertPermutation(false, null, null);
        assertPermutation(false, null, "");
        assertPermutation(false, "", null);
//        assertPermutation(false, "", "a");
  //      assertPermutation(false, "a", "");
        assertPermutation(true, "a", "a");
        assertPermutation(true, "ab", "ba");
        assertPermutation(true, "aba", "baa");
        assertPermutation(true, "aba", "baa");
        assertPermutation(true, "ODraconiandevilOhlamesaintSodarktheconofMan", "LeonardoDaVinciTheMonaLisaMadonnaoftheRocks");
    }



}