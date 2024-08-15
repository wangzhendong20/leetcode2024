import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class middle187 {
    /**
     * 哈希表+滑动窗口
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 10) {
            return res;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i+10);
            map.put(str, map.getOrDefault(str,0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }

        return res;
    }
}
