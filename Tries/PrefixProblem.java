public class PrefixProblem {
    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord = false;
        int freq = 1;
    }

    static Node root = new Node();

    static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    static String search(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            curr = curr.children[idx];
            if (curr.freq == 1) {
                return word.substring(0, level + 1);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String[] arr = { "zebra", "dog", "duck", "dove" };
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        String[] str = new String[arr.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = search(arr[i]);
        }

        for (String string : str) {
            System.out.print(string + " ");
        }
    }
}