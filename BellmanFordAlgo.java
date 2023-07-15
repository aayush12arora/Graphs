import java.util.ArrayList;

public class BellmanFordAlgo {
            static class Edge{
        int src;
        int dest;
int weight;
        public Edge(int src, int dest,int weight){
            this.src= src;
            this.dest= dest;
            this.weight = weight;
        }
    }
 

      public static void  createGraph(ArrayList<Edge>graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i]= new ArrayList<>();
        }
graph[0].add(new Edge(0, 1,2));
graph[0].add(new Edge(0, 2,4));


graph[1].add(new Edge(1, 2,-4));
graph[2].add(new Edge(2, 3,2));

graph[3].add(new Edge(3, 4,4));
graph[4].add(new Edge(4, 1,-1));


    }

public static void bellmanFord(ArrayList<Edge> graph [], int src){
int [] dis = new int[graph.length-1];
int V= graph.length;
for (int i = 0; i < dis.length; i++) {
    if(i!=src){
        dis[i]= Integer.MAX_VALUE;
    }
}


for (int k = 0; k <V-1 ; k++) {
    
    for (int i = 0; i < V; i++) {

        for (int j = 0; j < graph[i].size(); j++) {
            Edge e = graph[i].get(j);

            int u = e.src;
            int v = e.dest;
            // perform relaxation

            if(dis[u]!=Integer.MAX_VALUE&& dis[u]+e.weight<dis[v]){
                dis[v]=dis[u]+e.weight;
            }
        }
        
    }
}
System.out.println();
for (int i = 0; i < dis.length; i++) {
   System.out.print(dis[i]+" "); 
}

}
    public static void main(String[] args) {
        int V=6 ;
        ArrayList<Edge> graph [] = new ArrayList[V];
        createGraph(graph);
        bellmanFord(graph, 0);
        
    }

}
