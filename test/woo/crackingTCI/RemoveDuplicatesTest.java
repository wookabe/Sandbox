package woo.crackingTCI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import woo.crackingTCI.RemoveDuplicates.Node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Łukasz on 2017-01-31.
 */
public class RemoveDuplicatesTest {

    private RemoveDuplicates rd;

    @Before
    public void setUp() throws Exception {
        rd = new RemoveDuplicates();
    }

    @Test
    public void removeDuplicatesFromList_whenNull_shouldReturnNull() throws Exception {
        Assert.assertNull(rd.removeDuplicatesFromList(null));
    }

    @Test
    public void removeDuplicatesFromList_whenSingleValue_shouldReturnHead() throws Exception {
        final Node head = new Node();

        assertEquals(head, rd.removeDuplicatesFromList(head));
    }

    @Test
    public void removeDuplicatesFromList_whenMultipleUniqueValues_shouldReturnSameList() throws Exception {
        final Node head = createFiveElemDistinctList();

        assertEquals(head, rd.removeDuplicatesFromList(head));
        assertEquals(5, countElems(head));
    }

    @Test
    public void removeDuplicatesFromList_whenMultipleNotUniqueValues_shouldReturnListWithoutDuplicates() throws Exception {
        Node head = createFiveElemListWithDuplicates();
        Node tmp = head.next;

        head = rd.removeDuplicatesFromList(head);

        assertNotEquals(tmp, head.next);
        assertEquals(4, countElems(head));
    }

    private Node createFiveElemDistinctList() {
        Node<Integer> head = new Node<>();
        head.data = 1;
        Node<Integer> tmp = head;
        for (int i = 0; i < 4; i++, tmp = tmp.next) {
            tmp.next = new Node<>();
            tmp.next.data = tmp.data + 1;
        }
        return head;
    }

    private int countElems(Node head) {
        int count = 0;
        for (Node tmp = head; tmp != null; count++, tmp = tmp.next) ;
        return count;
    }

    private Node createFiveElemListWithDuplicates() {
        Node head = createFiveElemDistinctList();
        head.data = head.next.data;
        return head;
    }
}