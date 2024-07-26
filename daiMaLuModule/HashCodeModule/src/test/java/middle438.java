import java.util.ArrayList;
import java.util.List;

public class middle438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] hash = new int[26];
        p.chars().forEach(c -> hash[c-'a']++);

        int len = p.length();
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']--;
            if (i >= len - 1) {
                if (isValid(hash)) {
                    result.add(left);
                }

                hash[s.charAt(left)-'a']++;
                left++;
            }
        }

        return result;
    }

    private boolean isValid(int[] hash) {
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
