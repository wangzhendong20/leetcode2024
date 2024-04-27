import utils.TreeNode;

import java.util.Arrays;

public class simple108 {
    /**
     * 前序遍历
     * 分成两半然后递归建树
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Arrays.sort(nums);
        return buildTree(nums,0,nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {return null;}

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildTree(nums,start,mid - 1);
        root.right = buildTree(nums,mid+1,end);

        return root;
    }
}
