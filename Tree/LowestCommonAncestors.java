import java.util.ArrayList;

public class LowestCommonAncestors {
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

    static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null)
            return false;
        path.add(root);

        if (root.data == n)
            return true;

        boolean foundInLeft = getPath(root.left, n, path);
        boolean foundInRight = getPath(root.right, n, path);

        if (foundInLeft || foundInRight)
            return true;

        path.remove(path.size() - 1);
        return false;
    }

    static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i).data != path2.get(i).data)
                break;
        }

        Node lCB = path1.get(i - 1);
        return lCB;
    }

    static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2)
            return root;

        Node lLCA = lca2(root.left, n1, n2);
        Node rLCA = lca2(root.right, n1, n2);

        if (lLCA == null)
            return rLCA;
        if (rLCA == null)
            return lLCA;

        return root;
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        Node root = buildTree(nodes);
        Node node = lca(root, 4, 7);
        System.out.println("LCA of 4 & 7: " + node.data);
        Node node1 = lca2(root, 4, 5);
        System.out.println("LCA of 4 & 5: " + node1.data);
    }
}
