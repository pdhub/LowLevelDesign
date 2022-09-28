package linkedIn.code.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PDeb on 11/5/2017.
 */
public class Graph {

    static class Node{
        int value;
        int weight;
        boolean visited;

        public Node(int value, int weight, boolean visited) {
            this.value = value;
            this.weight = weight;
            this.visited = visited;
        }
    }

    static class Edge {
        int source;
        int dest;
        int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public List<List<Node>> adjacencyList = new ArrayList<List<Node>>();
    //
    public Graph(List<Edge> edges){

        for (int i = 0; i < edges.size(); i++) {
            adjacencyList.add(i, new ArrayList<Node>());
        }

        for (Edge edge: edges) {
            adjacencyList.get(edge.source).add(new Node(edge.dest, edge.weight, false));
            //If graph is undirected then
            //adjacencyList.get(edge.dest).add(new Node(edge.source, edge.weight));
        }
    }
}

