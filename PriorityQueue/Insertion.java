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

        void printHeap() {
            System.out.println(list);
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
    }
}
