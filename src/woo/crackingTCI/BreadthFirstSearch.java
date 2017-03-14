package woo.crackingTCI;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {
    private static final int COST = 6;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        for (int qi = 0; qi < q; qi++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            boolean[][] edges = new boolean[n + 1][n + 1];
            for (int mi = 0; mi < m; mi++) {
                int v1 = scan.nextInt();
                int v2 = scan.nextInt();
                edges[v1][v2] = true;
                edges[v2][v1] = true;
            }
            int s = scan.nextInt();
            solve(n, edges, s);
        }
    }

    private static void solve(int n, boolean[][] edges, int s) {
        for (int i = 1; i <= n; i++)
            if (i != s)
                System.out.print(findDist(s, i, edges, n) + " ");
        System.out.println();
    }

    private static int findDist(int from, int to, boolean[][] edges, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] cost = new int[n + 1];

        queue.add(from);
        cost[from] = COST;

        while (!queue.isEmpty()) {
            int v = queue.remove();
            if (edges[v][to]) {
                return cost[v];
            }
            for (int i = 1; i <= n; i++) {
                if (edges[v][i] && cost[i] == 0) {
                    queue.add(i);
                    cost[i] = cost[v] + COST;
                }
            }
        }

        return -1;
    }

}

//    Consider an undirected graph consisting of  nodes where each node is labeled from  to  and the edge between any two nodes is always of length . We define node  to be the starting position for a BFS.
//
//        Given  queries in the form of a graph and some starting node, , perform each query by calculating the shortest distance from starting node  to all the other nodes in the graph. Then print a single line of  space-separated integers listing node 's shortest distance to each of the  other nodes (ordered sequentially by node number); if  is disconnected from a node, print  as the distance to that node.
//
//        Input Format
//
//        The first line contains an integer, , denoting the number of queries. The subsequent lines describe each query in the following format:
//
//        The first line contains two space-separated integers describing the respective values of  (the number of nodes) and  (the number of edges) in the graph.
//        Each line  of the  subsequent lines contains two space-separated integers,  and , describing an edge connecting node  to node .
//        The last line contains a single integer, , denoting the index of the starting node.
//        Constraints
//
//        Output Format
//
//        For each of the  queries, print a single line of  space-separated integers denoting the shortest distances to each of the  other nodes from starting position . These distances should be listed sequentially by node number (i.e., ), but should not include node . If some node is unreachable from , print  as the distance to that node.
//
//        Sample Input
//
//        2
//        4 2
//        1 2
//        1 3
//        1
//        3 1
//        2 3
//        2
//        Sample Output
//
//        6 6 -1
//        -1 6