package BST;

public class DeleteNodeInBST {
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

    public static Node inOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static Node deleteNode(Node root, int val) {
        if (root == null)
            return null;
        if (root.val < val) {
            root.right = deleteNode(root.right, val);
        } else if (root.val > val) {
            root.left = deleteNode(root.left, val);
        } else {
            // Only a single element with no child- leaf node
            if (root.left == null && root.right == null)
                return null;

            // Having One child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Having both children
            Node IS = inOrderSuccessor(root.right);
            root.val = IS.val;
            root.right = deleteNode(root.right, IS.val);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] nodes = { 25, 12, 85, 1, 3, -5 };
        Node root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = build(root, nodes[i]);
        }
        preOrderTraversal(root);
        root = deleteNode(root, 102);
        System.out.println();
        preOrderTraversal(root);
    }
}
