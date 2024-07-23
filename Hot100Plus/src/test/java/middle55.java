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

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums.length - i - 1) {
                return true;
            }
        }

        return false;
    }
}
