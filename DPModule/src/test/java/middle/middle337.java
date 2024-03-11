package middle;


import utils.TreeNode;

public class middle337 {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] tree = robTree(root);
        return Math.max(tree[0], tree[1]);
    }

    private int[] robTree(TreeNode root) {
        if (root == null) return new int[]{0,0};

        int[] left = robTree(root.left);
        int[] right = robTree(root.right);

        int val1 = root.val + left[0] + right[0];

        int val2 = Math.max(left[0],left[1]) + Math.max(right[0], right[1]);
        return new int[]{val2,val1};
    }
}
