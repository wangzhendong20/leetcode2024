package middle;

public class middle45 {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int curDistance = 0;
        int nextDistance = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nextDistance,i+nums[i]);
            if (curDistance == i){
                ans++;
                curDistance = nextDistance;
                if (curDistance >= nums.length - 1) break;
            }
        }

        return ans;
    }
}
