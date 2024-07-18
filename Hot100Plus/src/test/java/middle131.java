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


    private void backtrack(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (isHuiWen(sub)) {
                path.add(sub);
                backtrack(s,i+1);
                path.removeLast();
            } else {
                continue;
            }
        }
    }

    private boolean isHuiWen(String s) {
        int n = s.length();
        for (int i = 0 ,j = n - 1; i < j; i++,j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
