public class StartWithProblem {
    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord = false;
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

    static boolean isStartWith(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] != null) {
                curr = curr.children[idx];
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = { "apple", "mango", "app", "man", "woman" };
        for (String word : words) {
            insert(word);
        }

        System.out.println(isStartWith("apu"));
    }
}
