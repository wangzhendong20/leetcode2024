public class middle45 {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;

        int curIndex = 0;
        int nextIndex = 0;
        int ans = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            nextIndex = Math.max(nextIndex, i + nums[i]);
            if (i == curIndex) {
                ans++;
                curIndex = nextIndex;
            }
        }

        return ans;
    }
}
