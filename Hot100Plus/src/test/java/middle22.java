import java.util.ArrayList;
import java.util.List;

public class middle22 {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }
        sb.append("(");
        backtrack(n-1,n);
        return res;
    }

    private void backtrack(int left, int right) {
        if (left > right) return;

        if (left == 0 && right == 0) {
            res.add(new String(sb));
            return;
        }

        if (left > 0) {
            sb.append("(");
            backtrack(left-1,right);
            sb.deleteCharAt(sb.length()-1);
        }

        if (right > 0) {
            sb.append(")");
            backtrack(left,right-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
