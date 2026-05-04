import java.util.*;

public class SumOfNode {
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

    static int sum(Node root) {
        if (root == null)
            return 0;
        int sum = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curNode = q.remove();
            sum += curNode.data;
            if (curNode.left != null)
                q.add(curNode.left);
            if (curNode.right != null)
                q.add(curNode.right);
        }

        return sum;
    }

    static int sum2(Node root) {
        if (root == null)
            return 0;
        int leftSum = sum2(root.left);
        int rightSum = sum2(root.right);
        return leftSum + rightSum + root.data;
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = buildTree(nodes);
        System.out.println(sum2(root));
    }
}
