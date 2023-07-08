import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src= src;
            this.dest= dest;
        }
    }

      public static void  createGraph(ArrayList<Edge>graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i]= new ArrayList<>();
        }
graph[0].add(new Edge(0, 1));
graph[0].add(new Edge(0, 2));
graph[1].add(new Edge(1, 3));
graph[2].add(new Edge(2, 0));
graph[2].add(new Edge(2,4));
graph[3].add(new Edge(3, 1));
graph[3].add(new Edge(3, 5));
graph[4].add(new Edge(4, 2));
graph[4].add(new Edge(4, 5));
graph[5].add(new Edge(5, 3));
graph[5].add(new Edge(5, 4));
graph[5].add(new Edge(5, 6));
graph[6].add(new Edge(6, 5));
    }

    public static void bfs(ArrayList<Edge> graph []){
        Queue<Integer> q = new LinkedList<>();
        boolean visited []= new boolean[graph.length];
        q.add(graph[0].get(0).src);
        while(!q.isEmpty()){
int curr = q.remove();
if(!visited[curr]){
    visited[curr]=true;
    System.out.print(curr+" ");
for (int i = 0; i < graph[curr].size(); i++) {
    Edge e = graph[curr].get(i);
    q.add(e.dest);
}
}

        }

    }
    public static void main(String[] args) {
        int V=7 ;// serven vertices
/*
 
          1----3
        /      | \
      0        |  5---6
        \      | /
          2----4
 
 */
     


        


        ArrayList<Edge> graph [] = new ArrayList[V];
        createGraph(graph);


        System.out.println("Original Graph");
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print(graph[i].get(j).dest+" ");
            }
            System.out.println();
        }

        System.out.println("Graph with BFS");

        bfs(graph);
    }
}
