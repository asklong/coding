package DFS;

import java.util.Iterator;
import java.util.LinkedList;

public class AllConnectedGraph {
	//depth first search for graph
	//we search the node first, then search it's adjacent node
	//then adjacent of the adjacent, like this.
	//if we meet some node don't have adjacent nodes or all nodes visited,
	//go to previous step, search other node
	private int V;
	private LinkedList<Integer>[] adj;
	public AllConnectedGraph(int v) {
		// TODO Auto-generated constructor stub
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	//add a edge to the graph, edge is from v to w
	void addEdge(int v,int w){
		adj[v].add(w);
	}
	//a function will used by depth first search
	void DFSUtil(int v, boolean[] visited){
		//visit v, set the node to visited 
		visited[v] = true;
		System.out.println(v);
		//visit all the adjacent vertices of v node
		Iterator<Integer> iterator = adj[v].listIterator();
		while(iterator.hasNext()){
			int n = iterator.next();
			if(!visited[n]){
				DFSUtil(n, visited);
			}
		}
	}
	void DFS(int v){
		//boolean array is set default false in java
		//there are number V nodes, so array length is V
		boolean[]visited = new boolean[V];
		DFSUtil(v, visited);
	}
	public static void main(String[] args) {
		AllConnectedGraph graph = new AllConnectedGraph(4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.DFS(2);
	}
}
