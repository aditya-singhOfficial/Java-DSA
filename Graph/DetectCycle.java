package Graph;

import java.util.ArrayList;

public class DetectCycle {
    class Solution {
	public boolean isCycle(int V, int[][] edges) {
		// Code here
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i<V; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int[] edge: edges) {
			int u = edge[0];
			int v = edge[1];
			
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		
		boolean[] visited = new boolean[V];
		
		for (int i = 0; i<V; i++) {
			if (!visited[i])
				if (detectCycle(adj, visited, i, -1))
				return true;
		}
		
		return false;
	}
	
	static boolean detectCycle(ArrayList<ArrayList<Integer>> adj,
	boolean[] visited,
	int curr, int parent) {
		
		visited[curr] = true;
		for (int neighbour: adj.get(curr)) {
			if (!visited[neighbour]) {
				if (detectCycle(adj, visited, neighbour, curr))
					return true;
			}
			else if (neighbour != parent)
				return true;
		}
		return false;
	}
}

}
