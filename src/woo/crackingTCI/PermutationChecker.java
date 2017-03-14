package woo.crackingTCI;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 1.3 Given two strings, write a method to decide if one is a permutation of the other.
 */
// permutation - the same number of characters in different order
// could use map to count the occurrences of each character
// but can be done also by sorting the characters and comparing in one loop (no extra space)
// but let’s do with array of char, first loop adds, the second removes and if 0 then true

public class PermutationChecker {

    public boolean arePermutations(String s1, String s2) { // with stream
        if (!areValid(s1, s2))
            return false; // perhaps throw an exception

        int[] buffer = new int['z' - 'a' + 1];
        IntStream.range(0, s1.length()).forEach(i -> {
            buffer[s1.toLowerCase().charAt(i) - 'a']++;
            buffer[s2.toLowerCase().charAt(i) - 'a']--;
        });
        return Arrays.stream(buffer).allMatch(i -> i == 0);
    }

    public boolean arePermutationsV2(String s1, String s2) { // with stream
        if (!areValid(s1, s2))
            return false; // perhaps throw an exception

        int[] buffer = new int['z' - 'a' + 1];
        s1.toLowerCase().chars().forEach(i -> buffer[i - 'a']++);
        s2.toLowerCase().chars().forEach(i -> buffer[i - 'a']--);
        return Arrays.stream(buffer).noneMatch(i -> i != 0);
    }

    public boolean arePermutationsBuffer(String s1, String s2) {
        if (!areValid(s1, s2))
            return false; // perhaps throw an exception

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] buffer = new int['z' - 'a' + 1];
        for (char c : s1.toCharArray()) // we could also do by stream
            buffer[c - 'a']++;
        for (char c : s2.toCharArray()) // or could do in one loop if lengths are the same
            buffer[c - 'a']--;
        for (int count : buffer)
            if (count != 0)
                return false;
        return true;
    }

    private boolean areValid(String s1, String s2) {
        return s1 != null && s2 != null; // we could also check s1.length() == s2.length()
    }
}