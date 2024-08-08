public class middle55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;

        int maxIndex = 0;
        for (int i = 0; i <= maxIndex; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (maxIndex >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
