public class simple283 {
    /**
     * 双指针
     * 遇到非0就填在数组前面
     * 之后后面就全是0
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }
}
