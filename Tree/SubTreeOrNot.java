public class SubTreeOrNot {
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

    static boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null)
            return true;

        else if (root == null || subRoot == null || root.data != subRoot.data)
            return false;

        if (!isIdentical(root.left, subRoot.left))
            return false;

        if (!isIdentical(root.right, subRoot.right))
            return false;

        return true;
    }

    static boolean isSubTree(Node root, Node subRoot) {
        if (root == null)
            return false;
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot))
                return true;
        }

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = buildTree(nodes);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubTree(root, subRoot));
    }
}
