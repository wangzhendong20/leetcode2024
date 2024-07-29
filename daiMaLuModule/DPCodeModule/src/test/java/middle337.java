

public class middle337 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
        TreeNode() {

        }
    }

    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robTree(TreeNode root) {
        if (root == null) return new int[]{0,0};

        int[] left = robTree(root.left);
        int[] right = robTree(root.right);

        int val1 = root.val + left[0] + right[0];
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{val2, val1};
    }
}
