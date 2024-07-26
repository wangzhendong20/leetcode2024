public class middle209 {
    public int minSubArrayLen(int target, int[] nums) {
        int slow = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];
            while (sum >= target) {
                minLen = Math.min(minLen, fast - slow + 1);
                sum -= nums[slow++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
