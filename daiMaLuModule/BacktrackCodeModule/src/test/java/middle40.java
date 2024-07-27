import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class middle40 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtrack(candidates, target, 0, used);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, boolean[] used) {

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            if (i > 0 && candidates[i] == candidates[i-1] && used[i-1] == false) {
                continue;
            }
            used[i] = true;
            path.add(candidates[i]);
            backtrack(candidates,target - candidates[i], i+1, used);
            path.removeLast();
            used[i] = false;
        }
    }
}
