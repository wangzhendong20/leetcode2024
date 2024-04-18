package middle;

import utils.TreeNode;

import java.util.Arrays;

public class middle105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return traversal(preorder, inorder);
    }

    private TreeNode traversal(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        int index;
        for (index = 0; index < inorder.length; index++) {
            if (inorder[index] == rootValue) break;
        }

        int[] leftInorder = Arrays.copyOfRange(inorder,0, index);
        int[] rightInorder = Arrays.copyOfRange(inorder,index+1, inorder.length);

        int[] leftPreorder = Arrays.copyOfRange(preorder,1, 1 + leftInorder.length);
        int[] rightPreorder = Arrays.copyOfRange(preorder,1 + leftInorder.length, preorder.length);

        root.left = traversal(leftPreorder,leftInorder);
        root.right = traversal(rightPreorder,rightInorder);

        return root;
    }
}
