import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class middle15 {
    /**
     * 双指针，形成三个数加和  i  left  right
     * 要考虑去重
     * if (i > 0 && nums[i] == nums[i-1]) continue; i中去重
     * while (left < right && nums[left] == nums[left+1]) left++;  [left,right]中去重
     * while (right > left && nums[right] == nums[right-1]) right--;
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            int left = i+1;
            int right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    res.add(List.of(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (right > left && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;

    }
}
