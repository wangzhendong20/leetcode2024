package xiapi;

import java.util.Map;
import java.util.TreeMap;

public class code2 {
    public String mostFrequentSubstring(String s, int k) {
        if (k == 0 || k > s.length()) {
            return "";
        }
        if (k == s.length()) {
            return s;
        }
        TreeMap<String, Integer> map = new TreeMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int j = i + k;
            if (j > n) {
                break;
            }
            String sub = s.substring(i, i + k);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }

        int maxCount = 0;
        String result = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }
}
