package linkedIn.code.graphs;

import java.util.Arrays;

/**
 * Created by PDeb on 12/14/2017.
 */
public class KruskalMST {

    class Graph{
        class Edge implements Comparable<Edge>{
            int src, dest, weight;

            public int compareTo(Edge edge) {
                return Integer.compare(this.weight, edge.weight);
            }
        }

        class Subset{
            int parent, rank;
        }

        int V, E;
        Edge edge[];

        Graph(int v, int e){
            this.V = v;
            E = e;
            edge = new Edge[E];
        }

        //utility to find parent set of an element i (using path compression)
        int find(Subset subset[], int i){
            if(subset[i].parent !=i)
                subset[i].parent = find(subset, subset[i].parent);
            return subset[i].parent;
        }

        //union of two sets, union by rank
        void union(int x, int y, Subset subset[]){
            int xroot = find(subset, x);
            int yroot = find(subset, y);

            if(subset[xroot].rank < subset[yroot].rank)
                subset[xroot].parent = yroot; //The higher rank always gets to be the parent
            else if(subset[xroot].rank > subset[yroot].rank)
                subset[yroot].parent = xroot;
            else
            {
                subset[yroot].parent = xroot;
                subset[xroot].rank++;//who remains the parent his rank increases
            }
        }

       void kruskalMST(){
           Edge result[] = new Edge[V];

           /*for (int i = 0; i < V ; i++) {
               result[i] = new Edge();
           }*/

           Arrays.sort(edge);
           Subset subset[] = new Subset[V];
           for (int i = 0; i < V; ++i) {
               subset[i] = new Subset();
               subset[i].parent = i;
               subset[i].rank = 0;
           }

           int i = 0;
           int e = 0;
           while(e < V-1){
               Edge nextEdge = edge[i++];
               int x = find(subset, nextEdge.src);
               int y = find(subset, nextEdge.dest);
               if(x!=y){
                   result[e++] = nextEdge;
                   union(x, y, subset);
               }
           }
       }
    }
}
