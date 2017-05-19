package woo.hackerrank;

/**
 * Created by Łukasz on 2017-05-19.
 */
public class AVLTree {
    static Node insert(Node root, int val) {
        if (root == null)
            root = new Node(val);
        else if (val < root.val)
            root = insertToLeft(root, val);
        else if (val > root.val)
            root = insertToRight(root, val);
        updateHeight(root);
        return root;
    }

    private static Node insertToLeft(Node root, int val) {
        root.left = insert(root.left, val);
        if (isUnbalanced(root))
            root = (val < root.left.val) ? rotateWithLeft(root) : rotateWithRightThenLeft(root);
        return root;
    }

    private static Node insertToRight(Node root, int val) {
        root.right = insert(root.right, val);
        if (isUnbalanced(root))
            root = (val > root.right.val) ? rotateWithRight(root) : rotateWithLeftThenRight(root);
        return root;
    }

    private static boolean isUnbalanced(Node root) {
        return Math.abs(calculateHeight(root.left) - calculateHeight(root.right)) == 2;
    }

    private static Node rotateWithLeft(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        updateHeight(root, newRoot);
        return newRoot;
    }

    private static Node rotateWithRight(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        updateHeight(root, newRoot);
        return newRoot;
    }

    private static Node rotateWithRightThenLeft(Node node) {
        node.left = rotateWithRight(node.left);
        return rotateWithLeft(node);
    }

    private static Node rotateWithLeftThenRight(Node node) {
        node.right = rotateWithLeft(node.right);
        return rotateWithRight(node);
    }

    private static void updateHeight(Node... nodes) {
        for (Node node : nodes)
            node.ht = calculateHeight(node);
    }

    private static int calculateHeight(Node node) {
        return node == null ? -1 : Math.max(calculateHeight(node.left), calculateHeight(node.right)) + 1;
    }

    static class Node {
        int val;   //Value
        int ht;      //Height
        Node left;   //Left child
        Node right;   //Right child

        public Node(int val) {
            this.val = val;
        }
    }
}
