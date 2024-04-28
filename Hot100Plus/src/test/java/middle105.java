import utils.TreeNode;

public class middle105 {
    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * 前序遍历的第一个节点是根节点，之后从中序遍历找到根节点的index，之后划分左子树和右子树，递归构造左右子树。
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);

    }

    private TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inStart;
        while (inIndex <= inEnd && inorder[inIndex] != preorder[preStart]) {
            inIndex++;
        }

        root.left = build(preorder,inorder,preStart+1,preStart+inIndex-inStart,inStart,inIndex-1);
        root.right = build(preorder,inorder,preStart+inIndex-inStart+1,preEnd,inIndex+1,inEnd);

        return root;
    }
}
