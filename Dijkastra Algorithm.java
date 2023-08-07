import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkastra {
    static class Edge{
        int src,dest;
        int weight;
        public Edge(int src,int dest,int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }
    static void insert(ArrayList<Edge> graph[],int v){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0, 2, 4));
        // graph[1].add(new Edge(1,2,1));
      graph[1].add(new Edge(1,3,7));
      graph[2].add(new Edge(2,4,3));
      graph[3].add(new Edge(3,5,1));
      graph[4].add(new Edge(4,3,2));
      graph[4].add(new Edge(4,5,5));
    }
    static class Pair implements Comparable<Pair>{
        int node,dist;
        public Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
        @Override
        public int compareTo(Pair o) {
            return this.dist-o.dist;//Ascending order
        }
    }
    static void dijkastra(ArrayList<Edge> graph[],int v,int src) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int[] dist=new int[v];
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(i!=src){
               dist[i]=Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
        Pair curr=pq.remove();
        if(!vis[curr.node]){
          vis[curr.node]=true;
          for (int i = 0; i < graph[curr.node].size(); i++) {
           Edge e=graph[curr.node].get(i);
           int sr=e.src;
           int ds=e.dest;
           if(dist[sr]+e.weight<dist[ds]){
            dist[ds]=dist[sr]+e.weight;
                 pq.add(new Pair(ds,dist[ds]));
           }
          }
    }
}
for (int i = 0; i < v; i++) {
    System.out.print(dist[i]+" ");
}
System.out.println();
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        insert(graph,v);
        dijkastra(graph,v,0);
    }
}
