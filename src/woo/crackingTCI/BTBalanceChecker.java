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

// with buffer
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

// first, straightforward solution (not optimal)
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
//        return Math.max(height(head.left),height(head.right)) + 1;
//    }
//
//    public static class Node {
//        Node left, right; // can be without data
//    }
//}


// with calculating starting from the bottom
//public class BTBalanceChecker {
//    public boolean isBalanced(Node head) {
//        return isBalancedR(head);
//    }
//
//    private boolean isBalancedR(Node head) {
//        if (head == null)
//            return true;
//
//        if (!isBalancedR(head.left) || !isBalancedR(head.right))
//            return false;
//
//        if (Math.abs(height(head.left) - height(head.right)) > 1)
//            return false;
//        else
//            return true;
//    }
//
//    private int height(Node head) {
//        if (head == null)
//            return 0;
//
//        return Math.max(height(head.left),height(head.right)) + 1;
//    }
//
//    public static class Node {
//        Node left, right; // can be without data
//    }
//}


// with special value -1
//public class BTBalanceChecker {
//
//    public static final int NOT_BALANCED = -1;
//    private long count;
//
//    public boolean isBalanced(Node head) {
//        return height(head) != NOT_BALANCED;
//    }
//
//    private int height(Node head) {
//        System.out.println("Count height: " + ++count);
//        if (head == null)
//            return 0;
//
//        int leftHeight, rightHeight;
//        if ((leftHeight = height(head.left)) == NOT_BALANCED
//                || (rightHeight = height(head.right)) == NOT_BALANCED
//                || Math.abs(leftHeight - rightHeight) > 1)
//            return NOT_BALANCED;
//        else
//            return Math.max(leftHeight, rightHeight) + 1;
//    }
//
//    public static class Node {
//        Node left, right; // can be without data
//    }
//}


// with Exception
//public class BTBalanceChecker {
//    public boolean isBalanced(Node head) {
//        try {
//            calculateHeightIfBalanced(head);
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
//
//    private int calculateHeightIfBalanced(Node head) throws Exception {
//        if (head == null)
//            return 0;
//
//        int leftHeight = calculateHeightIfBalanced(head.left);
//        int rightHeight = calculateHeightIfBalanced(head.right);
//
//        if (Math.abs(leftHeight - rightHeight) > 1)
//            throw new Exception();
//
//        return Math.max(leftHeight, rightHeight) + 1;
//    }
//
//    public static class Node {
//        Node left, right; // can be without data
//    }
//}