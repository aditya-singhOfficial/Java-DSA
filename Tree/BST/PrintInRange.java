package BST;

public class PrintInRange {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null)
            return;
        if (root.val >= k1 && root.val <= k2) {
            printInRange(root.left, k1, k2);
            System.out.println(root.val);
            printInRange(root.right, k1, k2);
        } else if (root.val < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }
}
