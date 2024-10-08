import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class middle90 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums,0,used);
        return res;
    }

    private void backtrack(int[] nums, int start, boolean[] used) {
        res.add(new ArrayList<>(path));
        if (start >= nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, i+1,used);
            used[i] = false;
            path.removeLast();
        }
    }
}
