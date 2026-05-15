package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsBipartite {
    class Solution {
	public boolean isBipartite(int V, int[][] edges) {
		// Code here
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		
		int[] color = new int[V];
		Arrays.fill(color, -1);
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i<V; i++) {
			if (color[i] == -1) {
				q.add(i);
				color[i] = 0;
				while (!q.isEmpty()) {
					int curr = q.remove();
					for (int neighbour: adj.get(curr)) {
						if (color[neighbour] == -1) {
							int nextColor = color[curr] == 0?1:0;
							color[neighbour] = nextColor;
							q.add(neighbour);
						}else if(color[neighbour] == color[curr]) return false;
					}
				}
			}
		}
		return true;
	}
}

}
