package base.digui;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 144
 */
public class preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode cur, List<Integer> result) {
        if (cur == null) {
            return;
        }

        result.add(cur.val);
        preorder(cur.left,result);
        preorder(cur.right,result);
    }

}
