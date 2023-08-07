import java.util.ArrayList;

public class cycleDetectDirected {
    static class Edge{
        int src,des;
        Edge(int src,int des){
            this.src=src;
            this.des=des;
        }
    }
    static void createGraph(ArrayList<Edge> [] graph,int v){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        // graph[3].add(new Edge(3, 0));
    }
    static boolean cycleDetetct(ArrayList<Edge> [] graph,int curr,boolean vis[],boolean rec[]){
        vis[curr] = true;
        rec[curr]=true;
           for (int i = 0; i < graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            if(rec[e.des]==true){
                return true;
            }
            else if(!vis[e.des]){
                if(cycleDetetct(graph,e.des,vis,rec)){
                                    return true;
                }
            }
    
           }
           rec[curr]=false;
           return false;
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> [] graph=new ArrayList[v];
        createGraph(graph, v);
        boolean vis[]=new boolean[v];
        boolean rec[]=new boolean[v];
        for (int i = 0; i < v; i++) {
            if(vis[i]==false){
                boolean ans= cycleDetetct(graph,i,vis,rec);
                if(ans){
                    System.out.println(ans);
                    break;
                }else{
                    System.out.println(ans);
                    break;
                }
            }
        }
    }
}
