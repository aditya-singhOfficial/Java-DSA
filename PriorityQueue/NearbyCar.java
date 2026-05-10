package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NearbyCar {
    static class Info implements Comparable<Info> {
        int x;
        int y;
        int distance;

        public Info(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Info i2) {
            return this.distance - i2.distance;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int[][] arr = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        for (int[] n : arr) {
            if (pq.size() >= 2)
                pq.poll();
            pq.add(new Info(n[0], n[1], ((n[0] * n[0]) + (n[1] * n[1]))));
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.peek().x + ", " + pq.peek().y);
            pq.poll();
        }
    }
}
