package middle;

import java.util.ArrayList;
import java.util.List;

public class middle763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] hash = new int[26];
        //统计每个字符最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, hash[s.charAt(i) - 'a']);
            //如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点
            if (i == right) {
                ans.add(right - left + 1);
                left = i+1;
            }
        }
        return ans;
    }
}
