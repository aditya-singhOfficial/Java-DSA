public class KthAncestor {
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

    static int kthAnc(Node root, int n, int k){
        if(root == null) return -1;
        if(root.data == n) return 0;

        int lKth = kthAnc(root.left, n, k);
        int rKth = kthAnc(root.right, n, k);

        if(lKth==-1 && rKth==-1) return -1;

        int max = Math.max(lKth,rKth);
        if(max+1==k){
            System.out.println(root.data);
        }

        return max+1;
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = buildTree(nodes);
        kthAnc(root, 4, 1);
    }
}
