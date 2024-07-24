public class middle152 {
    /**
     * 考虑正负性分类讨论
     * dpmin[i]表示以i结尾的子数组的最小值(我们希望这个最小值是负数并且最小，那么再遇到负数的时候就会尽可能大)
     * dpmax[i]表示以i结尾的子数组的最大值
     * 状态转移方程：
     * dpmin[i] = min(dpmin[i-1] * nums[i], dpmax[i-1] * nums[i], nums[i])
     * dpmax[i] = max(dpmin[i-1] * nums[i], dpmax[i-1] * nums[i], nums[i])
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int[] dpmin = new int[nums.length];
        int[] dpmax = new int[nums.length];
        System.arraycopy(nums,0,dpmin,0,nums.length);
        System.arraycopy(nums,0,dpmax,0,nums.length);

        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dpmin[i] = Math.min(dpmin[i-1] * nums[i], Math.min(dpmax[i-1] * nums[i], nums[i]));
            dpmax[i] = Math.max(dpmin[i-1] * nums[i], Math.max(dpmax[i-1] * nums[i], nums[i]));
            max = Math.max(max,dpmax[i]);
        }

        return max;

    }
}
