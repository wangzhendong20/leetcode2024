import java.util.HashMap;
import java.util.HashSet;

public class hard76 {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        int count = t.length();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c) && map.get(c) > 0) {
                count--;
            }

            map.put(c, map.getOrDefault(c,0) - 1);

            if (count == 0) {
                while (left < i && map.get(s.charAt(left)) < 0) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    left++;
                }

                if (minLen > i - left + 1) {
                    minLen = i - left + 1;
                    start = left;
                }

                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                left++;
                count++;
            }

        }

        if (minLen == Integer.MAX_VALUE) {
            return  "";
        }

        return s.substring(start, start + minLen);

    }
}
