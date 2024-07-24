import java.util.Arrays;

public class middle31 {
    /**
     * 从后往前找到降序的两个数交换位置，之后这个位置之后的数重新排序
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        for (int i = nums.length-1; i >= 0 ; i--) {
            for (int j = nums.length-1; j > i ; j--) {
                if (nums[j] > nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    Arrays.sort(nums, i + 1 ,nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }
}
