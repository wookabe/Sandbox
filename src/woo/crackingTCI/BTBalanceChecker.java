package woo.crackingTCI;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Łukasz on 2017-02-01.
 * <p>
 * 4.1 Implement a function to check if a binary tree is balanced. For the purposes of
 * this question, a balanced tree is defined to be a tree such that the heights of the
 * two subtrees of any node never differ by more than one.
 */
// recursive
// main function - takes reference to Node returns boolean
// if null return true
// call height on left and right subtree and if the height differ by more than one return false
// else check if left and right are balanced
// height function
// if null return 0
// else return max of height on left and right + 1
// Optimization: not to call height each time (perhaps use -1 as error)
// Optimization: Node can hold height

public class BTBalanceChecker {

    public boolean isBalanced(Node head) {
        return new CheckerWithBuffer(head).isBalanced();
    }

    private class CheckerWithBuffer {
        private Node initialHead;
        private final Map<Node, Integer> heights;

        public CheckerWithBuffer(Node head) {
            this.initialHead = head;
            this.heights = new HashMap<>();
        }

        public boolean isBalanced() {
            return isBalanced(initialHead);
        }

        private boolean isBalanced(Node head) {
            if (head == null)
                return true;

            final int leftHeight = height(head.left);
            final int rightHeight = height(head.right);
            if (Math.abs(leftHeight - rightHeight) > 1)
                return false;

            return isBalanced(head.left) && isBalanced(head.right);
        }

        private int height(Node head) {
            if (head == null)
                return 0;

            if (heights.containsKey(head))
                return heights.get(head);

            int height = height(head.left) + height(head.right) + 1;
            heights.put(head, height);
            return height;
        }

    }

    public static class Node {
        Node left, right; // can be without data
    }
}

// first solution
//public class BTBalanceChecker {
//
//    public boolean isBalanced(Node head) {
//        if (head == null)
//            return true;
//
//        if (Math.abs(height(head.left) - height(head.right)) > 1)
//            return false;
//
//        return isBalanced(head.left) && isBalanced(head.right);
//    }
//
//    private int height(Node head) {
//        if (head == null)
//            return 0;
//
//        return height(head.left) + height(head.right) + 1;
//    }
//
//    public static class Node {
//        Node left, right; // can be without data
//    }
//}