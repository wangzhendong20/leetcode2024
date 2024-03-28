package middle;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class middle22 {
    List<String> ans = new ArrayList<>();
    LinkedList<Character> path = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return ans;
        }
        path.add('(');
        backtracking(n-1,n);
        return ans;
    }

    private void backtracking(int left, int right) {
        if (left > right) return;
        if (left == 0 && right == 0) {
            StringBuilder sb = new StringBuilder();
            for (Character c : path) {
                sb.append(c);
            }
            ans.add(String.valueOf(sb));
            return;
        }
        if (left > 0) {
            path.add('(');
            backtracking(left-1,right);
            path.removeLast();
        }
        if (right > 0) {
            path.add(')');
            backtracking(left,right-1);
            path.removeLast();
        }
    }
}
