public class MinDisBtwNodes {
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

    static Node lca(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2)
            return root;

        Node lLCA = lca(root.left, n1, n2);
        Node rLCA = lca(root.right, n1, n2);

        if (lLCA == null)
            return rLCA;
        if (rLCA == null)
            return lLCA;

        return root;
    }

    static int getDistance(Node root, int n) {
        if (root == null)
            return -1;

        if (root.data == n)
            return 0;

        int lDist = getDistance(root.left, n);
        int rDist = getDistance(root.right, n);

        if (lDist == -1 && rDist == -1) {
            return -1;
        } else {
            if (lDist == -1)
                return rDist+1;
            else
                return lDist+1;
        }
    }

    static int minDistance(Node root, int n1, int n2) {
        Node lca = lca(root, n1, n2);
        int dist1 = getDistance(lca, n1);
        int dist2 = getDistance(lca, n2);

        return dist1 + dist2;
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        Node root = buildTree(nodes);
        System.out.println(minDistance(root, 4, 7));
    }
}
