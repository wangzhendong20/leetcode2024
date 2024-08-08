import utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class middle230 {
    int len = 0;
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root,k);
        return ans;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) return;

        traverse(root.left, k);
        len++;
        if (len == k) {
            ans = root.val;
            return;
        }

        traverse(root.right, k);
    }


    class MyBst {
        TreeNode root;
        HashMap<TreeNode,Integer> nodeNum;

        public MyBst(TreeNode root) {
            this.root = root;
            nodeNum = new HashMap<>();
        }

        public int kthSmallest(int k) {
            TreeNode node = root;
            while (node != null) {
                int left = getNodeNum(node.left);
                if (left < k - 1) {
                    node = node.right;
                    k -= left + 1;
                } else if (left == k - 1) {
                    break;
                } else {
                    node = node.left;
                }
            }

            return node.val;

        }


        private int countNodeNum(TreeNode node) {
            if (node == null) return 0;

            nodeNum.put(node, countNodeNum(node.left) + countNodeNum(node.right) + 1);
            return nodeNum.get(node);
        }

        private int getNodeNum(TreeNode node) {
            return nodeNum.getOrDefault(node,0);
        }

    }


    public int kthSmallest2(TreeNode root, int k) {
        MyBst myBst = new MyBst(root);
        int res = myBst.kthSmallest(k);
        return res;
    }
}
