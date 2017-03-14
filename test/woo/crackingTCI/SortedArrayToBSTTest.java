package woo.crackingTCI;

import org.junit.Before;
import org.junit.Test;
import woo.crackingTCI.SortedArrayToBST.Node;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Łukasz on 2017-03-14.
 */
public class SortedArrayToBSTTest {

    private SortedArrayToBST satb;

    private void assertTree(Node tree, int[] array) {
        assertThat(tree, is(satb.toBST(array)));
    }

    private void assertTreeStructure(int arraySize, int... values) {
        assertTree(createNode(0, values), IntStream.range(1, arraySize + 1).toArray());
    }

    private Node createNode(int index, int[] values) {
        return index >= values.length || values[index] == -1
                ? null
                : new Node(values[index], createNode(2 * index + 1, values), createNode(2 * index + 2, values));
    }

    @Before
    public void setUp() throws Exception {
        satb = new SortedArrayToBST();
    }

    @Test
    public void testInvalid() throws Exception {
        assertTree(null, null);
        assertTree(null, new int[0]);
    }

    @Test
    public void testOne() throws Exception {
        assertTreeStructure(1, 1);
    }

    @Test
    public void testTwo() throws Exception {
        assertTreeStructure(2, 1, -1, 2);
    }

    @Test
    public void testThree() throws Exception {
        assertTreeStructure(3, 2, 1, 3);
    }

    @Test
    public void testFour() throws Exception {
        assertTreeStructure(4, 2, 1, 3, -1, -1, -1, 4);
    }

    @Test
    public void testFive() throws Exception {
        assertTreeStructure(5, 3, 1, 4, -1, 2, -1, 5);
    }

    @Test
    public void testSix() throws Exception {
        assertTreeStructure(6, 3, 1, 5, -1, 2, 4, 6);
    }

    @Test
    public void testSeven() throws Exception {
        assertTreeStructure(7, 4, 2, 6, 1, 3, 5, 7);
    }
}