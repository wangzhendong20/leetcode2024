package middle;

import utils.TreeNode;

public class middle654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traversal(nums,0,nums.length);
    }

    private TreeNode traversal(int[] nums, int left, int right) {
        if (left >= right) return null;
        int maxIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);
        if (maxIndex != left) {
            root.left = traversal(nums,left,maxIndex);
        }
        if (maxIndex != right-1) {
            root.right = traversal(nums,maxIndex+1,right);
        }
        return root;
    }
}
