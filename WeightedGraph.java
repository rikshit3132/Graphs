import java.util.ArrayList;

public class WeightedGraph {
    static class Edge{
        int src,dest;
        int weight;
        public Edge(int src,int dest,int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }
    static void createWeightedEdge(ArrayList<Edge> graph[],int v){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2, 2));
        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1,3,0));
        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2,3,-1));
        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createWeightedEdge(graph,v);
        int j=0;
        while(j<graph.length){
        for (int i = 0; i < graph[j].size(); i++) {
            Edge edge = graph[j].get(i);
            System.out.println(edge.src+" "+edge.dest+" "+edge.weight);
        }
        j++;
    }
    }
}
