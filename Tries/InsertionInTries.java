package Tries;

import java.util.Arrays;

public class InsertionInTries {
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

    public static void main(String[] args) {
        String[] words = {"the","a","there","their","any","thee"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
    }
}
