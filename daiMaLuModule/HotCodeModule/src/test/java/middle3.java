import java.util.HashMap;

public class middle3 {
    /**
     * 将字符串放入HashMap中，当遇到重复字符时，将左边界向右移动，直到重复字符不再出现，记录当前子串的长度，并更新最大长度
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (map.containsKey(c)) {
                map.remove(s.charAt(left));
                left++;
            }

            map.put(c, map.getOrDefault(c,0) + 1);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
