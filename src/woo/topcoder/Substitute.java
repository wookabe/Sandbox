package woo.topcoder;

// A simple, easy to remember system for encoding integer amounts can be very useful. For example, dealers at flea
// markets put the information about an item on a card that they let potential buyers see. They find it advantageous
// to encode the amount they originally paid for the item on the card.
//
// A good system is to use a substitution code, in which each digit is encoded by a letter. An easy to remember
// 10-letter word or phrase, the key, is chosen. Every '1' in the value is replaced by the first letter of the key,
// every '2' is replaced by the second letter of the key, and so on. Every '0' is replaced by the last letter of the
// key. Letters that do not appear in the key can be inserted anywhere without affecting the value represented by the
// code.. This helps to make the resulting code much harder to break (without knowing the key).
//
// Create a class Substitute that contains the method getValue that is given the s key and code as input and that
// returns the decoded value.

public class Substitute {
    public int getValue(String key, String code) {
        String value = "";
        for (char c : code.toCharArray()) {
            final int indexOfc = key.indexOf(c);
            if (indexOfc > -1)
                value += (indexOfc + 1) % 10;
        }
        return Integer.valueOf(value);
    }
}
