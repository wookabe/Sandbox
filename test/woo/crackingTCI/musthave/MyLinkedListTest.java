package woo.crackingTCI.musthave;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Łukasz on 2017-02-04.
 */
public class MyLinkedListTest {

    private MyLinkedList<String> mll;

    @Before
    public void setUp() throws Exception {
        mll = new MyLinkedList<>();
    }

    @Test
    public void add_whenEmpty_shouldAdd() throws Exception {
        mll.add("0");

        assertEquals("0", mll.get());
    }

    @Test
    public void insert_whenEmptyAndZeroIndex_shouldInsertAtBeginning() throws Exception {
        mll.insert("0", 0);

        assertEquals("0", mll.get());
    }

    @Test
    public void insert_whenEmptyAndPastSize_shouldInsertAtIndex() throws Exception {
        mll.insert("0", 100);

        assertEquals("0", mll.get(100));
    }

    @Test
    public void insert_whenMultiple_shouldInsertAtIndex() throws Exception {
        mll.add("0");
        mll.add("1");
        mll.add("2");
        mll.add("3");
        mll.add("4");

        mll.insert("123", 3);

        assertEquals("0", mll.get(0));
        assertEquals("1", mll.get(1));
        assertEquals("2", mll.get(2));
        assertEquals("123", mll.get(3));
        assertEquals("3", mll.get(4));
        assertEquals("4", mll.get(5));
    }

    @Test
    public void remove_whenEmpty_shouldDonNothing() throws Exception {
        mll.remove();

        assertNull(mll.get());
    }

    @Test
    public void remove_whenMultiple_shouldRemoveFirst() throws Exception {
        mll.add("0");
        mll.add("1");
        mll.add("2");

        mll.remove();

        assertEquals("1", mll.get(0));
        assertEquals("2", mll.get(1));
        assertNull(mll.get(2));
    }

    @Test
    public void delete_whenEmpty_shouldDoNothing() throws Exception {
        mll.delete(0);

        assertNull(mll.get());
    }

    @Test
    public void delete_whenPastSize_shouldDoNothing() throws Exception {
        mll.add("0");

        mll.delete(100);

        assertEquals("0", mll.get());
    }

    @Test
    public void delete_whenMultiple_shouldDeleteAtIndex() throws Exception {
        mll.add("0");
        mll.add("1");
        mll.add("2");
        mll.add("3");
        mll.add("4");

        mll.delete(3);

        assertEquals("0", mll.get(0));
        assertEquals("1", mll.get(1));
        assertEquals("2", mll.get(2));
        assertEquals("4", mll.get(3));
        assertNull(mll.get(4));
    }

    @Test
    public void get_whenEmpty_shouldReturnNull() throws Exception {
        assertNull(mll.get());
    }

    @Test
    public void get_whenOne_returnOne() throws Exception {
        mll.add("0");

        assertEquals("0", mll.get());
    }

    @Test
    public void get_whenMultiple_returnLatestAdded() throws Exception {
        mll.add("0");
        mll.add("1");
        mll.add("2");

        assertEquals("2", mll.get());
    }

    @Test
    public void get_whenEmpty_returnNull() throws Exception {
        assertNull(mll.get(0));
    }

    @Test
    public void get_whenMultiple_returnAtIndex() throws Exception {
        mll.add("0");
        mll.add("1");
        mll.add("2");
        mll.add("3");
        mll.add("4");

        assertEquals("3", mll.get(3));
    }

    @Test
    public void get_whenPastSize_returnNull() throws Exception {
        mll.add("0");
        mll.add("1");
        mll.add("2");
        mll.add("3");
        mll.add("4");

        assertNull(mll.get(5));
    }

    @Test
    public void getIndex_whenNotExists_returnMinusOne() throws Exception {
        mll.add("0");
        mll.add("1");
        mll.add("2");
        mll.add("3");
        mll.add("4");

        assertEquals(-1, mll.getIndex("5"));
    }

    @Test
    public void getIndex_whenExists_returnValue() throws Exception {
        mll.add("0");
        mll.add("1");
        mll.add("2");
        mll.add("3");
        mll.add("4");

        assertEquals(0, mll.getIndex("0"));
        assertEquals(1, mll.getIndex("1"));
        assertEquals(2, mll.getIndex("2"));
        assertEquals(3, mll.getIndex("3"));
        assertEquals(4, mll.getIndex("4"));
    }
}