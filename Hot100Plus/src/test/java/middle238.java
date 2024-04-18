public class middle238 {
    /**
     * 238. 除自身以外数组的乘积
     * 记录当前元素的左边乘积前缀和和右边乘积前缀和
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] LSum = new int[nums.length];
        int[] RSum = new int[nums.length];
        LSum[0] = 1;
        RSum[nums.length-1] = 1;
        for (int i = 1; i < nums.length; i++) {
            LSum[i] = LSum[i-1] * nums[i-1];
        }

        for (int i = nums.length-2; i >= 0; i--) {
            RSum[i] = RSum[i+1] * nums[i+1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = LSum[i] * RSum[i];
        }

        return ans;

    }
}
