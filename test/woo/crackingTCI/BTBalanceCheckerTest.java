package woo.crackingTCI;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static woo.crackingTCI.BTBalanceChecker.*;

/**
 * Created by Łukasz on 2017-02-01.
 */
public class BTBalanceCheckerTest {

    private BTBalanceChecker bc;

    @Before
    public void setUp() throws Exception {
        bc = new BTBalanceChecker();
    }

    @Test
    public void isBalanced_whenNull_thenTrue() throws Exception {
        assertTrue(bc.isBalanced(null));
    }

    @Test
    public void isBalanced_whenSingle_thenTrue() throws Exception {
        assertTrue(bc.isBalanced(new Node()));
    }

    @Test
    public void isBalanced_whenOneLeftZeroRight_thenTrue() throws Exception {
        final Node head = new Node();
        head.left = new Node();

        assertTrue(bc.isBalanced(head));
    }

    @Test
    public void isBalanced_whenZeroLeftOneRight_thenTrue() throws Exception {
        final Node head = new Node();
        head.right = new Node();

        assertTrue(bc.isBalanced(head));
    }

    @Test
    public void isBalanced_whenOneLeftOneRight_thenTrue() throws Exception {
        final Node head = new Node();
        head.left = new Node();
        head.right = new Node();

        assertTrue(bc.isBalanced(head));
    }

    @Test
    public void isBalanced_whenTwoLeftZeroRight_thenFalse() throws Exception {
        final Node head = new Node();
        head.left = new Node();
        head.left.left = new Node();

        assertFalse(bc.isBalanced(head));
    }

    @Test
    public void isBalanced_whenZeroLeftTwoRight_thenFalse() throws Exception {
        final Node head = new Node();
        head.right = new Node();
        head.right.right = new Node();

        assertFalse(bc.isBalanced(head));
    }

    @Test
    public void isBalanced_whenThreeLeftTwoRight_thenTrue() throws Exception {
        final Node head = new Node();
        head.right = new Node();
        head.right.right = new Node();
        head.left = new Node();
        head.left.left = new Node();
        head.left.right = new Node();

        assertTrue(bc.isBalanced(head));
    }

    @Test
    public void isBalanced_whenFiveLeftTwoRight_thenFalse() throws Exception {
        final Node head = new Node();
        head.right = new Node();
        head.right.right = new Node();
        head.left = new Node();
        head.left.left = new Node();
        head.left.right = new Node();
        head.left.right.left = new Node();
        head.left.right.left.left = new Node();

        assertFalse(bc.isBalanced(head));
    }
}