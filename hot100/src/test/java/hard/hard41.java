package hard;

public class hard41 {
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
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

    private static void swap(int[] nums, int i ,int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
