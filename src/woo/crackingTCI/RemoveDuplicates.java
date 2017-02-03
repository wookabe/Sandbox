package woo.crackingTCI;

/**
 * Created by Łukasz on 2017-01-31.
 */
// recursively
// create buffer (Set)
// call subroutine on head and buffer
// if head is null then return null
// if head.data is in buffer then return head.next
// add head.data to buffer
// call subroutine with head.next
// assign return value to head.next
// return head
// Q: what type of values the list have?

import java.util.Set;
import java.util.HashSet;

public class RemoveDuplicates {

    public <T> Node<T> removeDuplicatesFromList(Node<T> head) {
        Set<T> buffer = new HashSet<>();
        return removeDuplicatesFromList(head, buffer);
    }

    private <T> Node<T> removeDuplicatesFromList(Node<T> head, Set<T> buffer) {
        if (head == null)
            return null;

        if (buffer.contains(head.data))
            return head.next;

        buffer.add(head.data);
        head.next = removeDuplicatesFromList(head.next, buffer);
        return head;
    }

    public static class Node<T> {
        T data;
        Node<T> next;
    }
}