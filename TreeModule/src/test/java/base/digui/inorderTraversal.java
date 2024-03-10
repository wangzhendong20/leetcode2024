package base.digui;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode cur, List<Integer> result) {
        if (cur == null) {
            return;
        }

        inorder(cur.left,result);
        result.add(cur.val);
        inorder(cur.right,result);
    }
}
