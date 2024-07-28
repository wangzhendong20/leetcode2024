public class middle376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int preDiff = 0;
        int curDiff = 0;
        int count = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i+1] - nums[i];
            // 出现峰值
            if (preDiff <= 0 && curDiff > 0 || preDiff >= 0 && curDiff < 0) {
                count++;
                preDiff = curDiff; //只在摆动变化的时候更新prediff
            }
        }

        return count;
    }
}
