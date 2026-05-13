public class LongestWordWithAllPair {
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

    static String ans = "";

    static void longestWord(Node root, StringBuilder temp) {
        if (root == null)
            return;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].endOfWord == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = { "a", "banana", "ap", "app", "appl", "apply", "apple" };
        for (String word : words) {
            insert(word);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
