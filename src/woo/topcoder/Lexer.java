package woo.topcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Łukasz on 2017-03-11.
 */
public class Lexer {
    public String[] tokenize(String[] tokens, String input) { // zrobic jako trie
        List<String> consumed = new ArrayList<>();
        while (!input.isEmpty()) {
            String substring = input;
            substringSearch:
            while (substring.length() > 0) {
                for (int i = 0; i < tokens.length; i++) {
                    if (substring.equals(tokens[i])) {
                        consumed.add(substring);
                        break substringSearch;
                    }
                }
                substring = substring.substring(0, substring.length() - 1);
            }
            input = input.substring(substring.length() == 0 ? 1 : substring.length());
        }
        return consumed.toArray(new String[consumed.size()]);
    }
}