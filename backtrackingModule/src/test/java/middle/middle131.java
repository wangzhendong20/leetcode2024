package middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class middle131 {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return res;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (huiWen(s,startIndex,i)) {
                path.add(s.substring(startIndex,i+1));
                backtracking(s,i+1);
                path.removeLast();
            } else {
                continue;
            }
        }
    }

    private boolean huiWen(String s, int left, int right) {
        for (int i = left,j=right; i < j; i++,j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
