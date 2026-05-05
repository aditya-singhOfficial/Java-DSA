import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfTree {
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

    static class Info {
        Node node;
        int hDistance;

        Info(Node node, int hDistance) {
            this.node = node;
            this.hDistance = hDistance;
        }
    }

    static void topView(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;
        q.add(new Info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hDistance)) {
                    map.put(curr.hDistance, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hDistance - 1));
                    min = Math.min(min, curr.hDistance - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hDistance + 1));
                    max = Math.max(max, curr.hDistance + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        Node root = buildTree(nodes);
        topView(root);
    }
}
