package middle;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class middle129 {

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        StringBuilder sumStr = new StringBuilder();
        List<Integer> sumList = new ArrayList<>();
        int sum = 0;
        traversal(root,sumStr,sumList);
        for (Integer integer : sumList) {
            sum += integer;
        }
        return sum;
    }

    private void traversal(TreeNode root, StringBuilder sumStr,List<Integer> sumList) {
        sumStr.append(root.val);

        if (root.left == null && root.right == null) {
            sumList.add(Integer.valueOf(sumStr.toString()));
            return;
        }

        if (root.left != null) {
//            sumStr.append(root.val);
            traversal(root.left,sumStr,sumList);
            sumStr.deleteCharAt(sumStr.length()-1);
        }

        if (root.right != null) {
//            sumStr.append(root.val);
            traversal(root.right,sumStr,sumList);
            sumStr.deleteCharAt(sumStr.length()-1);
        }
    }
}
