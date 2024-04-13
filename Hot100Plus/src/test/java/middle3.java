import java.util.HashMap;

public class middle3 {
    /**
     * 滑动窗口+哈希表
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();

        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (map.containsKey(c)) {
                map.remove(s.charAt(left));
                left++;
            }
            map.put(c,map.getOrDefault(c,0)+1);
            max = Math.max(max,i - left + 1);
        }

        return max;
    }
}
