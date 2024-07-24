public class simple169 {
    /**
     * 计算统计，遇到不同的就count-1，如果count<0了就更新当前元素
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    num = nums[i];
                    count = 1;
                }
            }
        }
        return num;
    }
}
