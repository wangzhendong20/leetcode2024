import java.util.ArrayList;
import java.util.List;

public class middle763 {
    /**
     * 贪心：先统计每个字符的最远位置，之后根据最远位置分割字符串。
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<Integer>();
        int[] hash = new int[26];
        // 统计每个字符的最远位置
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            //找到当前要分割字符串的最远位置
            right = Math.max(right, hash[s.charAt(i) - 'a']);
            if (i == right) { // 到了最远位置了就是分割点
                res.add(right - start + 1);
                start = i+1;
            }
        }
        return res;

    }
}
