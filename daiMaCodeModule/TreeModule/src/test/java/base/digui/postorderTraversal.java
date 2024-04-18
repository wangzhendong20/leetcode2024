package base.digui;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode cur, List<Integer> result) {
        if (cur == null) {
            return;
        }

        postorder(cur.left,result);
        postorder(cur.right,result);
        result.add(cur.val);
    }
}
