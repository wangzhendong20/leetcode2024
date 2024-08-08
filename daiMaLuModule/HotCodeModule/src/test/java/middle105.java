import utils.TreeNode;

public class middle105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }


    private TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        int index = inStart;
        while (index <= inEnd && inorder[index] != rootVal) {
            index++;
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder,inorder, preStart + 1, preStart + index - inStart, inStart, index - 1);
        root.right = build(preorder, inorder, preStart + index - inStart + 1, preEnd, index + 1, inEnd);

        return root;
    }
}
