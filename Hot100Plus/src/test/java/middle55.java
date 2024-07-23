public class middle55 {
    /**
     * 贪心：看最远能跳到哪里
     * 每一步都保证能跳到下一步，所以只要判断最远能跳到哪里就行
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;
        int cover = 0;

        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i+ nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
