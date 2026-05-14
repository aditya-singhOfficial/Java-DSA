import java.util.*;

public class Solution {
    public static int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0)
                map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    int freq = map.get(a) - map.get(b);
                    if (freq == 0) {
                        return b.compareTo(a);
                    }
                    return freq;
                });

        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > 1)
                pq.poll();
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
        return -1;
        // return pq.peek() == null ? -1 : pq.peek();
    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 2, 2, 4, 4, 1 };
        System.out.println(mostFrequentEven(nums));
    }
}