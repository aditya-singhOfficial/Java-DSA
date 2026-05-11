import java.util.PriorityQueue;

public class Solution {
    static class Info implements Comparable<Info> {
        int val;
        int idx;

        Info(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Info i2) {
            return i2.val - this.val;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,0, 10, 20, 11, 70, 50, 40, 100, 5 };
        int k = 3;
        int[] maxArr = new int[arr.length - k + 1];
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(new Info(arr[i], i));
        }
        maxArr[0] = pq.peek().val;
        for (int i = k; i < arr.length; i++) {
            while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                pq.poll();
            }
            pq.add(new Info(arr[i], i));
            maxArr[i - k + 1] = pq.peek().val;
        }

        for (int n : maxArr) {
            System.out.print(n + " ");
        }
    }
}