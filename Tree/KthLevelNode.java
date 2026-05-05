import java.util.LinkedList;
import java.util.Queue;

public class KthLevelNode {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static int idx = -1;

    static Node buildTree(int[] nodes) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    static int index = 0;

    static void printKthLevel(Node root, int k) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                index++;
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (k == index)
                    System.out.print(currNode.data + " ");

                if (currNode.left != null)
                    q.add(currNode.left);

                if (currNode.right != null)
                    q.add(currNode.right);
            }

        }
    }

    static void printKthLevel2(Node root, int level, int k) {
        if (root == null)
            return;
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        printKthLevel2(root.left, level + 1, k);
        printKthLevel2(root.right, level + 1, k);
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        Node root = buildTree(nodes);
        printKthLevel(root, 2);
        System.out.println();
        printKthLevel2(root, 1, 3);
    }
}
