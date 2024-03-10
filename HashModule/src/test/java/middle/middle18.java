package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class middle18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target && nums[i] >= 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] > target && nums[i]+nums[j] >= 0) break;
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = nums.length - 1;
                while (left < right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if ( sum == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left<right && nums[left] == nums[left+1]) left++;
                        while (left<right && nums[right] == nums[right-1]) right--;

                        left++;
                        right--;
                    }else if (sum > target){
                        right--;
                    }else {
                        left++;
                    }

                }
            }
        }
        return res;
    }
}
