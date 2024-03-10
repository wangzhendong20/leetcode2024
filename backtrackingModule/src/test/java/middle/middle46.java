package middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class middle46 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums,used);
        return res;
    }

    private void backtracking(int[] nums, boolean[] used) {
        if (nums.length == path.size()) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) continue;
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums,used);
            path.removeLast();
            used[i] = false;
        }
    }
}
