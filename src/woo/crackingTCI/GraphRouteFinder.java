package woo.crackingTCI;

/**
 * Created by Łukasz on 2017-02-01.
 * <p>
 * 4.2 Given a directed graph, design an algorithm to find out whether there is a route
 * between two nodes.
 */
// Graph - Node with a table of adjacent Nodes
// kill cycles
// iterate over adjacent recursively until found or not found
// if one found return true
// Follow-up: how about finding the shortest path

import java.util.HashSet;
import java.util.Set;

public class GraphRouteFinder {

    public boolean areConnected(Node one, Node two) {
        return new Finder(one, two).areConnected();
    }

    public static class Node {
        Node[] adjacent = new Node[0];
    }

    private class Finder {
        private final Node one;
        private final Node two;
        private final Set<Node> visited;

        public Finder(Node one, Node two) {
            this.one = one;
            this.two = two;
            this.visited = new HashSet<>();
        }

        public boolean areConnected() {
            return isConnected(one);
        }

        private boolean isConnected(Node one) {
            if (isInvalid(one) || isCycle(one)) return false;
            if (isFound(one)) return true;
            markAsVisited(one);
            return checkAdjacent(one);
        }

        private boolean checkAdjacent(Node one) {
            for (Node n : one.adjacent) {
                if (isConnected(n))
                    return true;
            }
            return false;
        }

        private void markAsVisited(Node one) {
            visited.add(one);
        }

        private boolean isFound(Node one) {
            return one.equals(two);
        }

        private boolean isInvalid(Node one) {
            return one == null || two == null;
        }

        private boolean isCycle(Node one) {
            return visited.contains(one);
        }
    }
}

// without inner object
//public class GraphRouteFinder {
//
//    public boolean areConnected(Node one, Node two) {
//        return areConnected(one, two, new HashSet<>());
//    }
//
//    private boolean areConnected(Node one, Node two, Set<Node> visited) {
//        if (one == null || two == null || visited.contains(one))
//            return false;
//
//        if (one.equals(two))
//            return true;
//
//        visited.add(one);
//
//        for(Node n : one.adjacent) {
//            if (areConnected(n, two, visited))
//                return true;
//        }
//
//        return false;
//    }
//
//    public static class Node {
//        Node[] adjacent = new Node[0];
//    }
//}