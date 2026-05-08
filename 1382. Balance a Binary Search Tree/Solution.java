import java.util.*;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(root, arr);
        
        return buildTree(0, arr.size()-1, arr);
        return root;
    }

    static void inOrder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null)
            return;
        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
    }

    static TreeNode buildTree(int si, int ei, ArrayList<Integer> arr) {
        if (si > ei)
            return null;

        int mid = si + (ei - si) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = buildTree(si, mid - 1, arr);
        root.right = buildTree(mid + 1, ei, arr);

        return root;
    }

    public static void main(String[] args) {
        balanceBST(null)
    }
}