import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirectedGraph {
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
graph[0].add(new Edge(0, 2));

graph[1].add(new Edge(1, 0));
graph[2].add(new Edge(2, 3));

graph[3].add(new Edge(3, 0));

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

    public static boolean isCycleDirected(ArrayList<Edge> graph[],boolean visited[],int curr,boolean rec[]){
        visited[curr]=true;
         rec[curr]=true;

         for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(rec[e.dest]){
                return true;
            }
            else if(!visited[e.dest]){
                if(isCycleDirected(graph, visited,e.dest,rec)){
                    return true;
                }
                
            }
         }
         rec[curr]=false;
         return false;
    }
    public static void dfs (ArrayList<Edge> graph[],boolean visited[],int curr){
        if(visited[curr]==false){
        System.out.print(curr+" ");
               visited[curr]=true;
      
            for(int i=0;i<graph[curr].size();i++){
                
         
                Edge e = graph[curr].get(i);

                dfs(graph, visited, e.dest);

            
        }
    }
    }
    public static void main(String[] args) {
        int V=4 ;// serven vertices
/*
 

        1-->0<--3
           |  /
           |/
          \/
           2
       
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

        boolean visited[]= new boolean[V];
        System.out.println();
          System.out.println("Graph with DFS");
        dfs(graph, visited, graph[0].get(0).src);
 boolean vis[]= new boolean[V];
  boolean rec[]= new boolean[V];
  System.out.println();
        System.out.println("Is graph Cyclic :-"+isCycleDirected(graph, vis, 0, rec));
    }
}
