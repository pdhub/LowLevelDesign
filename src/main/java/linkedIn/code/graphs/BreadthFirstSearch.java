package linkedIn.code.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by PDeb on 11/5/2017.
 */
public class BreadthFirstSearch {

    public void bfs(Graph graph, int nodeVal, boolean[] visited){

        Queue queue = new LinkedList();

        queue.offer(nodeVal);
        visited[nodeVal] = true;
        while (!queue.isEmpty()){
            int value = (Integer) queue.poll();
            System.out.print(value);
            for (Graph.Node node : graph.adjacencyList.get(value)) {
                if(node!=null && !visited[node.value]){
                    queue.offer(node.value);
                    visited[node.value] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [][] edges = {{1,2}, {1,3},{1,4},{2,5},{2,6},{5,9},{5,10},{4,7},{4,8},{7,11},{7,12}};

        List<Graph.Edge> edgeList = new ArrayList<Graph.Edge>();
        for (int i = 0; i < edges.length; i++) {
            Graph.Edge edge = new Graph.Edge(edges[i][0], edges[i][1], 0);
            edgeList.add(edge);
        }

        Graph graph = new Graph(edgeList);


        boolean visited[] = new boolean[edges.length+1];

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i])
                new BreadthFirstSearch().bfs(graph, i, visited);
        }

    }
}
