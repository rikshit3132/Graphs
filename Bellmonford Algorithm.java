import java.util.ArrayList;

public class Bellmonford {
    static class Edge{
        int src,dest,wt;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    static void createGraph(ArrayList<Edge> graph[],int v){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1,-1));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, 3));
        graph[1].add(new Edge(1, 3, 2));
        graph[1].add(new Edge(1, 4, 2));
        graph[3].add(new Edge(3, 2, 5));
        graph[3].add(new Edge(3, 1, 1));
        graph[4].add(new Edge(4, 3, -3));
    }
    static void bellmonFord(ArrayList<Edge> graph[],int v,int src){
         int[] dist=new int[v];
        for (int i = 0; i < graph.length; i++) {
           if (i!=src) {
            dist[i]=Integer.MAX_VALUE;
           }
        }
       
       for (int k = 0; k < v-1; k++) {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e=graph[i].get(j);
                int start=e.src;
                int end=e.dest;

                if(dist[start]+e.wt<dist[end]){
                    dist[end]=dist[start]+e.wt;          
                    // Relaxation performed
                }
            }
        }
       }
       for (int i = 0; i < dist.length; i++) {
        System.out.print(dist[i]+" ");
       }
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph, v);
        bellmonFord(graph, v,0);
    }
}
