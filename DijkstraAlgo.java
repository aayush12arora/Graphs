import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgo {
  
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

graph[1].add(new Edge(1, 3,7));
graph[1].add(new Edge(1, 2,1));
graph[2].add(new Edge(2, 4,3));

graph[3].add(new Edge(3, 5,1));
graph[4].add(new Edge(4, 3,2));
graph[4].add(new Edge(4, 5,5));

    }


    public static class Pair implements Comparable<Pair>{
int node;
int wt;
public Pair(int node,int wt){
    this.node = node;
    this.wt=wt;
}
@Override
public int compareTo(Pair o) {
    // TODO Auto-generated method stub
   return this.wt-o.wt;// for increasing order
}
    }
public static void dijkstra(ArrayList<Edge>graph[],int src){
PriorityQueue<Pair> pq = new PriorityQueue<>();
int [] dis = new int[graph.length];
boolean [] vis = new boolean[graph.length];
for (int i = 0; i < dis.length; i++) {
    if(i!=src){
        dis[i]= Integer.MAX_VALUE; 

    }
}
pq.add(new Pair(0, 0));

//bfs

while(!pq.isEmpty()){
    Pair curr = pq.remove();
    if(!vis[curr.node]){
        vis[curr.node]=true;
        // loop for neighbours

        for (int i = 0; i < graph[curr.node].size(); i++) {
            Edge e =  graph[curr.node].get(i);
            // apply relaxation

            int u = e.src;
            int v = e.dest;
            if(dis[u]+e.weight<dis[v]){
                dis[v]= dis[u]+e.weight;
                pq.add(new Pair(v,dis[v]));
            }
        }
        
    }
}

 System.out.println();
for (int i = 0; i < dis.length; i++) {
   
    System.out.print(dis[i]+"  ");
}

}
    public static void main(String[] args) {
        int V=6 ;
        ArrayList<Edge> graph [] = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph,0);
    }
}
