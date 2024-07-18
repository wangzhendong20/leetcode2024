import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class middle78 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int startIndex) {
        if (startIndex > nums.length) {
            return;
        } else {
            res.add(new ArrayList<>(path));
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i+1);
            path.removeLast();
        }

    }

}
