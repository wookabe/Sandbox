package woo.crackingTCI;

/**
 * 2.2 Implement an algorithm to find the kth to last element of a singly linked list.
 */
// two pointers
// p1 starts
// p2 starts after p1 moves for the kth time
// they go until p1 reaches the end
// p2 points to the kth element from the end

public class KthToLastElementFinder {

    public Node findKthToLast(Node head, int k) {
        if (!areValid(head, k))
            return null;

        Node p1 = head, p2 = null;
        int count = 0;
        while (p1 != null) {
            p1 = p1.next;
            if (count++ == k)
                p2 = head;
            else if (count > k)
                p2 = p2.next;
        }
        return p2;
    }

    private boolean areValid(Node head, int k) {
        return head != null && k >= 0;
    }

    public static class Node {
        Node next;
    }
}