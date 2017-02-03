package woo.crackingTCI;

/**
 * Created by Łukasz on 2017-01-31.
 * <p>
 * 1.1 Implement an algorithm to determine if a string has all unique characters. What
 * if you cannot use additional data structures?
 */
// create data structure to hold previous characters
// array of booleans with 26 elements or 256 elements with index corresponding to
// character index and if value at a particular index is true then the character
// was previously detected
// hash map with characters found as keys - no need because there’s no values
// set with characters - unique with “contains” check - straightforward and dynamic
// go over the string characters
// if a character has been found previously - return false
// if all characters are checked - return true

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AllUniqueCharacters {

    public boolean hasAllUniqueCharacters(String s) {
        if (isInvalid(s)) return false;

        Set<Character> found = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (found.contains(c))
                return false;
            found.add(c);
        }

        return true;
    }

    public boolean hasAllUniqueCharacters_noAdditionalDataStructures(String s) {
        if (isInvalid(s)) return false;
        return hasAllUniqueCharacters(transformToSortedCharArray(s));
    }

    private boolean hasAllUniqueCharacters(char[] sc) {
        for (int i = 0; i < sc.length - 1; i++) {
            if (sc[i] == sc[i + 1])
                return false;
        }
        return true;
    }

    private char[] transformToSortedCharArray(String s) {
        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        return sc;
    }

    private boolean isInvalid(String s) {
        if (s == null || s.isEmpty())
            return true; // we could also throw an InvalidArgumentException
        assert s.length() > 0;
        return false;
    }
}
