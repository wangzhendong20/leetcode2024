public class hard968 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int res = 0;
    public int minCameraCover(TreeNode root) {
        if (traverse(root) == 0) res++;
        return res;
    }

    private int traverse(TreeNode root) {

        if (root == null) return 2;

        int left = traverse(root.left);
        int right = traverse(root.right);

        if (left == 2 && right == 2) {
            return 0;
        }
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        if (left == 1 || right == 1) return 2;

        return -1;
    }
}
