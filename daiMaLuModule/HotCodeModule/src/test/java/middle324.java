import java.util.Arrays;

public class middle324 {
    /**
     * 排序后找到中点，然后左右两个部分分别从高到低插入到原数组中
     * 时间复杂度O(nlogn)，空间复杂度O(n)
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int len = arr.length;
        int mid = (len+1) / 2;

        for (int i = 0, j = mid - 1, k = len - 1; i < len; i+=2, j--,k--) {
            nums[i] = arr[j];
            if (i + 1 < len) {
                nums[i+1] = arr[k];
            }
        }
    }

}
