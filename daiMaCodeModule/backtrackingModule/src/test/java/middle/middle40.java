package middle;

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
        backtracking(candidates,target,0,used);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex, boolean[] used) {

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && target - candidates[i] >= 0; i++) {
            if (i > 0 && candidates[i] == candidates[i-1] && used[i-1] == false) {
                continue;
            }

            path.add(candidates[i]);
            used[i] = true;
            backtracking(candidates,target-candidates[i],i+1,used);
            used[i] = false;
            path.removeLast();
        }
    }
}
