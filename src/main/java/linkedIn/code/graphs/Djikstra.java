package linkedIn.code.graphs;

import java.util.*;

/**
 * Created by PDeb on 12/13/2017.
 */
public class Djikstra {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numNodes = sc.nextInt();
        int numEdges = sc.nextInt();
        ArrayList<ArrayList<Node>> adjList = new ArrayList<ArrayList<Node>>(numNodes+1);

        for (int i = 0; i < numNodes; i++) {
            adjList.add(new ArrayList<>(numNodes+1));
        }

        for (int i = 0; i < numEdges; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int cost = sc.nextInt();
            adjList.get(x).add(new Node(y, cost));
            adjList.get(y).add(new Node(x, cost));
        }
        int source = sc.nextInt();
        djikstra(source, adjList, numNodes);
    }

    private static void djikstra(int source, ArrayList<ArrayList<Node>> adjList, int numNodes) {
        int distance[] = new int[numNodes+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));
        while(!pq.isEmpty()){
            Node visitingNode = pq.poll();
            Iterator<Node> itr = adjList.get(visitingNode.val).iterator();
            while (itr.hasNext()){
                Node adjNode = itr.next();
                if(distance[adjNode.val] > distance[visitingNode.val] + adjNode.dist){
                    distance[adjNode.val] = distance[visitingNode.val] + adjNode.dist;
                    pq.add(new Node(adjNode.val, distance[adjNode.val]));
                }
            }
        }
    }
}
class Node implements Comparable<Node>{
    int val;
    int dist;

    public Node(int val, int dist) {
        this.val = val;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.dist, node.dist);
    }
}