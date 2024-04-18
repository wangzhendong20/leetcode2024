public class hard41 {
    /**
     * 41. First Missing Positive
     * 置换，将符合1-n的正数都换到他们对应的位置，然后判断位置上不等于的就是缺失的第一个正数。
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i]-1] != nums[i]) {
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return len+1;
    }
}
