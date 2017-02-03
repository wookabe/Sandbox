package woo.crackingTCI;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Łukasz on 2017-01-31.
 */
public class AllUniqueCharactersTest {

    private AllUniqueCharacters auc;

    @Before
    public void setUp() throws Exception {
        auc = new AllUniqueCharacters();
    }

    @Test
    public void hasAllUniqueCharacters_whenNull_shouldReturnFalse() throws Exception {
        assertFalse(auc.hasAllUniqueCharacters(null));
    }

    @Test
    public void hasAllUniqueCharacters_whenEmpty_shouldReturnFalse() throws Exception {
        assertFalse(auc.hasAllUniqueCharacters(""));
    }

    @Test
    public void hasAllUniqueCharacters_whenNotUniqueLetters_shouldReturnFalse() throws Exception {
        assertFalse(auc.hasAllUniqueCharacters("abcdefABCDa"));
    }

    @Test
    public void hasAllUniqueCharacters_whenUniqueLetters_shouldReturnTrue() throws Exception {
        assertTrue(auc.hasAllUniqueCharacters("abcdefABCD"));
    }

    @Test
    public void hasAllUniqueCharacters_whenNotUniqueCharacters_shouldReturnFalse() throws Exception {
        assertFalse(auc.hasAllUniqueCharacters("1$#^$&8][["));
    }

    @Test
    public void hasAllUniqueCharacters_whenUniqueCharacters_shouldReturnTrue() throws Exception {
        assertTrue(auc.hasAllUniqueCharacters("!@#$%67890]{?>,"));
    }

    @Test
    public void hasAllUniqueCharacters_noAdditionalDataStructures_whenNull_shouldReturnFalse() throws Exception {
        assertFalse(auc.hasAllUniqueCharacters_noAdditionalDataStructures(null));
    }

    @Test
    public void hasAllUniqueCharacters_noAdditionalDataStructures_whenEmpty_shouldReturnFalse() throws Exception {
        assertFalse(auc.hasAllUniqueCharacters_noAdditionalDataStructures(""));
    }

    @Test
    public void hasAllUniqueCharacters_noAdditionalDataStructures_whenNotUniqueLetters_shouldReturnFalse() throws Exception {
        assertFalse(auc.hasAllUniqueCharacters_noAdditionalDataStructures("abcdefABCDa"));
    }

    @Test
    public void hasAllUniqueCharacters_noAdditionalDataStructures_whenUniqueLetters_shouldReturnTrue() throws Exception {
        assertTrue(auc.hasAllUniqueCharacters_noAdditionalDataStructures("abcdefABCD"));
    }

    @Test
    public void hasAllUniqueCharacters_noAdditionalDataStructureswhenNotUniqueCharacters_shouldReturnFalse() throws Exception {
        assertFalse(auc.hasAllUniqueCharacters_noAdditionalDataStructures("1$#^$&8][["));
    }

    @Test
    public void hasAllUniqueCharacters_noAdditionalDataStructures_whenUniqueCharacters_shouldReturnTrue() throws Exception {
        assertTrue(auc.hasAllUniqueCharacters_noAdditionalDataStructures("!@#$%67890]{?>,"));
    }
}