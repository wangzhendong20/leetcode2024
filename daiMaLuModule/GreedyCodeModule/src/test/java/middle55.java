public class middle55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        int steps = 0;

        for (int i = 0; i <= steps; i++) {
            steps = Math.max(steps, i + nums[i]);
            if (steps >= nums.length - 1 ) {
                return true;
            }
        }
        return false;
    }
}
