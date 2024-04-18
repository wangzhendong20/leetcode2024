package hard;

import java.util.HashMap;

public class hard76 {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0) + 1);
        }
        //将所需要的字符加入到map中，count为所需字符的数量
        int size = Integer.MAX_VALUE;
        int left = 0, count = t.length(), start = 0;   // start为最终的开始位置
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            //如果需要该字符就减少count
            if (map.containsKey(c) && map.get(c) > 0) {
                count--;
            }
            map.put(c, map.getOrDefault(c,0)-1);
            if (count == 0) {
                //当前窗口满了
                while (map.get(s.charAt(left)) < 0) {
                    // 排除左边不必要的字符
                    map.put(s.charAt(left),map.get(s.charAt(left)) + 1);
                    left++;
                }
                // 确定最小长度
                if (right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;
                }
                //左边减小窗口
                map.put(s.charAt(left),map.get(s.charAt(left)) + 1);
                left++;
                count++;
            }
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start,start+size);
    }
}
