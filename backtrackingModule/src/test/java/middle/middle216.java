package middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class middle216 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1);
        return res;
    }

    private void backtracking(int k, int n, int startIndex) {
        if (sum > n) {
            return;
        }

        if (path.size() == k) {
            if (n == sum) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            sum += i;
            path.add(i);
            backtracking(k,n,i+1);
            path.removeLast();
            sum -= i;
        }

    }
}
