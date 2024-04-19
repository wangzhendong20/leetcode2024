package tecentYinYue;

import javax.swing.tree.TreeNode;

public class code2 {

    class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public TreeNode create (int n) {
        if (n == 0) return null;

        TreeNode root = new TreeNode((int) Math.pow(2, n-1));

        root.left = create(n-1);
        root.right = create(n-1);

        return root;
    }
}
