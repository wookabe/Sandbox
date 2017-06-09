package woo.hackerrank;

import static woo.hackerrank.AVLTree.Node.calculateHeight;

/**
 * Created by Łukasz on 2017-05-19.
 */
public class AVLTree {
    public static Node insert(Node root, int val) {
        if (root == null)
            root = insertNew(val);
        if (val < root.val)
            root = insertToLeft(root, val);
        if (val > root.val)
            root = insertToRight(root, val);
        root.updateHeight();
        return root;
    }

    private static Node insertNew(int val) {
        return new Node(val);
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
        return Math.abs(calculateHeight(root.left) - calculateHeight(root.right)) > 1;
    }

    private static Node rotateWithRightThenLeft(Node node) {
        node.left = rotateWithRight(node.left);
        return rotateWithLeft(node);
    }

    private static Node rotateWithLeftThenRight(Node node) {
        node.right = rotateWithLeft(node.right);
        return rotateWithRight(node);
    }

    private static Node rotateWithLeft(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.updateHeight();
        return newRoot;
    }

    private static Node rotateWithRight(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.updateHeight();
        return newRoot;
    }

    static class Node {
        final int val;
        int height;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        static int calculateHeight(Node node) {
            return node == null ? -1 : Math.max(calculateHeight(node.left), calculateHeight(node.right)) + 1;
        }

        private void updateHeight() {
            height = calculateHeight(this);
        }
    }
}
