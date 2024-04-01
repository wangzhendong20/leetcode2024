package simple;

public class simple169 {
    /**
     * 选定一个元素设置count为1，如果下一个不相同就count--，相同就count++
     * 当count小于0时，当前元素已经被消耗完，需要重新记录
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ans) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                ans = nums[i];
                count = 1;
            }
        }
        return ans;
    }
}
