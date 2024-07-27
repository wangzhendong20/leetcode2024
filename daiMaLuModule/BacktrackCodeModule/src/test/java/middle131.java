import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class middle131 {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtrack(s,0);
        return res;
    }

    private void backtrack(String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isHuiWen(s, start, i)) {
                path.add(s.substring(start,i+1));
                backtrack(s,i+1);
                path.removeLast();
            }
        }
    }

    private boolean isHuiWen(String str, int start, int end) {
        if (start > end) return false;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
