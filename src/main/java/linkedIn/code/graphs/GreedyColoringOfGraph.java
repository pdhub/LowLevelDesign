package linkedIn.code.graphs;

import java.util.*;

/**
 * Created by PDeb on 12/16/2017.
 */
public class GreedyColoringOfGraph {

    /*Brookes theorem, min colors reqd = max degree of any vertex in the graph*/
    class Edge{
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    class Graph{
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        Graph(List<Edge> edges, int numVertices){
            for (int i = 0; i < numVertices; i++) {
                adjlist.add(new ArrayList<>());
            }
            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                int src = edge.src;
                int dest = edge.dest;

                adjlist.get(src).add(dest);
                adjlist.get(dest).add(src);
            }
        }
    }

    public String colors[] = {"", "BLUE", "GREEN","RED", "YELLOW", "ORANGE", "PINK",
    "BLACK", "BROWN", "WHITE", "PURPLE", "VOILET"};

    public void colorGraph(Graph graph){
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < graph.adjlist.size(); i++) {
            Set<Integer> assigned = new HashSet<>();

            //Run through all the vertices reachable from i
            for(Integer vertex : graph.adjlist.get(i)){
                //If color is assigned, add to the list of already assigned colors
                if(result.get(vertex)!= null)
                    assigned.add(result.get(vertex));
            }

            //Start from the first color from the list of colors
            int color = 1;
            for(Integer colors : assigned){
                //If non used color found
                if(colors != color)
                    break;
                color++;
            }


            //Assign that color to the vertex
            result.put(i, color);
        }

        for (int i = 0; i < graph.adjlist.size(); i++) {
            System.out.println(String.format("Color assigned to vertex %s is %s", i, colors[result.get(i)]));
        }
    }

    public void runGraphColoring(){
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0,1));
        edges.add(new Edge(0,4));
        edges.add(new Edge(0,5));
        edges.add(new Edge(4,5));
        edges.add(new Edge(1,4));
        edges.add(new Edge(1,3));
        edges.add(new Edge(2,3));
        edges.add(new Edge(2,4));

        int numVertices = 6;

        Graph graph = new Graph(edges, numVertices);
        colorGraph(graph);
    }

    public static void main(String[] args) {
        new GreedyColoringOfGraph().runGraphColoring();
    }
}
