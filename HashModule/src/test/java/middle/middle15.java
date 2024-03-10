package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class middle15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int left,right;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组
                return result;
            }

            // 正确去重a方法
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            left = i+1;
            right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) right--;
                else if (nums[i] + nums[left] + nums[right] < 0) left++;
                else {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
