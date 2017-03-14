package woo.crackingTCI;

/**
 * 4.3 Given a sorted (increasing order) array with unique integer elements, write an
 algorithm to create a binary search tree with minimal height.
 */
// array is sorted
// and binary search tree is also sorted
// so we need to translate into BST
// binary search method comes to mind as in sorted array the mid element should be at the top of corresponding BST and then we add left and right nodes by taking the mid of left side and right
// so if start > end exit, else create element and call recursively on (start, mid - 1) and (mid + 1) right

public class SortedArrayToBST {

    public Node toBST(int[] a) {
        if (a == null || a.length == 0)
            return null;

        return toBST(a, 0, a.length - 1);
    }

    private Node toBST(int[] a, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2; // or start + (end - start) / 2
        return new Node(a[mid], toBST(a, start, mid - 1),toBST(a, mid + 1, end));
    }

    public static class Node {
        int data;
        Node left, right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (data != node.data) return false;
            if (left != null ? !left.equals(node.left) : node.left != null) return false;
            return right != null ? right.equals(node.right) : node.right == null;
        }

        @Override
        public int hashCode() {
            int result = data;
            result = 31 * result + (left != null ? left.hashCode() : 0);
            result = 31 * result + (right != null ? right.hashCode() : 0);
            return result;
        }
    }
}