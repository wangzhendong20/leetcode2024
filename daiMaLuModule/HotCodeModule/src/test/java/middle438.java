import java.util.ArrayList;
import java.util.List;

public class middle438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        int[] map = new int[26];
        for (char c : p.toCharArray()) {
            map[c - 'a']++;
        }

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c - 'a']--;

            if (i - left + 1 == p.length()) {
                if (isSame(map)) {
                    result.add(left);
                }
                map[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return result;
    }

    private boolean isSame(int[] map) {
        for (int i = 0; i < map.length; i++) {
            if (map[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
