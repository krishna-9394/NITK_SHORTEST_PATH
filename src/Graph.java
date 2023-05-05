import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Graph {
    private static ArrayList<Edges>[] graph;
    public void Graph(int n){
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Edges>();
        }
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        Pair(int node,int dist){
            this.dist = dist;
            this.node = node;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist-p2.dist;
        }
    }

    public void insertingEdges(int source, int destination,int distance){
        Node src = new Node(source);
        Node dest = new Node(destination);
        graph[src.id].add(new Edges(distance,src,dest));
    }
    public static void shortest_path(String curr, String dest){
        System.out.println(curr+" "+dest);
    }

    public static void dikstrasAlgo(int src,int V) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        priorityQueue.add(new Pair(src,0));
        while (!priorityQueue.isEmpty()){
            Pair curr = priorityQueue.remove();
            if (!visited[curr.node]){
                visited[curr.node] = true;
                for (int i = 0; i <graph[curr.node].size() ; i++) {
                    Edges e = graph[curr.node].get(i);
                    Node u = e.source;
                    Node v = e.destination;
                    if (dist[u.id]+e.distance<dist[v.id]){
                        dist[v.id] = dist[u.id]+e.distance;
                        priorityQueue.add(new Pair(v.id,dist[v.id]));
                    }
                }
            }
        }
        for(int ele:dist){
            System.out.print(dist+" ");
        }
    }
}


