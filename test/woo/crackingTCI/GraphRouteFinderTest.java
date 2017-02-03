package woo.crackingTCI;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static woo.crackingTCI.GraphRouteFinder.Node;

/**
 * Created by Łukasz on 2017-02-01.
 */
public class GraphRouteFinderTest {

    private GraphRouteFinder grf;

    @Before
    public void setUp() throws Exception {
        grf = new GraphRouteFinder();
    }

    @Test
    public void areConnected_whenOneNullTwoNull_thenFalse() throws Exception {
        assertFalse(grf.areConnected(null, null));
    }

    @Test
    public void areConnected_whenOneNull_thenFalse() throws Exception {
        assertFalse(grf.areConnected(null, new Node()));
    }

    @Test
    public void areConnected_whenTwoNull_thenFalse() throws Exception {
        assertFalse(grf.areConnected(new Node(), null));
    }

    @Test
    public void areConnected_whenSame_thenTrue() throws Exception {
        final Node node = new Node();
        assertTrue(grf.areConnected(node, node));
    }

    @Test
    public void areConnected_whenSimpleRoute_thenTrue() throws Exception {
        Node one = new Node();
        Node two = new Node();
        Node three = new Node();
        one.adjacent = new Node[]{two};
        two.adjacent = new Node[]{three};

        assertTrue(grf.areConnected(one, three));
    }

    @Test
    public void areConnected_whenCycleAndSimpleRoute_thenTrue() throws Exception {
        Node one = new Node();
        Node two = new Node();
        Node three = new Node();
        one.adjacent = new Node[]{two};
        two.adjacent = new Node[]{one, three};

        assertTrue(grf.areConnected(one, three));
    }

    @Test
    public void areConnected_whenCycleAndNoRoute_thenFalse() throws Exception {
        Node one = new Node();
        Node two = new Node();
        Node three = new Node();
        one.adjacent = new Node[]{two};
        two.adjacent = new Node[]{one, three};

        assertFalse(grf.areConnected(one, new Node()));
    }

    @Test
    public void areConnected_whenMultipleRoutes_shouldFindLeftmost() throws Exception {
        DecoratedNode one = new DecoratedNode();
        DecoratedNode two = new DecoratedNode();
        DecoratedNode three = new DecoratedNode();
        DecoratedNode four = new DecoratedNode();
        one.adjacent = new DecoratedNode[]{two, three};
        two.adjacent = new DecoratedNode[]{four};
        three.adjacent = new DecoratedNode[]{four};

        assertTrue(grf.areConnected(one, four));
        assertTrue(two.visited);
        assertFalse(three.visited);
    }

    private class DecoratedNode extends Node {
        boolean visited = false;

        @Override
        public boolean equals(Object obj) {
            visited = true;
            return super.equals(obj);
        }
    }
}