import java.util.HashMap;

public class hard76 {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int start = 0;
        int left = 0;
        int len = Integer.MAX_VALUE;
        int count = t.length();

        char[] ScharArray = s.toCharArray();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch) && map.get(ch) > 0) {
                count--;
            }
            map.put(ch, map.getOrDefault(ch,0)-1);

            if (count == 0) {
                while (map.get(s.charAt(left)) < 0) {
                    map.put(s.charAt(left), map.get(s.charAt(left))+1);
                    left++;
                }
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    start = left;
                }

                map.put(s.charAt(left), map.getOrDefault(s.charAt(left),0)+1);
                left++;
                count++;
            }
        }

        if (len == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + len);
    }
}
