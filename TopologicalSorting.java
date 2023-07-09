import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSorting {
    
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



graph[2].add(new Edge(2, 3));

graph[3].add(new Edge(3, 1));
graph[4].add(new Edge(4, 1));
graph[4].add(new Edge(4, 0));
graph[5].add(new Edge(5, 0));
graph[5].add(new Edge(5, 2));

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

    public static void topSort(ArrayList<Edge> graph[],boolean visited[],int curr,Stack<Integer>st){
        visited[curr]= true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if(!visited[curr]){
                topSort(graph,visited,e.dest,st);
            }
        }
        st.push(curr);
    }
    public static void main(String[] args) {
        int V=6 ;// serven vertices

     


        


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
        boolean visited[]= new boolean[V];
        Stack<Integer> st =new Stack<Integer>();

        // since graph is directed so all parts of graph cannot be reached by calling the function once
        for(int i=0;i<V;i++){
            if(!visited[i]){
 topSort(graph, visited, i,st);
            }
        }
       

           System.out.println();
              System.out.println("Toplogical Sorting on graph is ");
                 System.out.println();
                 while(st.size()>0){
                    int a = st.pop();
                       System.out.println(a);
                 }
}
}
