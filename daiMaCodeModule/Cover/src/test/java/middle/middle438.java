package middle;

import java.util.ArrayList;
import java.util.List;

public class middle438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] hash = new int[26];
        for (int i = 0; i < p.length(); i++) {
            hash[p.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;
        List<Integer> res = new ArrayList<>();

        while (right < s.length()) {
            if (hash[s.charAt(right) - 'a'] > 0) {
                hash[s.charAt(right) - 'a']--;
                right++;
                if (right - left == p.length()) {
                    res.add(left);
                }
            } else {
                hash[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return res;
    }
}
