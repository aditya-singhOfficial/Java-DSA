package Tries;

import java.util.Arrays;

public class CreatingTries {
    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord = false;

        Node() {
            Arrays.fill(children, null);
        }

    }

    static Node root = new Node();

    public static void main(String[] args) {

    }
}
