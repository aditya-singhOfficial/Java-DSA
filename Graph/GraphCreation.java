package Graph;

import java.util.ArrayList;

public class GraphCreation {
    static class Edge {
        int src;
        int dst;
        int wt;

        Edge(int src, int dst, int wt) {
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {

        /*
                (5)
          0 -------- 1
                   / \
               (1)/   \(3)
                 /     \
                2 ----- 3
                   (1)
                |
            (2) |
                |
                4
        */
        ArrayList<Edge>[] graph = new ArrayList[5];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        //0-edge
        graph[0].add(new Edge(0, 1, 5));

        //1-edge
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        //2-edge
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        //3-edge
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        //4-edge
        graph[4].add(new Edge(4, 2, 2));
    }
}
