package middle;

import utils.TreeNode;

import java.util.Arrays;

public class middle106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        return traversal(inorder,postorder);
    }

    private TreeNode traversal(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        int rootValue = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootValue);
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) break;
        }

        int[] leftInorder = Arrays.copyOfRange(inorder,0,i);
        int[] rightInorder = Arrays.copyOfRange(inorder,i+1,inorder.length);

        int[] leftPostorder = Arrays.copyOfRange(postorder,0,leftInorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder,leftInorder.length,postorder.length-1);

        root.left = traversal(leftInorder,leftPostorder);
        root.right = traversal(rightInorder,rightPostorder);

        return root;
    }
}
