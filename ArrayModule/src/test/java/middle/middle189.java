package middle;

public class middle189 {
    public void rotate(int[] nums, int k) {
        int fast = nums.length - k % nums.length;
        reverse(nums,0,fast-1);
        reverse(nums,fast, nums.length-1);
        reverse(nums,0, nums.length-1);
    }

    private void reverse(int[] nums, int left, int right) {
        for (int i = left,j = right; i < j; i++,j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
