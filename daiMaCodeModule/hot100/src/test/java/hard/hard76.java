package hard;

import java.util.HashMap;

public class hard76 {
    public static String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int count = t.length();
        int len = Integer.MAX_VALUE;
        int start = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) > 0) {
                count--;
            }
            map.put(c,map.getOrDefault(c,0)-1);

            if (count == 0) {
                while (map.get(s.charAt(left)) < 0) {
                    map.put(s.charAt(left),map.get(s.charAt(left)) +1);
                    left++;
                }
                if (len > right - left + 1) {
                    start = left;
                    len = right - left + 1;
                }

                map.put(s.charAt(left),map.get(s.charAt(left)) +1);
                left++;
                count++;
            }
        }

        if (len == Integer.MAX_VALUE) return "";

        return s.substring(start,start+len+1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        minWindow(s,t);
    }
}
