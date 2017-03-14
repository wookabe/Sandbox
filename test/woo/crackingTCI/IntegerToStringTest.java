package woo.crackingTCI;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Łukasz on 2017-03-10.
 */
public class IntegerToStringTest {

    private IntegerToString its;

    private void assertParsed(int n, String parsedN) {
        assertThat(its.parse(n), is(parsedN));
    }

    @Before
    public void setUp() throws Exception {
        its = new IntegerToString();
        System.out.println(0.625 * 10);
        System.out.println((int) (0.625 * 10) / 5);
        System.out.println((0.625 * 10) / 5);
        System.out.println(0.625 * 10 % 5);
        System.out.println(0.625 * 10 % 5 / 10);
        System.out.println((0.625 * 10) % 5);
    }

    @Ignore
    @Test
    public void testPositive() throws Exception {
        assertParsed(0, "Zero");
        assertParsed(1, "One");
        assertParsed(2, "Two");
        assertParsed(10, "Ten");
        assertParsed(15, "Fifteen");
        assertParsed(20, "Twenty");
        assertParsed(21, "Twenty One");
        assertParsed(99, "Ninety Nine");
        assertParsed(100, "One Hundred");
        assertParsed(900, "Nine Hundred");
        assertParsed(101, "One Hundred One");
        assertParsed(123, "One Hundred Twenty Three");
        assertParsed(1000, "One Thousand");
        assertParsed(1001, "One Thousand One");
        assertParsed(1011, "One Thousand Eleven");
        assertParsed(1234, "One Thousand Two Hundred Thirty Four");
        assertParsed(10000, "Ten Thousand");
        assertParsed(10005, "Ten Thousand Five");
        assertParsed(10045, "Ten Thousand Forty Five");
        assertParsed(10345, "Ten Thousand Three Hundred Forty Five");
        assertParsed(12345, "Twelve Thousand Three Hundred Forty Five");
        assertParsed(100000, "One Hundred Thousand");
        assertParsed(123456, "One Hundred Twenty Three Thousand Four Hundred Fifty Six");
        assertParsed(1000000, "One Million");
        assertParsed(1234567, "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven");
        assertParsed(12345678, "Twelve Million Three Hundred Forty Five Thousand Six Hundred Seventy Eight");
        assertParsed(123456789, "One Hundred Twenty Three Million Four Hundred Fifty Six Thousand Seven Hundred " +
                "Eighty Nine");
        assertParsed(1000000000, "One Billion");
        assertParsed(Integer.MAX_VALUE, "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three " +
                "Thousand Six Hundred Forty Seven");
    }

    @Test
    public void testNegative() throws Exception {
        assertParsed(-1, "Minus One");
        assertParsed(-123, "Minus One Hundred Twenty Three");
        assertParsed(Integer.MIN_VALUE, "Minus Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three " +
                "Thousand Six Hundred Forty Eight");
    }

}