import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class simple94 {
    /**
     * 递归法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traverse(root,res);
        return res;
    }

    private void traverse(TreeNode root, List<Integer> res) {

        if (root == null) {
            return;
        }

        traverse(root.left,res);
        res.add(root.val);
        traverse(root.right,res);
    }


    /**
     * 迭代法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                if (cur.right!= null) stack.push(cur.right);
                stack.push(cur);
                stack.push(null);
                if (cur.left != null) stack.push(cur.left);
            } else {
                TreeNode node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }
}
