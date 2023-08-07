import java.util.ArrayList;
import java.util.Stack;

public class Practice {
    static class Edge{
        int src,dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    static void create(ArrayList<Edge>[]graph,int v){
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,3));
        graph[2].add(new Edge(2,3));
        
    }
    static void topSort(ArrayList<Edge>[] graph,int curr,Stack<Integer> stack,boolean vis[]) {
     vis[curr]=true;
     for (int i = 0; i < graph[curr].size(); i++) {
        Edge e=graph[curr].get(i);
        if(vis[e.dest]==false){
            topSort(graph,e.dest,stack,vis);
        }
     }
   stack.push(curr);
    }
    static void run(ArrayList<Edge> graph[],int v){
        boolean vis[]=new boolean[v];
        Stack<Integer> s=new Stack<>();
        for (int i = 0; i <v; i++) {
            if(vis[i]==false){
            topSort(graph, i, s, vis);
        }
    }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge>[]graph=new ArrayList[v];
        create(graph,v);
        run(graph,v);
    }
}
