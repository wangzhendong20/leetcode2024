public class middle45 {
    /**
     * 贪心：每次都跳到最大的距离那里
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;

        int curDis = 0; //当前最远的位置
        int nextDis = 0; //最远的位置
        int ans = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            nextDis = Math.max(nextDis, i+ nums[i]); //每次更新最远的位置
            if (curDis == i) { //到达当前最远位置了需要更新位置，跳数也加1
                ans++;
                curDis = nextDis; //更新当前最远位置
            }
        }
        return ans;
    }
}
