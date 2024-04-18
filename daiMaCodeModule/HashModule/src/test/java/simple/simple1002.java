package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class simple1002 {
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();

        int[] hash = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            hash[words[0].charAt(i) - 'a']++;
        }


        for (int i = 1; i < words.length; i++) {
            int[] otherHash = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                otherHash[words[i].charAt(j) - 'a']++;
            }

            for (int k = 0; k < 26; k++) {
                hash[k] = Math.min(hash[k],otherHash[k]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (hash[i] != 0) {
                char c = (char) (i + 'a');
                res.add(String.valueOf(c));
                hash[i]--;
            }
        }
        return res;
    }
}
