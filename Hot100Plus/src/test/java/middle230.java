import utils.TreeNode;

import java.util.HashMap;

public class middle230 {

    int len = 0;
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        traversal(root,k);
        return ans;
    }

    private void traversal(TreeNode root,int k) {
        if (root == null) return;

        traversal(root.left,k);

        len++;
        if (len == k) {
            ans = root.val;
            return;
        }

        traversal(root.right,k);
    }

    public int kthSmallest2(TreeNode root, int k) {
        MyBst bst = new MyBst(root);
        return bst.kthSmallest(k);
    }

    class MyBst{
        TreeNode root;
        HashMap<TreeNode,Integer> map;

        public MyBst(TreeNode root) {
            this.root = root;
            this.map = new HashMap<>();
            countNodeNum(root);
        }

        private int countNodeNum(TreeNode node) {
            if (root == null) return 0;
            int left = countNodeNum(node.left);
            int right = countNodeNum(node.right);
            map.put(node,1+left+right);
            return map.get(node);
        }

        // 返回二叉搜索树中第k小的元素
        public int kthSmallest(int k) {
            TreeNode node = root;
            while (node != null) {
                int left = getNodeNum(node.left);
                if (left < k-1) {
                    node = node.right;
                    k -= left+1;
                } else if (left == k-1) {
                    break;
                } else {
                    node = node.left;
                }
            }
            return node.val;
        }

        private int getNodeNum(TreeNode node) {
            return map.getOrDefault(node,0);
        }
    }
}
