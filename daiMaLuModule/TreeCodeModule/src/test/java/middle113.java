import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class middle113 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        path.add(root.val);
        traverse(root, targetSum - root.val);
        return res;
    }

    private void traverse(TreeNode root, int sum) {
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.left != null) {
            path.add(root.left.val);
            traverse(root.left, sum - root.left.val);
            path.removeLast();
        }

        if (root.right != null) {
            path.add(root.right.val);
            traverse(root.right, sum - root.right.val);
            path.removeLast();
        }
    }
}
