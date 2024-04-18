import java.util.HashMap;

public class hard76 {
    /**
     * 76. Minimum Window Substring
     * 哈希表+滑动窗口
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        int count = t.length();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) {
                count--;
            }
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (count == 0) {
                while (map.get(s.charAt(left)) < 0) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    left++;
                }
                if (len > i - left + 1) {
                    start = left;
                    len = i - left + 1;
                }

                map.put(s.charAt(left),map.get(s.charAt(left))+1);
                left++;
                count++;
            }
        }

        if (len == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start,start+len);
    }
}
