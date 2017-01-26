package DFS;

import java.util.Iterator;
import java.util.LinkedList;

public class DisConnectedGraph {
	//some parts of this graph are disconnected
	private int V;// Vertexes numbers
	private LinkedList<Integer>[] adj;
	//add an edge to the graph
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
	public DisConnectedGraph(int v) {
		// TODO Auto-generated constructor stub
		V = v;
		adj = new LinkedList[v];//adj is a linked list array
		for(int i=0; i<v; ++i){
			adj[i] = new LinkedList<Integer>();
		}
	}
	// A function used by DFS
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");
 
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n,visited);
        }
    }
    //because some node is disconnected, so we travel each node
    void DFS(){
    	boolean[] visited = new boolean[V];
    	for(int i=0; i<V; ++i){
    		if(!visited[i]){
    			DFSUtil(i, visited);
    		}
    	}
    }
    public static void main(String args[])
    {
        DisConnectedGraph g = new DisConnectedGraph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal");
 
        g.DFS();
    }
	
	
}
