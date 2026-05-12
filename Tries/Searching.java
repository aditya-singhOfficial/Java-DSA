package Tries;

import java.util.Arrays;

public class Searching {
    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord = false;

        Node() {
            Arrays.fill(children, null);
        }
    }

    static Node root = new Node();

    static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    static boolean isFound(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null)
                return false;
            else
                curr = curr.children[idx];
        }
        return curr.endOfWord;
    }

    public static void main(String[] args) {
        String[] words = { "the", "a", "there", "their", "any", "thee" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(isFound("ther"));
    }
}
