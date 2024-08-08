import java.util.Arrays;

public class middle152 {
    public int maxProduct(int[] nums) {
        int[] minNums = new int[nums.length];
        int[] maxNums = new int[nums.length];

        System.arraycopy(nums, 0 , minNums, 0 ,nums.length);
        System.arraycopy(nums, 0 , maxNums ,0 ,nums.length);

        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            minNums[i] = Math.min(nums[i], Math.min(minNums[i-1] * nums[i], maxNums[i-1] * nums[i]));
            maxNums[i] = Math.max(nums[i], Math.max(maxNums[i-1] * nums[i], minNums[i-1] * nums[i]));
            max = Math.max(max, maxNums[i]);
        }


        return max;
    }
}
