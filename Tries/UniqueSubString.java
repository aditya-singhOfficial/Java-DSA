public class UniqueSubString {
    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord = false;
    }

    static Node root = new Node();
    static int size = 1;

    static void insert(String wrd) {
        Node curr = root;
        for (int level = 0; level < wrd.length(); level++) {
            int idx = wrd.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                size++;
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.endOfWord = true;
    }

    public static void main(String[] args) {
        String word = "apple";

        for (int i = 0; i < word.length(); i++) {
            insert(word.substring(i));
        }

        System.out.println(size);
    }
}
