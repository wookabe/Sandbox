package woo.general;

import org.junit.Ignore;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Łukasz on 2016-11-16.
 */
public class VariousTest {

    @Ignore
    @Test
    public void testString() {
        String s = "testowy";
        String substringIndex = "st";
        char c = 'o';
        int beginIndex = 1;
        int endIndex = 3;

        System.out.println("Working on \"" + s + "\"");

        int i = s.indexOf(substringIndex);
        System.out.println("Index of \"" + substringIndex +"\": " + i);

        i = s.indexOf(c);
        System.out.println("Index of '" + c + "': " + i);

        String substring = s.substring(beginIndex, endIndex);
        System.out.println("The substring for beginIndex=" + beginIndex + " and endIndex=" + endIndex + ": " + substring);
    }

    @Ignore
    @Test
    public void testSwapValues() {
        LinkedList linkedList = new LinkedList<>();
        List<String> list = linkedList;

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        System.out.println("First solution");
        for (int i = list.size() - 2; i >= 0; i--) {
            System.out.println("Entering " + i);
            final String remove = list.remove(i);
            System.out.println(list);
            list.add(remove);
            System.out.println(list);
        }

        System.out.println("\nSecond solution");
        for (int leftIndex = 0, mid = list.size() >> 1, rightIndex = list.size() - 1;
             leftIndex < mid;
             leftIndex++, rightIndex--) {
            System.out.println("Entering " + leftIndex);
            System.out.println(list);
            list.set(leftIndex, list.set(rightIndex, list.get(leftIndex)));
            System.out.println(list);
        }

        System.out.println("\nThird solution");
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }

    @Test
    public void testDataStructures() {
        Enumeration e = new Enumeration() {
            @Override
            public boolean hasMoreElements() {
                return false;
            }

            @Override
            public Object nextElement() {
                return null;
            }
        };

        BitSet bs = new BitSet();
        System.out.println("BitSet: " + bs);
        bs.set(1);
        bs.set(10);
        bs.set(0);
        System.out.println("BitSet: " + bs);

        Vector<String> v = new Vector();
        v.add("a");
        v.add("b");
        System.out.println("Vector: " + v);
        final List<String> collect = v.stream().map(s -> s = s + " i co z tego").collect(Collectors.toList());
        System.out.println("Vector: " + v);
        System.out.println("After Collect: " + collect);

        Stack<Integer> stack = new Stack<>();
        stack.push(12);
        System.out.println("Stack: " + stack);
        stack.pop();
        System.out.println("Stack: " + stack);
        stack.push(1);
        stack.push(2);
        System.out.println("Stack: " + stack);
        for (int i : stack) {
            System.out.println(i);
            stack.pop();
        }
        System.out.println("Stack: " + stack);
        stack.removeAllElements();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        Dictionary<String, Integer> d = new Dictionary<String, Integer>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public Enumeration<String> keys() {
                return null;
            }

            @Override
            public Enumeration<Integer> elements() {
                return null;
            }

            @Override
            public Integer get(Object key) {
                return null;
            }

            @Override
            public Integer put(String key, Integer value) {
                return null;
            }

            @Override
            public Integer remove(Object key) {
                return null;
            }
        };


    }

}
