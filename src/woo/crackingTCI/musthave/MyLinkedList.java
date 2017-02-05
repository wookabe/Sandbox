package woo.crackingTCI.musthave;

/**
 * Created by Łukasz on 2017-02-04.
 */
public class MyLinkedList<T> {
    int lastIndex;
    private Node head;

    public MyLinkedList() {
        head = new Node();
        lastIndex = -1;
    }

    public void add(T data) {
        insert(data, lastIndex + 1);
    }

    public void insert(T data, int index) {
        Node node = head;
        int i = 0;
        for (; i < index; i++, node = node.next) {
            if (node.next == null)
                node.next = new Node();
        }
        if (node.data != null) {
            Node next = new Node(node.data);
            next.next = node.next;
            node.next = next;
        }
        node.data = data;
        lastIndex++;
    }

    public void remove() {
        delete(0);
    }

    public void delete(int index) {
        Node node = head;
        int i = 0;
        for (; i < index && node != null; i++, node = node.next) ;
        if (node != null) {
            node.data = node.next != null ? node.next.data : null;
            node.next = node.next != null ? node.next.next : null;
        }
        if (i == lastIndex)
            lastIndex--;
    }

    public T get() {
        return get(lastIndex);
    }

    public T get(int index) {
        Node node = head;
        for (int i = 0; i < index && node != null; i++, node = node.next) ;
        return node == null ? null : node.data;
    }

    public int getIndex(T data) {
        Node node = head;
        for (int i = 0; node != null; i++, node = node.next) {
            if (node.data != null && node.data.equals(data))
                return i;
        }
        return -1;
    }

    private class Node {
        T data;
        Node next;

        Node() {
            this(null);
        }

        Node(T data) {
            this.data = data;
            next = null;
        }
    }
}