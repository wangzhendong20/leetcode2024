import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class middle216 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k,n,1);
        return res;
    }

    private void backtrack(int k, int sum, int startIndex) {
        if (sum < 0) {
            return;
        }

        if (path.size() == k) {
            if (sum == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            sum -= i;
            path.add(i);
            backtrack(k, sum, i+1);
            path.removeLast();
            sum += i;
        }
    }
}
