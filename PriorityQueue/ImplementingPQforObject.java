package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ImplementingPQforObject {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("Aryan\t", 5));
        pq.add(new Student("Raj\t", 2));
        pq.add(new Student("Raju\t", 6));
        pq.add(new Student("Rahul\t", 4));
        pq.add(new Student("Ramu\t", 3));
        pq.add(new Student("Aditya\t", 1));

        while (!pq.isEmpty()) {
            Student s = pq.poll();
            System.out.print("Name: " + s.name + "Rank: " + s.rank);
            System.out.println();
        }
    }
}
