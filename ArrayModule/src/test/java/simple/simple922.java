package simple;

public class simple922 {
    public int[] sortArrayByParityII(int[] nums) {
        int index = 1;
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] % 2 == 1) {
                while (nums[index] % 2 == 1) index += 2;
                swap(nums,i,index);
            }
        }

        return nums;
    }

    private void swap(int[] nums, int left , int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
