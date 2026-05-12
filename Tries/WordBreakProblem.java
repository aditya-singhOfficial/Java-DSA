package Tries;

import java.util.Arrays;

public class WordBreakProblem {
    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord = false;
    }

    static Node root = new Node();

    static void createTries(String word) {
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
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null)
                return false;
            else
                curr = curr.children[idx];
        }
        return curr.endOfWord;
    }

    static boolean wordBreak(String key) {
        if (key.length() == 0)
            return true;
        for (int i = 1; i <= key.length(); i++) {
            if (isFound(key.substring(0, i))
                    && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = { "i", "like", "sam", "samsung", "mobile", "ice" };
        String key = "ilikesamsung";
        for (int i = 0; i < words.length; i++) {
            createTries(words[i]);
        }
        System.out.println(wordBreak(key));
    }
}
