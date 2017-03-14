package woo.crackingTCI;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Łukasz on 2017-03-10.
 */
public class IntegerToString {
    private static final Map<Integer, String> digitMapping;
    private static final Map<Integer, String> bracketMapping;

    static {
        digitMapping = new HashMap<>();
        digitMapping.put(0, "Zero");
        digitMapping.put(1, "One");
        digitMapping.put(2, "Two");
        digitMapping.put(3, "Three");
        digitMapping.put(4, "Four");
        digitMapping.put(5, "Five");
        digitMapping.put(6, "Six");
        digitMapping.put(7, "Seven");
        digitMapping.put(8, "Eight");
        digitMapping.put(9, "Nine");
        digitMapping.put(10, "Ten");
        digitMapping.put(11, "Eleven");
        digitMapping.put(12, "Twelve");
        digitMapping.put(13, "Thirteen");
        digitMapping.put(14, "Fourteen");
        digitMapping.put(15, "Fifteen");
        digitMapping.put(16, "Sixteen");
        digitMapping.put(17, "Seventeen");
        digitMapping.put(18, "Eighteen");
        digitMapping.put(19, "Nineteen");
        digitMapping.put(20, "Twenty");
        digitMapping.put(30, "Thirty");
        digitMapping.put(40, "Forty");
        digitMapping.put(50, "Fifty");
        digitMapping.put(60, "Sixty");
        digitMapping.put(70, "Seventy");
        digitMapping.put(80, "Eighty");
        digitMapping.put(90, "Ninety");
        digitMapping.put(100, "Hundred");

        bracketMapping = new HashMap<>();
        bracketMapping.put(1, "");
        bracketMapping.put(1000, "Thousand");
        bracketMapping.put(1000000, "Million");
        bracketMapping.put(1000000000, "Billion");
    }

    public String parse(int n) {
        if (n == Integer.MIN_VALUE)
            return "Minus " + parse(-(n+8)) + " " + digitMapping.get(8);
        if (n < 0)
            return "Minus " + parse(-n);
        if (n == 0)
            return "Zero";
        return parse(n, 1000000000).trim();
    }

    private String parse(int n, int bracket) {
        if (bracket < 1)
            return "";
        if (n < bracket)
            return parse(n, bracket / 1000);
        int number = n / bracket;
        return parseThousand(number) + " " + bracketMapping.get(bracket) + " " + parse(n % bracket, bracket / 1000);
    }

    private String parseThousand(int n) {
        if (n < 100) {
            if (digitMapping.containsKey(n))
                return digitMapping.get(n);
            return digitMapping.get(n - n % 10) + " " + parse(n % 10);
        }
        String result = digitMapping.get(n / 100) + " " + digitMapping.get(100);
        if (n % 100 > 0)
            result += " " + parseThousand(n % 100);
        return result;
    }

}
