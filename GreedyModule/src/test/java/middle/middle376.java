package middle;

public class middle376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int pre = 0;
        int cur = 0;
        int ans = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            cur = nums[i+1] - nums[i];
            if ((pre <= 0 && cur > 0) || (pre >= 0 && cur < 0)) {
                ans++;
                pre = cur; // 注意这里，只在摆动变化的时候更新pre
            }
        }
        return ans;
    }

}
