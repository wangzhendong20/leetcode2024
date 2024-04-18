package simple;


import utils.TreeNode;

public class simple543 {
    int res = 1;  //表示参与的节点数
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return res - 1;
    }

    /**
     * 因为需要返回参与的节点数所以需要后序遍历
     * 单层逻辑：到中间节点的时候需要就算该根节点左面到右面的最大长度
     * 返回值：因为过了该中间节点只能选左右的一边，所以选更大的一面
     * @param root
     * @return
     */
    private int traversal(TreeNode root) {
        if (root == null) return 0;

        int left = traversal(root.left);
        int right = traversal(root.right);

        int len = 1 + Math.max(left,right);
        res = Math.max(res, left + right + 1);
        return len;
    }
}
