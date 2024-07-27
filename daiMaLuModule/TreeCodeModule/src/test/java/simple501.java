import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class simple501 {
    int maxCount = 0;
    int count = 0;
    List<Integer> list = new ArrayList<Integer>();
    TreeNode prev = null;

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);

        if (prev == null) {
            count = 1;
        } else if (prev.val == root.val) {
            count++;
        } else {
            count = 1;
        }

        prev = root;

        if (count == maxCount) {
            list.add(root.val);
        } else if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(root.val);
        }

        traverse(root.right);
        return;

    }

    public int[] findMode(TreeNode root) {
        traverse(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
