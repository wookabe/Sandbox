package woo.hackerrank;

import org.junit.Test;
import woo.hackerrank.AVLTree.Node;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Łukasz on 2017-05-19.
 */
public class AVLTreeTest {

    @Test
    public void testInsert1() throws Exception {
        Node root = insert(3);

        assertVal(root, 3);
    }

    @Test
    public void testInsert2() throws Exception {
        Node root = insert(3, 2);

        assertVal(root, 3);
        assertVal(root.left, 2);
    }

    @Test
    public void testInsert3() throws Exception {
        Node root = insert(3, 2, 4);

        assertVal(root, 3);
        assertVal(root.left, 2);
        assertVal(root.right, 4);
    }

    @Test
    public void testInsert4() throws Exception {
        Node root = insert(3, 2, 4, 5);

        assertVal(root, 3);
        assertVal(root.left, 2);
        assertVal(root.right, 4);
        assertVal(root.right.right, 5);
    }

    @Test
    public void testInsert5() throws Exception {
        Node root = insert(3, 2, 4, 5, 6);

        assertVal(root, 3);
        assertVal(root.left, 2);
        assertVal(root.right, 5);
        assertVal(root.right.left, 4);
        assertVal(root.right.right, 6);
    }

    @Test
    public void testInsertHeights() throws Exception {
        Node root = insert(3, 2, 4, 5, 6);

        assertHeight(root, 2);
        assertHeight(root.left, 0);
        assertHeight(root.right, 1);
        assertHeight(root.right.left, 0);
        assertHeight(root.right.right, 0);
    }

    private Node insert(int... vals) {
        Node root = null;
        for (int val : vals)
            root = AVLTree.insert(root, val);
        return root;
    }

    private void assertVal(Node root, int val) {
        assertThat(root.val, is(val));
    }

    private void assertHeight(Node root, int height) {
        assertThat(root.height, is(height));
    }
}