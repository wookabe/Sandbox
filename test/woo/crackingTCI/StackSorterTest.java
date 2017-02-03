package woo.crackingTCI;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.Stack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Łukasz on 2017-01-31.
 */
public class StackSorterTest {

    private StackSorter ss;

    @Before
    public void setUp() throws Exception {
        ss = new StackSorter();
    }

    @Test
    public void sort_whenNullOrEmpty_shouldDoNothing() throws Exception {
        ss.sort(null);
        ss.sort(new Stack<>());
    }

    @Test
    public void sort_whenSingleElem_shouldDoNothing() throws Exception {
        Stack<Integer> st = new Stack<>();
        st.push(1);

        ss.sort(st);

        assertEquals(1, st.size());
        assertThat(st.pop(), is(1));
    }

    @Test
    public void sort_whenSorted_shouldDoNothing() throws Exception {
        Stack<Integer> st = createFiveElemSortedStack();

        ss.sort(st);

        assertEquals(5, st.size());
        assertThat(st.pop(), is(5));
        assertThat(st.pop(), is(4));
        assertThat(st.pop(), is(3));
        assertThat(st.pop(), is(2));
        assertThat(st.pop(), is(1));
    }

    @Test
    public void sort_whenReverseSorted_shouldSort() throws Exception {
        Stack<Integer> st = createFiveElemReverseSortedStack();

        ss.sort(st);

        assertEquals(5, st.size());
        assertThat(st.pop(), is(5));
        assertThat(st.pop(), is(4));
        assertThat(st.pop(), is(3));
        assertThat(st.pop(), is(2));
        assertThat(st.pop(), is(1));
    }

    @Test
    public void sort_whenRandomized_shouldSort() throws Exception {
        Stack<Integer> st = createTenElemRandomStack();

        //System.out.println(st);
        ss.sort(st);
       // System.out.println(st);

        assertEquals(10, st.size());
        int tmp = st.pop();
        while (!st.isEmpty()) {
            assertTrue(tmp >= st.peek());
            tmp = st.pop();
        }
    }

    private Stack<Integer> createFiveElemSortedStack() {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 5; i++,
                st.push(i))
            ;
        return st;
    }

    private Stack<Integer> createFiveElemReverseSortedStack() {
        Stack<Integer> st = new Stack<>();
        for (int i = 6; i > 1; i--, st.push(i)) ;
        return st;
    }

    private Stack<Integer> createTenElemRandomStack() {
        Stack<Integer> st = new Stack<>();
        final Random random = new Random();
        for (int i = 0; i < 10; i++,
                st.push(random.nextInt(100)))
            ;
        return st;
    }
}
