import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class middle39 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int startIndex, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && candidates[i] <= target; i++) {

            path.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i]);
            path.removeLast();

        }
    }
}
