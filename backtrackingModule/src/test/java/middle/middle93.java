package middle;

import java.util.ArrayList;
import java.util.List;

public class middle93 {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtracking(new StringBuilder(s),0,0);
        return res;
    }

    /**
     *
     * @param sb
     * @param startIndex
     * @param pointNum  记录加点的数量
     */
    private void backtracking(StringBuilder sb, int startIndex, int pointNum) {
        if (pointNum == 3) {
            if (Valid(sb, startIndex, sb.length()-1)) {
                res.add(new String(sb));
            }
            return;
        }

        for (int i = startIndex; i < sb.length(); i++) {
            if (Valid(sb,startIndex,i)) {
                pointNum++;
                sb.insert(i+1,'.');
                backtracking(sb,i+2,pointNum);
                sb.deleteCharAt(i+1);
                pointNum--;
            } else continue;
        }

    }

    /**
     * 段位以0为开头的数字不合法
     * 段位里有非正整数字符不合法
     * 段位如果大于255了不合法
     * @param sb
     * @param start
     * @param end
     * @return
     */
    private boolean Valid(StringBuilder sb, int start, int end) {
        if (start > end) {
            return false;
        }
        if (sb.charAt(start) == '0' && start != end) {
            return false;
        }

        int num = 0;
        for (int i = start; i <= end; i++) {
            if (sb.charAt(i) > '9' || sb.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + sb.charAt(i) - '0';
            if (num > 255) return false;
        }
        return true;
    }
}
