package PriorityQueue;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Implementation {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(5);
        pq.add(4);
        pq.add(2);
        pq.add(1);
        pq.add(7);
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
            // pq.poll();
            // pq.remove();
        }
    }
}
