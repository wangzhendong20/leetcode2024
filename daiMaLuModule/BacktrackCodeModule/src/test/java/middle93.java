import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class middle93 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backtrack(sb,0,0);
        return res;
    }

    private void backtrack(StringBuilder s, int start, int count) {
        if (count == 3) {
            if (isValid(s, start, s.length() - 1)) {
                res.add(s.toString());
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isValid(s, start, i)) {
                s.insert(i+1,".");
                backtrack(s,i+2,count+1);
                s.deleteCharAt(i+1);
            } else {
                break;
            }
        }
    }

    private boolean isValid(StringBuilder s, int start, int end) {
        if (start > end) return false;

        if (s.charAt(start) == '0' && start != end) return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;

            num = num * 10 + s.charAt(i) - '0';
            if (num > 255) return false;
        }

        return true;
    }
}
