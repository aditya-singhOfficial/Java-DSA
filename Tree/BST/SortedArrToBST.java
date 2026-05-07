package BST;

import java.util.*;

public class SortedArrToBST {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static Node buildBST(int[] nodes, int start, int end) {
        if (start > end)
            return null;

        int mid = start + (end - start) / 2;

        Node root = new Node(nodes[mid]);
        root.left = buildBST(nodes, start, mid - 1);
        root.right = buildBST(nodes, mid + 1, end);

        return root;
    }

    static void preOrderTraversal(Node root) {
        if (root == null)
            return;
        preOrderTraversal(root.left);
        System.out.print(root.val + " ");
        preOrderTraversal(root.right);
    }

    static void levelOrderTraversal(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty())
                    break;
                else
                    q.add(null);
            } else {
                System.out.print(currNode.val + " ");
                if (currNode.left != null)
                    q.add(currNode.left);
                if (currNode.right != null)
                    q.add(currNode.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 3, 5, 6, 8, 10, 11, 12 };
        Node root = null;
        root = buildBST(nodes, 0, nodes.length - 1);
        preOrderTraversal(root);
        System.out.println();
        levelOrderTraversal(root);
        System.out.println();
    }
}
