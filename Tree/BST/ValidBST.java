package BST;

public class ValidBST {
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

    static boolean isValidBST(Node root, Node max, Node min) {
        if (root == null)
            return true;

        if (min != null && root.val <= min.val)
            return false;
        if (max != null && root.val >= max.val)
            return false;

        return isValidBST(root.left, root, min)
                && isValidBST(root.right, max, root);
    }

    public static void main(String[] args) {
        int[] nodes = { 25, 12, 85, 1, 3, -5 };
        Node root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = build(root, nodes[i]);
        }
        preOrderTraversal(root);
        System.out.println();
        if (isValidBST(root, null, null)) {
            System.out.println("Valid BST");
        } else {
            System.out.println("Not Valid");
        }
    }
}