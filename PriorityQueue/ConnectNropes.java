package PriorityQueue;

import java.util.PriorityQueue;

public class ConnectNropes {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ropes = { 2, 3, 3, 4, 6 };
        for (int n : ropes) {
            pq.add(n);
        }
        int totalCost = 0;
        while (pq.size() > 1) {
            int curr = pq.poll();
            if (!pq.isEmpty())
                curr += pq.poll();
            totalCost += curr;
            pq.add(curr);
        }

        System.out.println(totalCost);
    }

}
