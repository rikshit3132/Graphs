import java.util.ArrayList;

public class Basics2 {
    static class Edge{
        int src,dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    static void create(ArrayList<Edge>[] graph,int v){
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();//add empty LinkedList into  each index of the array
        }
        graph[1].add(new Edge(1, 0));//add  all edges   from index 0 to index v-1
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
        graph[4].add(new Edge(4,3));
    }
    public static void main(String[] args) {
        int v =5;

        ArrayList<Edge>[] graph=new ArrayList[v];
        create(graph,v);
        int n=graph.length;
        int j=0;
        while(j<n) {
        for (int i = 0; i < graph[j].size() ;  i++) {
            Edge edge = graph[j].get(i);//find the edge at every index of  LinkedList stored in an array
            System.out.println(edge.src+" "+edge.dest);//print source and destination edges
        }
        j++;
    }
    }
}
