package woo.crackingTCI;

/**
 * Created by Łukasz on 2017-05-30.
 */
public class StringRotationChecker {

    public boolean areRotations(String s1, String s2) {
        return areValid(s1, s2) && (s1 + s1).contains(s2);
    }

    private boolean areValid(String s1, String s2) {
        return s1 != null && s2 != null && s1.length() == s2.length();
    }
}

