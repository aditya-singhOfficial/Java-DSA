package PriorityQueue;

import java.util.ArrayList;
import java.util.Scanner;

public class Insertion {
    static class Heap {
        ArrayList<Integer> list = new ArrayList<>();

        void add(int data) {
            list.add(data);

            int child = list.size() - 1;
            int parent = (child - 1) / 2;

            while (list.get(child) < list.get(parent)) {
                int temp = list.get(child);
                list.set(child, list.get(parent));
                list.set(parent, temp);

                child = parent;
                parent = (child - 1) / 2;
            }
        }

        private void heapify(int i) {
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;
            int minIdx = i;

            if (left < list.size() && list.get(minIdx) > list.get(left)) {
                minIdx = left;
            }

            if (right < list.size() && list.get(minIdx) > list.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                int temp = list.get(minIdx);
                list.set(minIdx, list.get(i));
                list.set(i, temp);

                heapify(minIdx);
            }
        }

        int remove() {
            int removed = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            heapify(0);

            return removed;
        }

        void printHeap() {
            System.out.println(list);
        }

        int peek() {
            return list.get(0);
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(5);
        h.add(3);
        h.add(1);
        h.add(4);
        h.add(7);
        h.add(6);
        h.printHeap();
        System.out.println(h.remove());
        h.printHeap();

    }
}
