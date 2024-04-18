package middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class middle491 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums,0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {

            if (path.size() > 0 && path.getLast() > nums[i] || set.contains(nums[i])) {
                continue;
            }

            path.add(nums[i]);
            set.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
        }
    }
}
