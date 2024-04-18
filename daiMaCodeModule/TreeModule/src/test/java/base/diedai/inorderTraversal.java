package base.diedai;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<>();

        if (root == null) return result;
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                //指针来访问节点 将访问的节点放进栈   往左下访问
                stack.push(cur);
                cur = cur.left;  //左
            } else {
                // 从栈里弹出的数据，就是要处理的数据（放进result数组里的数据）
                cur = stack.pop();
                result.add(cur.val);  // 中
                cur = cur.right;    //右
            }
        }
        return result;
    }

}
