public class middle45 {
    public int jump(int[] nums) {

        int curIndex = 0;
        int nextIndex = 0;
        int step = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            nextIndex = Math.max(nextIndex, i+nums[i]);
            if (i == curIndex) {
                step++;
                curIndex = nextIndex;
            }
        }

        return step;
    }
}
