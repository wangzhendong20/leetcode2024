import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class simple257 {
    List<String> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        path.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i));
                sb.append("->");
            }
            sb.append(path.get(path.size()-1));
            res.add(sb.toString());
            return;
        }

        if (root.left != null) {
            traverse(root.left);
            path.removeLast();
        }

        if (root.right != null) {
            traverse(root.right);
            path.removeLast();
        }
    }
}
