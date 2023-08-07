import java.util.ArrayList;

public class UndirectedCycleDetect {
    static class Edge{
        int src,dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    static void create(ArrayList<Edge>[] graph,int v){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));
    }
    static boolean CycleDetection(ArrayList<Edge> []graph,int curr,boolean vis[],int parent){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
                    Edge edge=graph[curr].get(i);
                    if(edge.dest!=parent && vis[edge.dest]==true){
                        return true;
                    }
                   else if(vis[edge.dest]==false){
                    if(CycleDetection(graph,edge.dest,vis,curr)){
                        return true;
                    }
                   }
                }
                return false;
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph=new ArrayList[7];
        create(graph,7);
        boolean[] vis=new boolean[7];
        boolean ans=false;
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
             ans=CycleDetection(graph, i, vis, i);
            }
        }
        if(ans){
            System.out.println("Cycle Found");
        }else{
            System.out.println("Cycle Not Found");
        }
    }
}
