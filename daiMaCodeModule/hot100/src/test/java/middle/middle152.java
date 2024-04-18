package middle;

public class middle152 {
    /**
     * 考虑当前位置如果是一个负数的话，
     * 那么我们希望以它前一个位置结尾的某个段的积也是个负数，这样就可以负负得正，
     * 并且我们希望这个积尽可能「负得更多」，即尽可能小。
     * 如果当前位置是一个正数的话，
     * 我们更希望以它前一个位置结尾的某个段的积也是个正数，并且希望它尽可能地大。
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int[] dpmax = new int[nums.length];  // 记录最大的值
        int[] dpmin = new int[nums.length];  // 记录负数最小的值

        // 初始化为nums数组
        System.arraycopy(nums,0,dpmax,0,nums.length);
        System.arraycopy(nums,0,dpmin,0,nums.length);

        for (int i = 1; i < nums.length; i++) {
            dpmax[i] = Math.max(dpmax[i - 1] * nums[i], Math.max(nums[i], dpmin[i - 1] * nums[i]));
            dpmin[i] = Math.min(dpmin[i - 1] * nums[i], Math.min(nums[i], dpmax[i - 1] * nums[i]));
        }

        int ans = dpmax[0];
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, dpmax[i]);
        }

        return ans;
    }
}
