package woo.hackerrank;

import java.util.*;

/**
 * Created by Łukasz on 2017-05-30.
 */
public class TravellingSalesman {
    private static boolean log = false;


    public static void main(String[] args) {
        Node[][] graph = new GraphBuilder(new Scanner(System.in)).buildGraph();
        System.out.println(new BruteForceGraphSolver().solve(graph));
    }

    private static class GraphBuilder {
        private final Scanner scan;
        private int m;
        private int n;
        Node[][] nodes;

        public GraphBuilder(Scanner scan) {
            this.scan = scan;
        }

        public Node[][] buildGraph() {
            readDimensions();
            createNodesMatrix();
            readEdges();
            if (log) System.out.println(m + " x " + n + "\n" + Arrays.deepToString(nodes));
            return nodes;
        }

        private void readDimensions() {
            m = scan.nextInt();
            n = scan.nextInt();
        }

        private void createNodesMatrix() {
            nodes = new Node[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    nodes[i][j] = new Node(i, j);
        }

        private void readEdges() {
            addEdges(m, n - 1, 0, 1);
            addEdges(m - 1, n, 1, 0);
        }

        private void addEdges(int rows, int cols, int rowIndexModifier, int columnIndexModifier) {
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++) {
                    int cost = scan.nextInt();
                    nodes[i][j].addEdge(nodes[i+rowIndexModifier][j+columnIndexModifier], cost);
                }
        }
    }

    private static class BruteForceGraphSolver {
        private int solve(Node[][] graph) {
            Node start = graph[0][0];
            int nOfNodes = graph.length * graph[0].length;
            if (log) System.out.println("start = " + start + ", nOfNodes = " + nOfNodes);
            int time = Integer.MAX_VALUE;
            for(Node node : start.edgeCost.keySet()) {
                int nodePartial = solvePartial(node, start, new HashSet<>(), nOfNodes);
                int cost = (nodePartial == Integer.MAX_VALUE) ? Integer.MAX_VALUE : start.edgeCost.get(node) + nodePartial;
                time = Math.min(time, cost);
                if (log) System.out.println("solution: " + time);
            }
            return (time == Integer.MAX_VALUE) ? 0 : time;
        }

        private int solvePartial(Node node, Node start, Set<Node> visited, int nOfNodes) {
            visited.add(node);
            if (log) System.out.println("node: " + node + "\n\t" + visited);
            int time = Integer.MAX_VALUE;
            for(Node adjNode : node.edgeCost.keySet()) {
                if (!visited.contains(adjNode)) {
                    int nodePartial = solvePartial(adjNode, start, new HashSet<>(visited), nOfNodes);
                    int cost = (nodePartial == Integer.MAX_VALUE) ? Integer.MAX_VALUE : node.edgeCost.get(adjNode) + nodePartial;
                    time = Math.min(time, cost);
                }
            }
            int ret =  (time == Integer.MAX_VALUE && visited.size() == nOfNodes && node == start) ? 0 : time;
            if (log) System.out.println("node " + node + " returns: " + ret);
            return ret;
        }
    }

    private static class Node {
        private int i;
        private int j;
        private Map<Node, Integer> edgeCost = new HashMap<>();

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public void addEdge(Node n, Integer cost) {
            edgeCost.put(n, cost);
            n.edgeCost.put(this, cost);
        }

        public String toString() {
            return "(" + i + "," + j + ") -> " + edgeCost.values();
        }
    }
}
