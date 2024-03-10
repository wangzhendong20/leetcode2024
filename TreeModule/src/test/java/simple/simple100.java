package simple;

import utils.TreeNode;

public class simple100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p,q);
    }

    private boolean compare(TreeNode p,TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null && q != null) return false;
        else if (p != null && q == null) return false;
        else if (p.val != q.val) return false;

        return compare(p.left,q.left) && compare(p.right,q.right);

    }
}
