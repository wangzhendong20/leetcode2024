import utils.TreeNode;

public class middle654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traverse(nums,0, nums.length-1);
    }

    private TreeNode traverse(int[] nums, int start, int end) {
        if (start > end) return null;
        int maxValue = nums[start];
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(maxValue);

        root.left = traverse(nums, start, maxIndex - 1);
        root.right = traverse(nums, maxIndex + 1, end);

        return root;
    }
}
