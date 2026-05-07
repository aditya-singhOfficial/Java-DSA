package BST;

import java.util.ArrayList;

public class PrintRootToLeaf {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static void preOrderTraversal(Node root) {
        if (root == null)
            return;
        preOrderTraversal(root.left);
        System.out.print(root.val + " ");
        preOrderTraversal(root.right);
    }

    public static Node build(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.val > val) {
            root.left = build(root.left, val);
        } else {
            root.right = build(root.right, val);
        }
        return root;
    }

    static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("null");
    }

    static void printToLeaf(Node root, ArrayList<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            printPath(path);
        }
        printToLeaf(root.left, path);
        printToLeaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[] nodes = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = build(root, nodes[i]);
        }
        preOrderTraversal(root);
        System.out.println();

        printToLeaf(root, new ArrayList<>());
    }
}