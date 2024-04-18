package middle;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class middle113 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        path.add(root.val);
        traversal(root,targetSum - root.val);
        return res;
    }

    private void traversal(TreeNode node, int targetSum) {
        if (node.left == null && node.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (node.left == null && node.right == null) return;

        if (node.left != null) {
            path.add(node.left.val);
            targetSum -= node.left.val;
            traversal(node.left,targetSum);
            targetSum += node.left.val;
            path.removeLast();
        }

        if (node.right != null) {
            path.add(node.right.val);
            targetSum -= node.right.val;
            traversal(node.right,targetSum);
            targetSum += node.right.val;
            path.removeLast();
        }
        return;
    }
}
