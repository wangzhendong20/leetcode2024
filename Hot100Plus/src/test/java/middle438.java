import java.util.ArrayList;
import java.util.List;

public class middle438 {
    /**
     * 滑动窗口+哈希表
     * 当长度相等时进行判断，如果map中有小于0的就不是子串
     * 之后将窗口右移
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int[] map = new int[26];
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a']++;
        }
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']--;

            if (i - left + 1 == p.length()) {
                if (isSame(map)) {
                    res.add(left);
                }
                map[s.charAt(left) - 'a']++;
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));

    }

    private static boolean isSame(int[] map) {

        for (int i = 0; i < map.length; i++) {
            if (map[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
