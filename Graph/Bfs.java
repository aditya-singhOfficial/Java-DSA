package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    class Solution {
        public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
            // code here
            ArrayList<Integer> result = new ArrayList<>();
            boolean[] visited = new boolean[adj.size()];
            Queue<Integer> q = new LinkedList<>();
            q.add(0);

            while (!q.isEmpty()) {
                int curr = q.remove();

                if (!visited[curr]) {
                    result.add(curr);
                    visited[curr] = true;
                    for (int i = 0; i < adj.get(curr).size(); i++) {
                        q.add(adj.get(curr).get(i));
                    }
                }
            }
            return result;
        }
    }
}
